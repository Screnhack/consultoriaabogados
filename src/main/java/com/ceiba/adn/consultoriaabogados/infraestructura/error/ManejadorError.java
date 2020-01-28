package com.ceiba.adn.consultoriaabogados.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionArgumentos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionClienteConsultaDia;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionDiaProhibidos;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionEstadoInvalido;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionFormatoFecha;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionNoExisteConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.dominio.excepcion.ExcepcionTipoConsulta;

@ControllerAdvice
public class ManejadorError {
	private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorError.class);

	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ha Ocurrido un error favor contactar al administrador.";

	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ManejadorError() {
		CODIGOS_ESTADO.put(ExcepcionArgumentos.class.getSimpleName(), HttpStatus.NO_CONTENT.value());
		CODIGOS_ESTADO.put(ExcepcionClienteConsultaDia.class.getSimpleName(), HttpStatus.NO_CONTENT.value());
		CODIGOS_ESTADO.put(ExcepcionDiaProhibidos.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
		CODIGOS_ESTADO.put(ExcepcionEstadoInvalido.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ExcepcionFormatoFecha.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
		CODIGOS_ESTADO.put(ExcepcionNoExisteConsultaAbogado.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ExcepcionTipoConsulta.class.getSimpleName(), HttpStatus.FORBIDDEN.value());	
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		ResponseEntity<Error> resultado;

		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
		Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

		if (codigo != null) {
			Error error = new Error(excepcionNombre, mensaje);
			resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		} else {
			LOGGER.error(excepcionNombre, exception);
			Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
			resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resultado;
	}
}
