package com.example.xtiti.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="alquiler")
public class Alquiler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int id_usuario;
	private int id_hamaca;
	private int id_empresa;
	private Date hora_inicio;
	private Date hora_fin;
	
	public Alquiler(){}
	
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	@XmlElement
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public int getId_hamaca() {
		return id_hamaca;
	}
	
	@XmlElement
	public void setId_hamaca(int id_hamaca) {
		this.id_hamaca = id_hamaca;
	}
	
	public Date getHora_inicio() {
		return hora_inicio;
	}
	
	@XmlElement
	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Date getHora_fin() {
		return hora_fin;
	}
	
	@XmlElement
	public void setHora_fin(Date hora_fin) {
		this.hora_fin = hora_fin;
	}

	public int getId_empresa() {
		return id_empresa;
	}
	
	@XmlElement
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}	
}
