package org.arbfile.oidc.example.controller;

import org.arbfile.oidc.example.entity.User;
import org.arbfile.oidc.example.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController
{
    private UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @CrossOrigin("http://localhost:4200")
    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User find(@PathVariable("id") Long id)
    {
        return this.userRepository.findOne(id);
    }
}
