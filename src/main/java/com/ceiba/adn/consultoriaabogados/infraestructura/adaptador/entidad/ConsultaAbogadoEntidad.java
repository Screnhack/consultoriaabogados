package com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consulta")
public class ConsultaAbogadoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "identificacion", nullable = false)
	private String identificacion;

	@Column(name = "celular", nullable = false)
	private String celular;

	@Column(name = "tipo_consultoria", nullable = false)
	private String tipoConsultoria;

	@Column(name = "estado", nullable = false)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_consulta")
	private Date fechaConsulta;

	@Column(name = "precio", nullable = false)
	private float precio;

}
