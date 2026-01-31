package com.example.cryptotracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cryptotracker.model.CryptoPrice;

public interface CryptoRepository extends JpaRepository<CryptoPrice, Long> {
    // No necesitamos métodos extra por ahora, con save() y findAll() nos vale
}
