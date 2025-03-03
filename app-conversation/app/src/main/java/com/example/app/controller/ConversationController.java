package com.example.appconversation.controller;

import com.example.appconversation.model.Conversation;
import com.example.appconversation.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(@RequestParam String username, @RequestParam String message) {
        return conversationService.sendMessage(username, message);
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<String> usernames = conversationService.getAllUsernames();
        model.addAttribute("usernames", usernames);
        return "users";
    }

    @GetMapping("/conversation/{username}")
    public String getUserConversation(@PathVariable String username, Model model) {
        List<Conversation> conversations = conversationService.getConversationsByUsername(username);
        model.addAttribute("conversations", conversations);
        model.addAttribute("username", username); // Ajout du nom d'utilisateur pour l'affichage
        return "conversation";
    }
}
