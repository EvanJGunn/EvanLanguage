package com.language.evanlanguage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Rest controller controls the mappings for requests
 * 
 * @author Evan Gunn
 */
@RestController
public class MyRestController {
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to Evan Language";
    }
}
