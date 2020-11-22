package com.examplet.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import com.examplet.demo.beans.Race;
import com.examplet.demo.repository.RaceRepository;
import org.junit.Before;
import org.junit.Test;
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

    @WithAnonymousUser()
    @Test
    public void testSavePerson() throws Exception {
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
}
