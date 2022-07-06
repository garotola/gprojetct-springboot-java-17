package com.garotinho.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garotinho.course.entities.Category;
import com.garotinho.course.services.CategoryService;

@RestController
@RequestMapping(value="/categories") // caminho
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping // users/
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}") // Possivel rota ao entrar no users Ex : users/3
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    

}
