package com.example.adorno.ObjectMother;

import com.example.adorno.modelo.Marca;

import java.util.ArrayList;
import java.util.List;

public class GeneradorMarcas {
    private static String[] marcaMovil = new String[]{"Samsung", "Xiaomi", "Apple", "Huawei", "Oppo", "Nokia", "Realme", "Sony", "OnePlus", "Honor"};

    public static List<Marca> generarMarca() {
        List<Marca> lista = new ArrayList<>();
        long contadorID = 0;

        for (int i = 0; i < marcaMovil.length; i++) {
            Marca marca = new Marca(contadorID+1, marcaMovil[i]);
            contadorID++;
            lista.add(marca);
        }
        return lista;
    }
}