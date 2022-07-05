package com.garotinho.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.garotinho.course.entities.User;
import com.garotinho.course.services.UserService;

@RestController
@RequestMapping(value="/users") // caminho
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping // users/
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}") // Possivel rota ao entrar no users Ex : users/3
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    

}
