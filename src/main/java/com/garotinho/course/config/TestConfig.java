package com.garotinho.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.garotinho.course.entities.Category;
import com.garotinho.course.entities.Order;
import com.garotinho.course.entities.Product;
import com.garotinho.course.entities.User;
import com.garotinho.course.entities.enums.OrderStatus;
import com.garotinho.course.repositories.CategoryRepository;
import com.garotinho.course.repositories.OrderRepository;
import com.garotinho.course.repositories.ProductRepository;
import com.garotinho.course.repositories.UserRepository;

@Configuration @Profile("test")
public class TestConfig implements CommandLineRunner{ //Interface que executa comandos quando a aplicação for iniciada
    //Injeção de dep
    @Autowired // Coloca uma instancia de userRepository automaticamente
    private UserRepository userRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "99988888", "12345678");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "99988888", "12345678");
        
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID); //Horario Padrao UTC
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

        Category c1 = new Category(null, "Eletronicos");
        Category c2 = new Category(null, "Livros");
        Category c3 = new Category(null, "Computadores");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }


}
