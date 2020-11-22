package com.examplet.demo.controller;

import com.examplet.demo.beans.Race;
import com.examplet.demo.beans.User;
import com.examplet.demo.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController //:annotation qui montre que ce controlleur va envoyer des objets au lieu de vues
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/get/{id}")
    public User getUser(@PathVariable("id") int id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("not found"));
    }

    @PutMapping("/user/put/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
        User userUpdated = new User();
        BeanUtils.copyProperties(user, userUpdated);
        userUpdated.setId(id);
        userRepository.save(userUpdated);
        return "object_edited";
    }

    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public String postUser(@RequestBody User user) {
        userRepository.save(user);
        return "object_savec";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "object deleted";
    }
}
