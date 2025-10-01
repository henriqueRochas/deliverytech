package com.deliverytech.delivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime; // CORRIGIDO: java.org para java.time
import java.time.format.DateTimeFormatter; // CORRIGIDO: java.org para java.time.format
import java.util.Map;


@RestController
public class HealthController { // Recomendo renomear o arquivo para HealthController.java
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/health") // Adicionei o Mapping, caso contrário, não é acessível
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> healthInfo = Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().format(FORMATTER),
            "service", "Delivery API",
            "javaVersion", System.getProperty("java.version"),
            "springBootVersion", getClass().getPackage().getImplementationVersion() != null
            ? getClass().getPackage().getImplementationVersion() : "3.2.x",
            "environment", "development"
        ); 
        return ResponseEntity.ok(healthInfo); // CORRIGIDO: ResponseEnƟty para ResponseEntity
    }

    @GetMapping("/info")
    public ResponseEntity<AppInfo> info() {
        AppInfo appInfo = new AppInfo(
            "Delivery Tech API",
            "1.0.0",
            "[Nome do Aluno]",
            System.getProperty("java.version"),
            "Spring Boot 3.2.x",
            LocalDateTime.now().format(FORMATTER),
            "Sistema de delivery moderno desenvolvido com as mais recentes tecnologias Java"
        );
        return ResponseEntity.ok(appInfo);
    }
    
    // O record AppInfo deve ser estático ou estar fora da classe
    public static record AppInfo( 
        String application,
        String version,
        String developer,
        String javaVersion,
        String framework,
        String timestamp, // Corrigido o erro de digitação (timestamptamp -> timestamp)
        String description
    ){
        public AppInfo {
            if (application == null || application.isBlank()) {
                throw new IllegalArgumentException("Application name cannot be null or blank");
            } 
        }
    }
}
// O conteúdo comentado abaixo foi removido para evitar erros.