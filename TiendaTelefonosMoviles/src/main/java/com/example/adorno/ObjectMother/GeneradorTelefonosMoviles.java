package com.example.adorno.ObjectMother;

import com.example.adorno.modelo.Marca;
import com.example.adorno.modelo.Movil;
import com.example.adorno.modelo.Pantalla;
import com.example.adorno.modelo.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorTelefonosMoviles {
    /*
    private String[] nombresModeloMovilSamsung = new String[]{"Galaxy s23 Ultra", "Fold 4", "Galaxy A52", "Galaxy M23", "Flip"};
    private String[] nombresModeloMovilXiaomi = new String[]{"X4", "11Lite", "11T", "Redmi 9A", "Redmi 9C"};
    private String[] nombresModeloMovilApple = new String[]{"iPhone 12", "iPhone SE", "iPhone 13", "iPhone 14", "iPhone 14 Pro Max"};
    private String[] nombresModeloMovilHuawei = new String[]{"P40", "P40 Lite", "P50 Pro", "Mate Xs", "Nova Y70"};
    private String[] nombresModeloMovilOppo = new String[]{"A76", "Find X3", "Reno 8",  Neo", "X5", "X3};
    private String[] nombresModeloMovilNokia = new String[]{"X30", "G60", "G50", "G21", "G11"};
    private String[] nombresModeloMovilRealme = new String[]{"Gt2", "Gt9 Pro", "Gt neo 3", "Gt neo 150w"};
    private String[] nombresModeloMovilSony = new String[]{"Z3", "Xperia 1 IV", "Xperia 5 IV", "Xperia 10 IV"};
    private String[] nombresModeloMovilOnePlus = new String[]{"11 5G", "10 Pro", "Nord 2", "Nord CE 2", "Nord 2T"};
    private String[] nombresModeloMovilHonor = new String[]{"H70", "Magic4 Pro", "Magic 4 lite", "X8", "50 Lite"};
    */

    public static List<Movil> generarMoviles() {
        Random r = new Random();

        String[] nombresModeloMovil = new String[]{"Galaxy s23 Ultra", "Fold 4", "Galaxy A52", "Galaxy M23", "Flip", "X4", "11Lite", "11T", "Redmi 9A", "Redmi 9C",
                "iPhone 12", "iPhone SE", "iPhone 13", "iPhone 14", "iPhone 14 Pro Max", "P40", "P40 Lite", "P50 Pro", "Mate Xs", "Nova Y70", "A76", "Find X3", "Reno 8", "Neo", "X5",
                "X3", "X30", "G60", "G50", "G21", "G11", "Gt2", "Gt9 Pro", "Gt neo 3", "Gt neo 150w", "Z3", "Xperia 1 IV", "Xperia 5 IV", "Xperia 10 IV", "11 5G", "10 Pro", "Nord 2", "Nord CE 2", "Nord 2T",
                "H70", "Magic4 Pro", "Magic 4 lite", "X8", "50 Lite"};

        String[] fechaLanzamiento = new String[]{"3/4/2021", "19/6/2019", "18/9/2020", "21/8/2022", "7/2/2023"};
        long[] ram = new long[]{4, 8, 12, 16, 32};
        long[] almacenamiento = new long[]{64, 128, 256, 500, 1000};
        long[] bateria = new long[]{3200, 4500, 5000, 5600, 6200};//pulgadas alto ancho grosor peso camara nfc precio

        int[] pulgadas = new int[]{4, 5, 6, 7, 8, 9, 10};
        int[] alto = new int[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] ancho = new int[]{4, 5, 6};
        int[] grosor = new int[]{1, 2, 3};
        int[] peso = new int[]{100, 150, 170, 190, 210, 250, 350};
        int[] camara = new int[]{10, 15, 20, 25, 30, 35, 45};
        int[] precio = new int[]{250, 350, 450, 500, 680, 900, 1200, 1350, 2100};
        boolean nfc = r.nextBoolean();

        List<Marca> listaMarcas = GeneradorMarcas.generarMarca();
        List<Pantalla> listaPantalla = GeneradorPantalla.generarPantalla();
        List<Procesador> listaProcesador = GeneradorProcesador.generarProcesador();

        r = new Random();

        List<Movil> listaM = new ArrayList<>();

        int generaNumeroMoviles = 10;

        for (int i = 0; i < generaNumeroMoviles; i++) {
            //Movil m = new Movil(nombresModeloMovil[r.nextInt(nombresModeloMovil.length)], fechaLanzamiento[r.nextInt(fechaLanzamiento.length)], ram[r.nextInt(ram.length)], almacenamiento[r.nextInt(almacenamiento.length)], bateria[r.nextInt(bateria.length)], pulgadas[r.nextInt(pulgadas.length)], alto[r.nextInt(alto.length)], ancho[r.nextInt(ancho.length)], grosor[r.nextInt(grosor.length)], peso[r.nextInt(peso.length)], camara[r.nextInt(camara.length)], nfc, precio[r.nextInt(precio.length)], listaMarcas.get(r.nextInt(listaMarcas.size())), listaPantalla.get(r.nextInt(listaPantalla.size())), listaProcesador.get(r.nextInt(listaProcesador.size())));
            //Marca marca, String nombre, int almacenamiento, Pantalla pantalla, Float pulgadasPantalla, Procesador procesador, long ram, long bateria, long camara, boolean nfc, String fecha_lanazamiento, long alto, long ancho, long grosor, long peso, float precio
            Movil m = new Movil(listaMarcas.get(r.nextInt(listaMarcas.size())), nombresModeloMovil[r.nextInt(nombresModeloMovil.length)], almacenamiento[r.nextInt(almacenamiento.length)], listaPantalla.get(r.nextInt(listaPantalla.size())), pulgadas[r.nextInt(pulgadas.length)], listaProcesador.get(r.nextInt(listaProcesador.size())), ram[r.nextInt(ram.length)], bateria[r.nextInt(bateria.length)], camara[r.nextInt(camara.length)], nfc, fechaLanzamiento[r.nextInt(fechaLanzamiento.length)], alto[r.nextInt(alto.length)], ancho[r.nextInt(ancho.length)], grosor[r.nextInt(grosor.length)], peso[r.nextInt(peso.length)], precio[r.nextInt(precio.length)]);
            listaM.add(m);
        }
        return listaM;
    }
}