package com.ceiba.adn.consultoriaabogados.infraestructura.adaptador.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

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

	@javax.persistence.Temporal(TemporalType.DATE)
	@Column(name = "fecha_consulta")
	private Date fechaConsulta;

	@Column(name = "precio", nullable = false)
	private float precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipoConsultoria() {
		return tipoConsultoria;
	}

	public void setTipoConsultoria(String tipoConsultoria) {
		this.tipoConsultoria = tipoConsultoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
