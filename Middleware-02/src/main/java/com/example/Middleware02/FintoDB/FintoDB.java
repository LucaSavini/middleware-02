package com.example.Middleware02.FintoDB;

import com.example.Middleware02.Entities.Month;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class FintoDB {
    public ArrayList<Month> lista;

    public FintoDB() {
        this.lista = new ArrayList<>(Arrays.asList(
                new Month(1, "January", "Gennaio", "Januar"),
                new Month(2, "February", "Febbraio", "Februar"),
                new Month(3, "March", "Marzo", "März"),
                new Month(4, "April", "Aprile", "April"),
                new Month(5, "May", "Maggio", "Mai"),
                new Month(6, "June", "Giugno", "Juni")));
    }
    public Month findMonth(int monthNumber) {
        for (Month x : lista) {
            if (x.getMonthNumber() == monthNumber) {
                return x; // Restituisci il mese se trovato
            }
        }
        return null; // Restituisci null se il mese non è presente
    }

}
