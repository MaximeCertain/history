package com.examplet.demo.controller;

import com.examplet.demo.beans.Race;
import com.examplet.demo.beans.User;
import com.examplet.demo.repository.UserRepository;
import com.examplet.demo.service.auth.payload.request.LoginRequest;
import com.examplet.demo.service.auth.security.services.UserDetailsImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.mapping.Any;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AuthControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    UserRepository userRepository;

    @MockBean
    Authentication authentication;
    @MockBean
    AuthenticationManager authenticationManager;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

//https://www.javatips.net/api/org.springframework.security.authentication.authenticationmanager
    @Test
    public void testLogin() throws Exception {

        User mockUser = new User("art78", "art78", "art78");
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("art78");
        loginRequest.setUsername("art78");
        String uri = "/api/auth/signin";

        //mock le findByUsername
        Mockito.when(userRepository.findByUsername(any(String.class))).thenReturn(java.util.Optional.of(mockUser));
        //fake l'authentification
        Mockito.when(authenticationManager.authenticate(Mockito.<Authentication> any()))
                .thenReturn(new UsernamePasswordAuthenticationToken("art78", "art78"));

        Authentication authentication = Mockito.mock(Authentication.class);
        List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
        UserDetailsImpl userDetails = new UserDetailsImpl(1, "art78", "art78", "art78", listAuthorities);
        Mockito.when(authentication.getPrincipal()).thenReturn(userDetails);
        Mockito.when(authenticationManager.authenticate(Mockito.isA(Authentication.class))).thenReturn(authentication);

        String jsonRequest = mapper.writeValueAsString(loginRequest);

        System.out.println(jsonRequest);
        MvcResult result = mockMvc.perform(post(uri).content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(200 , result.getResponse().getStatus());
    }
}
