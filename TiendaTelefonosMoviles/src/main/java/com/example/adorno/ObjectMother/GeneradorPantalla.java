package com.example.adorno.ObjectMother;

import com.example.adorno.modelo.Pantalla;

import java.util.ArrayList;
import java.util.List;

public class GeneradorPantalla {
    private static String[] tipoPantallaMovil = new String[]{"Amoled","IPS", "LCD", "OLED", "TFT", "LED"};

    public static List<Pantalla> generarPantalla() {
        List<Pantalla> lista = new ArrayList<>();

        long contadorID = 0;

        for (int i = 0; i < tipoPantallaMovil.length; i++) {
            Pantalla pantalla = new Pantalla(contadorID+1, tipoPantallaMovil[i]);
            contadorID++;
            lista.add(pantalla);
        }
        return lista;
    }
}