package com.example.projet.projet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testEnvoyerMailConfirmationl() {
        emailService.envoyerMailConfirmation("yosr.frikha1@gmail.com", "Mail de confirmation", "Vous êtes inscrit à notre événément");
        System.out.println("email de test est envoyé");
    }
}
