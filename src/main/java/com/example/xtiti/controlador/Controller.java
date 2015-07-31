package com.example.xtiti.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONObject;

import com.example.xtiti.dao.HamacaDAO;
import com.example.xtiti.dao.LoginDAO;
import com.example.xtiti.model.Alquiler;
import com.example.xtiti.model.CargaMinima;
import com.example.xtiti.model.Empresa;
import com.example.xtiti.model.Hamaca;
import com.example.xtiti.model.Usuario;

@Path("/rest")
public class Controller {
	
	@POST
	@Path("/login")
	@Produces({"application/json;qs=1", "application/xml;qs=.5"})
	public CargaMinima intentoLogin(Usuario usuario){
		return new LoginDAO().intentoLogin(usuario.getNombre(), usuario.getPass());
	}
	
	@GET
	@RolesAllowed("user")
	@Path("/listahamacas")
	@Produces({"application/json;qs=1", "application/xml;qs=.5"})
	public List<Hamaca> getListaHamacas(){
		return new HamacaDAO().getListaHamacas();
	}
	
	@GET
	@Path("/horaserver")
	@Produces({"application/json; qs=1", "application/xml;qs=.5"})
	public WrapperDate getHoraServer(){
		return new WrapperDate();
	}
	
	@POST
	@Path("/savehamaca")
	@Produces({"application/json;qs=1", "application/xml;qs=.5"})
	public Hamaca saveHamaca(Hamaca hamaca){
		
		return new HamacaDAO().saveHamaca(hamaca);
	}
	
	@POST
	@Path("/bajahamaca")
	@Produces({"application/json;qs=1", "application/xml;qs=.5"})
	public WrapperComprobacion bajahamaca(Hamaca hamaca){
		return new WrapperComprobacion(new HamacaDAO().deleteHamaca(hamaca));
	}
	
	@POST
	@Path("/alquilerhamaca")
	@Produces({"application/json;qs=1", "application/json;qs=.5"})
	public Alquiler alquilarHamaca(Alquiler alquiler){
		System.out.println("I'm in");
		return new HamacaDAO().alquilarHamaca(alquiler);
	}
	
	
	//===============CLASES WRAPPER PARA MAPEAR================//
	
	@XmlRootElement(name = "horaservidor")
	private class WrapperDate{
		@XmlElement
		private Date horaservidor;
		
		public WrapperDate(){
			this.horaservidor = new Date();
		}
	}
	
	@XmlRootElement(name="comprobacion")
	private class WrapperComprobacion{
		
		@XmlElement
		boolean borrado;
		
		public WrapperComprobacion(boolean borrado){
			this.borrado = borrado;
		}
	}
}
