package com.example.adorno.filter;

public class MovilFilter {
    Range precio = new Range<Float>(0f, 1000f);
    String marca = "any";
    Range ram = new Range<Float>(0f, 1000f);
    boolean nfc = false;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Range<Float> getRam() {
        return ram;
    }

    public boolean hasNfc() {
        return nfc;
    }

    public void setNfc(boolean nfc) {
        this.nfc = nfc;
    }

    public Range<Float> getPrecio() {
        return precio;
    }

    public void setRam(Range ram) {
        this.ram = ram;
    }

    public MovilFilter(Range precio, String marca, Range ram, boolean nfc) {
        this.precio = precio;
        this.marca = marca;
        this.ram = ram;
        this.nfc = nfc;
    }

    public void setPrecio(Range<Float> precio) {
        this.precio = precio;
    }

    public boolean isNfc() {
        return nfc;
    }
}
