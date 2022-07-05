package com.garotinho.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.garotinho.course.entities.User;

@RestController
@RequestMapping(value="/users") // caminho
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Rafael", "@gmail.com", "99999", "pasdlas");
        return ResponseEntity.ok().body(u);
    }

}
