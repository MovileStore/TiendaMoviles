package com.example.adorno.ObjectMother;

import com.example.adorno.modelo.Procesador;

import java.util.ArrayList;
import java.util.List;

public class GeneradorProcesador {
    private static long[] nucleosProcesador = new long[]{4,6,8};
    private static String[] nombresProcesador = new String[]{"Snapdragon 865","A14 Bionic","Dimensity 8000","Exynos 1080"};
    private static long[] velocidadProcesador = new long[]{1100, 1300, 1500, 1700, 2100};

    public static List<Procesador> generarProcesador() {
        List<Procesador> lista = new ArrayList<>();
        long contadorID = 0;

        for (int i = 0; i < nucleosProcesador.length; i++) {
            //for (int j = 0; j < nombresProcesador.length; j++) {
                //for (int s = 0; s < velocidadProcesador.length; s++) {
                    Procesador procesador = new Procesador(contadorID+1, nucleosProcesador[i], nombresProcesador[i], velocidadProcesador[i]);
                    contadorID++;
                    lista.add(procesador);
                //}
            //}
        }
        return lista;
    }
}
