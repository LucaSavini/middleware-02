package com.example.Middleware02.Controllers;

import com.example.Middleware02.Entities.Month;
import com.example.Middleware02.FintoDB.FintoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @Autowired
    private FintoDB fintoDB; // Assumiamo che tu abbia un bean di tipo FintoDB

    @GetMapping("/get")
    public ResponseEntity<Month> getMonth(@RequestHeader(name = "monthNumber", required = false) int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            // Se monthNumber non è nel range valido, restituisci un errore di richiesta HTTP Bad Request
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Cerca il mese in base al numero dalla classe FintoDB
        Month foundMonth = fintoDB.findMonth(monthNumber);

        // Restituisci il mese trovato o un mese vuoto se non trovato
        if (foundMonth != null) {
            return ResponseEntity.ok(foundMonth);
        }
        return null;
    }
}