package fr.jordanSI06.javaBooks.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.jordanSI06.javaBooks.dto.LivreDTO;
import fr.jordanSI06.javaBooks.mappers.LivreMapper;
import fr.jordanSI06.javaBooks.models.Livre;
import fr.jordanSI06.javaBooks.services.LivreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LivreController.class)
class LivreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivreService livreService;
    @MockBean
    private LivreMapper livreMapper; 

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllLivres() throws Exception {
        List<Livre> livres = Arrays.asList(
                new Livre(1L, "Dune", "Frank Herbert", "9780441013593")
        );
        Mockito.when(livreService.getAllLivres()).thenReturn(livres);
        Mockito.when(livreMapper.toDTO(Mockito.any(Livre.class)))
       .thenAnswer(invocation -> {
           Livre livre = invocation.getArgument(0);
           return new LivreDTO(livre.getId(), livre.getTitre(), livre.getAuteur(), livre.getIsbn());
       });

        mockMvc.perform(get("/api/livres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].titre").value("Dune"))
                .andExpect(jsonPath("$[0].auteur").value("Frank Herbert"))
                .andExpect(jsonPath("$[0].isbn").value("9780441013593"));
    }

    @Test
    void testCreerLivre() throws Exception {
        LivreDTO livreDTO = new LivreDTO(1L, "Dune", "Frank Herbert", "9780441013593");

        Livre livre = new Livre(1L, "Dune", "Frank Herbert", "9780441013593");
        Mockito.when(livreService.ajouterLivre(Mockito.any())).thenReturn(livre);
        Mockito.when(livreMapper.toDTO(Mockito.any(Livre.class)))
        .thenAnswer(invocation -> {
            Livre livreMapped = invocation.getArgument(0);
            return new LivreDTO(livreMapped.getId(), livreMapped.getTitre(), livreMapped.getAuteur(), livreMapped.getIsbn());
        });

        mockMvc.perform(post("/api/livres")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livreDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titre").value("Dune"))
                .andExpect(jsonPath("$.auteur").value("Frank Herbert"))
                .andExpect(jsonPath("$.isbn").value("9780441013593"));
    }
}