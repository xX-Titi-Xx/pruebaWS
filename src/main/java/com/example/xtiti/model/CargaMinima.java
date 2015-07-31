package com.example.xtiti.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CargaMinima {
	
	@XmlElement
	private int id_usuario;
	@XmlElement
	private String rol;
	@XmlElement
	private int id_empresa;
	@XmlElement
	private String nombre_empresa;
	@XmlElement
	private double latitud;
	@XmlElement
	private double longitud;
	@XmlElement
	private double distancia;
	@XmlElement
	private boolean comprobacion;
	
	public CargaMinima(){}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public int getId_empresa() {
		return id_empresa;
	}
	
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public String getNombreEmpresa() {
		return nombre_empresa;
	}
	
	public void setNombreEmpresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	
	public double getDistancia() {
		return distancia;
	}
	
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public boolean isComprobacion() {
		return comprobacion;
	}

	public void setComprobacion(boolean comprobacion) {
		this.comprobacion = comprobacion;
	}
}
