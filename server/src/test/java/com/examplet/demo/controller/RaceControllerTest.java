package com.examplet.demo.controller;

import com.examplet.demo.beans.Race;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//lance me serveur pour chaque test sur un port différent
public class RaceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;  //instancie automatiquement un objet TestRestTemplate
    //la méthode getForObject()  permet de récupérr le body de la requête HTTP response

    @Test
    public void return_test() {
        String body = this.restTemplate.getForObject("/race/hello",  String.class);
        assertThat(body).isEqualTo("hello world");
    }

    @Test
    public void testRaceById() {
        Race race = this.restTemplate.getForObject("/race/get/1",  Race.class);
        assertThat(race.getId()).isEqualTo(1);
    }

    @Test
    public void addRaceTest() {
        String uri = "/race/add";
        Race race = new Race();
        race.setName("nouvelle étape");
        this.restTemplate.postForEntity(uri, race, String.class);
        assertThat(race.getId()).isEqualTo(1);
    }
}
