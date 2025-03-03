package com.example.api.service;

import com.example.api.model.Quote;
import com.example.api.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    @Autowired
    private QuoteRepository quoteRepository;

    public String getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            logger.info("No quotes available");
            return "No quotes available";
        }
        Random random = new Random();
        String randomQuote = quotes.get(random.nextInt(quotes.size())).getText();
        logger.info("Random Quote: {}", randomQuote);
        return randomQuote;
    }
}