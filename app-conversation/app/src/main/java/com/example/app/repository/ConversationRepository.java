package com.example.appconversation.repository;

import com.example.appconversation.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    // Récupère toutes les conversations d'un utilisateur spécifique
    List<Conversation> findByUsername(String username);

    // Récupère la liste distincte des noms d'utilisateurs
    @Query("SELECT DISTINCT c.username FROM Conversation c")
    List<String> findAllUsernames();
}