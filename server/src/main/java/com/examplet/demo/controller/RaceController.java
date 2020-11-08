package com.examplet.demo.controller;

import com.examplet.demo.beans.Race;
import com.examplet.demo.repository.RaceRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/race")
@Component
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @PostMapping(path = "/add")
    public String addNewRace(@RequestBody Race race) {
        raceRepository.save(race);
        return "object saved";
    }

    @GetMapping("/all")
    public Iterable<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteRace(@PathVariable("id") int id) {
        raceRepository.deleteById(id);
        return "object_deleted";
    }

    @GetMapping("/get/{id}")
    Race getById(@PathVariable int id) throws NotFoundException {
        return raceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));
    }

    @PutMapping("/put/{id}")
    public String updateRace(@PathVariable("id") int id, @RequestBody Race race) throws NotFoundException {
        Race raceUpated = new Race();
        BeanUtils.copyProperties(race, raceUpated);
        raceUpated.setId(id);
        raceRepository.save(raceUpated);
        return "object saved";
    }
}
