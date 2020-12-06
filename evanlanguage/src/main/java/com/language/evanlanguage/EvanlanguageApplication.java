package com.language.evanlanguage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.language.service.WordService;

@SpringBootApplication
@ComponentScan(basePackages = "com.language.*")
@EntityScan(basePackages = "com.language.*")
@EnableJpaRepositories(basePackages = "com.language.*")
public class EvanlanguageApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvanlanguageApplication.class, args);
    }

    @Autowired
    WordService myService;

    @Bean
    public CommandLineRunner repoTest() {
        return args -> {
            /*
             * myService.saveAggregatedWord(new Word("Japanese", "shield", "tate", "noun"),
             * new Symbols("盾", "たて"), new WordSource("tatenoyuusha"));
             * myService.saveAggregatedWord(new Word("Japanese", "hero", "yuusha", "noun"),
             * new Symbols("勇者", "ゆうしゃ"), new WordSource("tatenoyuusha"));
             * myService.saveAggregatedWord(new Word("English", "meaning", "meaning",
             * "noun"), null, null);
             */
            myService.printAll();
        };
    }
}
