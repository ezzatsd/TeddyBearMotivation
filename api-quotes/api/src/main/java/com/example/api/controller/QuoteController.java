package com.example.api.controller;

import com.example.api.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/getQuote")
    public String getQuote() {
        return quoteService.getRandomQuote();
    }
    
    
}