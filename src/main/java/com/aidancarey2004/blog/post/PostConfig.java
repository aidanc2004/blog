package com.aidancarey2004.blog.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args -> {
            Post post1 = new Post(
                    "Aidan Carey",
                    "Post 1",
                    "This is post number one!",
                    LocalDate.now()
            );

            Post post2 = new Post(
                    "Author",
                    "Post 2",
                    "This is post number two!",
                    LocalDate.of(2024, Month.JUNE, 23)
            );

            repository.saveAll(
                    List.of(post1, post2)
            );
        };
    }
}
