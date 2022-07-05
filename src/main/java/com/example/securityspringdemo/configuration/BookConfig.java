package com.example.securityspringdemo.configuration;


import com.example.securityspringdemo.dao.BookRepo;
import com.example.securityspringdemo.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner cmdRunBook(BookRepo bookRepo) {
        return args -> {
            Book b1 = new Book(
                    "The Lord of the Rings",
                    "J. R. R. Tolkien"
            );
            Book b2 = new Book(
                    "Harry Potter and the Philosophers Stone",
                    "J. K. Rowling"
            );
            bookRepo.saveAll(List.of(
                    b1, b2
            ));
        };
    }
}
