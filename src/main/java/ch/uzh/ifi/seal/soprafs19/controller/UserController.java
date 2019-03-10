package ch.uzh.ifi.seal.soprafs19.controller;

import ch.uzh.ifi.seal.soprafs19.entity.User;
import ch.uzh.ifi.seal.soprafs19.repository.UserRepository;
import ch.uzh.ifi.seal.soprafs19.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService service;

    UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    Iterable<User> all() {
        return service.getUsers();
    }

    @PostMapping("/users") // has to modified to allow registration
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try{
            this.service.createUser(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED); //returns status code 201, add user
    }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //returns the Status code 409, add user failed because username already exists
        }

    @PostMapping("/login") // create a method like the previous one that allows login
    public ResponseEntity<User>

    @PutMapping("/user/{id}") // create a method in order to update the user info

    @GetMapping("/user/{id}") // method that finds a user by his id (use the method in UserService)
}
