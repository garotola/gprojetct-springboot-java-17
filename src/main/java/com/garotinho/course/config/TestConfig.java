package com.garotinho.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.garotinho.course.entities.User;
import com.garotinho.course.repositories.UserRepository;

@Configuration @Profile("test")
public class TestConfig implements CommandLineRunner{ //Interface que executa comandos quando a aplicação for iniciada
    //Injeção de dep
    @Autowired // Coloca uma instancia de userRepository automaticamente
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99988888", "12345678");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "99988888", "12345678");
        
        userRepository.saveAll(Arrays.asList(u1,u2));
    }


}
