package com.ceiba.adn.consultoriaabogados.infraestructura.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.ListarConsultaAbogado;
import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.manejador.BuscarConsultaAbogadoManejador;
import com.ceiba.adn.consultoriaabogados.aplicacion.consulta.manejador.ListarConsultasAbogadoManejador;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/consulta/abogado")
@Api(tags = { "Controlador de abogados" })
public class ConsultaAbogadoControlador {

	private final ListarConsultasAbogadoManejador listarConsultaAbogadoManejadorConsulta;
	private final BuscarConsultaAbogadoManejador buscarConsultaAbogadoManejador;

	public ConsultaAbogadoControlador(ListarConsultasAbogadoManejador listarConsultaAbogadoManejadorConsulta,
			BuscarConsultaAbogadoManejador buscarConsultaAbogadoManejador) {
		this.listarConsultaAbogadoManejadorConsulta = listarConsultaAbogadoManejadorConsulta;
		this.buscarConsultaAbogadoManejador = buscarConsultaAbogadoManejador;
	}

	@GetMapping
	@ApiOperation("Listar Consulta Abogado")
	public List<ListarConsultaAbogado> get() {
		return this.listarConsultaAbogadoManejadorConsulta.ejecutar();
	}

	@GetMapping("/{id}")
	@ApiOperation("Buscar Consulta Abogado")
	public ListarConsultaAbogado getBuscarConsulta(@PathVariable Long id) {
		return this.buscarConsultaAbogadoManejador.ejecutar(id);
	}

	@GetMapping("/hello")
	public ResponseEntity sayHello() {
		return ResponseEntity.ok(this.listarConsultaAbogadoManejadorConsulta.helloWorld());
	}

}
