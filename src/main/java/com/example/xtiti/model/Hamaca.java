package com.example.xtiti.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name="hamaca")
public class Hamaca implements Serializable{

	private static final long serialVersionUID = -1L;
	private int id;
	private int id_empresa;
	private String estado;
	private double latitud;
	private double longitud;

	public Hamaca(){}
	
	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	@XmlElement
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getEstado() {
		return estado;
	}

	@XmlElement
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getLatitud() {
		return latitud;
	}

	@XmlElement
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	@XmlElement
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	@Override
	public String toString() {
		
		return id + "," + id_empresa + "," + estado + "," + latitud + "," + longitud ;
	}
}
