package com.ceiba.adn.consultoriaabogados.aplicacion.comando;

public class ComandoRespuesta<T> {
	private T value;

	public ComandoRespuesta(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
