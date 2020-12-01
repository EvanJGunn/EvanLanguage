package com.language.evanlanguage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.language.entity.Symbols;
import com.language.entity.Word;
import com.language.entity.WordSource;
import com.language.repository.WordRepository;
import com.language.service.WordService;


@SpringBootApplication
@ComponentScan(basePackages="com.language.*")
@EntityScan(basePackages="com.language.*")
@EnableJpaRepositories(basePackages="com.language.*")
public class EvanlanguageApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(EvanlanguageApplication.class, args);
	}
	
	@Autowired
    WordService myService;
	
    @Bean
    public CommandLineRunner repoTest() {
        return args -> {
            myService.saveAggregatedWord(new Word("hi","g","g","g"), new Symbols("main","reading"), new WordSource("source"));
        };
    }
}
