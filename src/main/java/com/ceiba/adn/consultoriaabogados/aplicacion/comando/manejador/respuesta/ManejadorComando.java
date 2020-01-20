package com.ceiba.adn.consultoriaabogados.aplicacion.comando.manejador.respuesta;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {
	@Transactional
	void ejecutar(C command);
}
