package com.example.xtiti.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="empresa")
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private double latitud;
	private double longitud;
	private double distancia;
	
	public Empresa(){}
	
	public int getId() {
		return id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDistancia() {
		return distancia;
	}
	@XmlElement
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + nombre + " " + latitud + " " + longitud;
	}
}
