package com.example.cryptotracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cryptotracker.model.CryptoPrice;
import com.example.cryptotracker.repository.CryptoRepository;
import com.example.cryptotracker.service.CryptoService;

@RestController
public class CryptoController {

    private final CryptoService service;

    @Autowired // Importar org.springframework.beans.factory.annotation.Autowired
    private CryptoRepository repo;

    @GetMapping("/historial")
    public java.util.List<CryptoPrice> verHistorial() {
        return repo.findAll();
    }

    public CryptoController(CryptoService service) {
        this.service = service;
    }

    @GetMapping("/precio")
    public String verPrecio() {
        service.getBitcoinPrice(); // Esto imprimirá en la consola
        return "Mira la consola de VS Code para ver el precio";
    }
}