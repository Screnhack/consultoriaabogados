package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ComandoRespuesta;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.ConsultaAbogadoComando;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.manejador.ActualizarConsultaAbogadoManejador;
import com.ceiba.adn.consultoriaabogados.aplicacion.comando.manejador.CrearConsultaAbogadoManejador;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/comando/abogado")
@Api(tags = { "Controlador de abogados" })
public class ComandoAbogadoControlador {

	private final CrearConsultaAbogadoManejador crearConsultaAbogadoManejador;
	private final ActualizarConsultaAbogadoManejador actualizarConsultaAbogadoManejador;

	public ComandoAbogadoControlador(CrearConsultaAbogadoManejador crearConsultaAbogadoManejador, 
			ActualizarConsultaAbogadoManejador actualizarConsultaAbogadoManejador) {
		this.crearConsultaAbogadoManejador = crearConsultaAbogadoManejador;
		this.actualizarConsultaAbogadoManejador = actualizarConsultaAbogadoManejador;
	}

	@PostMapping
	@ApiOperation("Crear Consulta Abogado")
	public ComandoRespuesta<ConsultaAbogadoComando> post(@RequestBody ConsultaAbogadoComando comandoConsultaAbogado) {
		return this.crearConsultaAbogadoManejador.ejecutar(comandoConsultaAbogado);
	}
	
	@PutMapping
	@ApiOperation("Actualizar Consulta Abogado")
	public ComandoRespuesta<ConsultaAbogadoComando> put(@RequestBody ConsultaAbogadoComando comandoConsultaAbogado) {
		return this.actualizarConsultaAbogadoManejador.ejecutar(comandoConsultaAbogado);
	}
}
