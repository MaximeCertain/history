package com.examplet.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.examplet.demo.LoggingExtension;
import com.examplet.demo.beans.Race;
import com.examplet.demo.repository.RaceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(LoggingExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MvcControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RaceRepository userRepository;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    private Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @WithAnonymousUser()
    @Test
    public void testSavePerson() throws Exception {
        logger.info("appel avant test");
        String uri = "/race/add";
        Race race = new Race();
        race.setName("nouvelle étape");

        //fake l'enregistrement en base
        when(userRepository.save(any(Race.class))).thenReturn(race);

        String jsonRequest = mapper.writeValueAsString(race);
        MvcResult result = mockMvc.perform(post(uri).content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentAsString());
        assertEquals(200, result.getResponse().getStatus());
    }

    @WithMockUser("/javatechie-1")
    @Test
    public void testgetPersons() throws Exception {

        MvcResult result = mockMvc.perform(get("/race/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        System.out.println(result.getResponse().getContentType());

        assertEquals(200, result.getResponse().getStatus());
    }


    @WithMockUser("/javatechie-1")
    @Test
    public void testReturnHelloWorld() throws Exception {

        MvcResult result = mockMvc.perform(get("/race/hello").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertEquals("hello world", result.getResponse().getContentAsString());
    }

  /*  @Test
  @ParametrizedTest("desc") => réutiliser le même test avec plusieurs parametres (ValueSource ou CsvSource)
  	@ValueSource(ints = { 1, 2, 42, 1011, 5089 })  tester avec plusieurs valeurs
  	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })  => plusieurs variables à chaque test différent
  	@Timeout(2) => fait échouer le test s'il prend plus de 2 secondes
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;
        Calculator calculator = new Calculator();

        // Act
        int somme = calculator.add(a, b);

        // Assert
        assertEquals(5, somme);

        //puis implémenter la fonciton de la classe calcultator

        //le test doit désormais passer
    }*/
    private static Instant startedAt = Instant.now();

    @BeforeAll //executé que tous les tests commence
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll //execute aprèsn tous les tests
    static public void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    /**
     * Un code est couvert par les tests s'il est exécuté par au moins un test.
     * La couverture de tests est en fait la proportion entre la quantité de code couverte par vos tests et la quantité de code totale
     * 	@Tag("QuatreOperations") // ce test fait partie des tests des 4 opérations de base
     * 	@DisplayName("L'aire d'un disque de rayon 1 doit valoir PI.") => nommer les tests de façon lisible
     * 	@Nested vous permet de grouper vos tests dans une classe interne. Avec @Nested, si un seul test échoue, tout le groupe désigné par cette annotation échoue !
     * 	@Disabled("Stoppé car cela échoue tous les mardis") => le test ne s'executera pas !
     *
     */

}
