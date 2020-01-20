package com.ceiba.adn.consultoriaabogados.aplicacion.comando.manejador.respuesta;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuesta<C, R> {
	@Transactional
	R ejecutar(C command);
}
