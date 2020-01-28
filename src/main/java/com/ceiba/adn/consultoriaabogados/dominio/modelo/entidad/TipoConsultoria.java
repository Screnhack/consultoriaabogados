package com.ceiba.adn.consultoriaabogados.dominio.modelo.entidad;

public enum TipoConsultoria {

	FAMILIAR("100000"), JUDICIAL("200000"), ECONOMICO("110000");

	private TipoConsultoria(String tipoConsulta) {
		this.precio = tipoConsulta;
	}
	public String getPrecioConsulta() {
		return precio;
	}
	
	private String precio;
	
	
}
