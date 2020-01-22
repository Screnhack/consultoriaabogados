package com.ceiba.adn.consultoriaabogados.aplicacion.comando;

public class ComandoRespuesta<T> {
	private T valor;

	public ComandoRespuesta(T valor) {
		this.valor = valor;
	}

	public T getValue() {
		return valor;
	}
}
