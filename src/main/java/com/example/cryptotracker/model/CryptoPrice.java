package com.example.cryptotracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class CryptoPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private LocalDateTime timestamp = LocalDateTime.now(); // Guarda la fecha/hora actual automáticamente

    public CryptoPrice(Double price) {
        this.price = price;
    }
}
