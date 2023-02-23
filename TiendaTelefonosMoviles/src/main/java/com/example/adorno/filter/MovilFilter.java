package com.example.adorno.filter;

public class MovilFilter {
	Range precio = new Range<Float>(0f, 1000f);
	String marca = "any";
	Long ram = (long) 10;
	boolean nfc = false;
	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Long getRam() {
		return ram;
	}
	
	public boolean hasNfc() {
		return nfc;
	}
	
	public void setNfc(boolean nfc) {
		this.nfc=nfc;
	}
	
	public Range<Float> getPrecio(){
		return precio;
	}
	
	public void setPrecio(Range<Float> precio) {
		this.precio=precio;
	}

	public void isBetween(float min, float max) {

	}
}
