package com.example.adorno.modelo;

public class movilesComparados<V> {

	private V dispositivoA;
	private V dispositivoB;
	
	public movilesComparados(V dispositivoA, V dispositivoB) {
		super();
		this.dispositivoA = dispositivoA;
		this.dispositivoB = dispositivoB;
	}

	public V getDispositivoA() {
		return dispositivoA;
	}

	public void setDispositivoA(V dispositivoA) {
		this.dispositivoA = dispositivoA;
	}

	public V getDispositivoB() {
		return dispositivoB;
	}

	public void setDispositivoB(V dispositivoB) {
		this.dispositivoB = dispositivoB;
	}
	
	
	
	
}
