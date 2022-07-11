package com.garotinho.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.garotinho.course.entities.User;
import com.garotinho.course.repositories.UserRepository;
import com.garotinho.course.services.exceptions.DataBaseException;
import com.garotinho.course.services.exceptions.ResourceNotFoundException;


//Serviço da minha aplicação
@Service 
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id) {
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException error){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException error){
            throw new DataBaseException("Não mate os pais sem matar os filhos");
        }
    }

    public User update(Long id, User user){
        try{
            User entity = repository.getOne(id);
            updateData(entity, user);
            return repository.save(entity);
        }catch(EntityNotFoundException error){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setFone(user.getFone());
    }
}
