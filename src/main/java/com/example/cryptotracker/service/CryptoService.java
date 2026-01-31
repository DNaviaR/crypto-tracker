package com.example.cryptotracker.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.cryptotracker.model.CryptoPrice;
import com.example.cryptotracker.repository.CryptoRepository;
import java.util.Map;

@Service
public class CryptoService {

    private final RestTemplate restTemplate;
    private final CryptoRepository repository; // <--- Inyectamos el repositorio

    // Constructor actualizado
    public CryptoService(RestTemplate restTemplate, CryptoRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 10000) // Cada 10 seg
    public void getBitcoinPrice() {
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";
        
        try {
            Map respuesta = restTemplate.getForObject(url, Map.class);
            
            if (respuesta != null) {
                Map<String, Object> bitcoinData = (Map<String, Object>) respuesta.get("bitcoin");
                Double precio = Double.valueOf(bitcoinData.get("usd").toString());

                // GUARDAR EN BBDD
                CryptoPrice nuevoRegistro = new CryptoPrice(precio);
                repository.save(nuevoRegistro);
                
                System.out.println("💾 Guardado precio: $" + precio + " a las " + nuevoRegistro.getTimestamp());
            }
        } catch (Exception e) {
            System.err.println("Error obteniendo precio: " + e.getMessage());
        }
    }
}