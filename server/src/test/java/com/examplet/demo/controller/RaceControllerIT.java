package com.examplet.demo.controller;

import com.examplet.demo.beans.Comment;
import com.examplet.demo.beans.Race;
import com.examplet.demo.repository.RaceRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@WebMvcTest(controllers = {RaceController.class})
@ExtendWith(SpringExtension.class)
public class RaceControllerIT {

    //ici pas de mocks
    @Autowired
    private RaceRepository raceRepository;

    //tests d'intégraiton compposants : identiques aux unitaires, mais on peut ne pas utiliser de mocks
    /*Les tests d’intégration composants valident que les unités de code déjà testées unitairement collaborent réellement comme leurs mocks le faisaient*/
    private void testAddRaceIt() {
        Optional<Race> race = raceRepository.findById(1);   // le test se concentre donc sur cette méthode getCommetnById
        assertThat(race).isInstanceOf(Race.class);
    }

    //tests d'intégration système démarche similaire mais on peut faire appel à d'autres composants/services externes, plus large que les intégrations par composant




}
