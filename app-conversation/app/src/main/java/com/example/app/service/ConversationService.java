package com.example.appconversation.service;

import com.example.appconversation.model.Conversation;
import com.example.appconversation.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Enregistre un message et retourne une citation inspirante
    public String sendMessage(String username, String message) {
        System.out.println("sendMessage() called with username: " + username + " and message: " + message);

        // Enregistrer la conversation en base de données
        Conversation conversation = new Conversation();
        conversation.setUsername(username);
        conversation.setMessage(message);
        conversation.setDate(new Date());
        conversationRepository.save(conversation);
        System.out.println("Message saved in database: " + conversation.getMessage());
        // Appeler l'API pour obtenir une citation inspirante
        String quote = restTemplate.getForObject("http://localhost:8080/api/getQuote", String.class);
        System.out.println("Received quote: " + quote);
        return quote;
    }

    // Récupère la liste des utilisateurs
    public List<String> getAllUsernames() {
        return conversationRepository.findAllUsernames();
    }

    // Récupère les conversations d'un utilisateur
    public List<Conversation> getConversationsByUsername(String username) {
        return conversationRepository.findByUsername(username);
    }
}