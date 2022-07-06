package com.garotinho.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.garotinho.course.entities.Order;
import com.garotinho.course.entities.User;
import com.garotinho.course.repositories.OrderRepository;
import com.garotinho.course.repositories.UserRepository;

@Configuration @Profile("test")
public class TestConfig implements CommandLineRunner{ //Interface que executa comandos quando a aplicação for iniciada
    //Injeção de dep
    @Autowired // Coloca uma instancia de userRepository automaticamente
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99988888", "12345678");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "99988888", "12345678");
        
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); //Horario Padrao UTC
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }


}
