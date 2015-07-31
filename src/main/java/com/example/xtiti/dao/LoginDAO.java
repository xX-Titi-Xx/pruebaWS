package com.example.xtiti.dao;

import org.hibernate.Session;

import com.example.xtiti.model.CargaMinima;
import com.example.xtiti.model.Empresa;
import com.example.xtiti.model.Usuario;
import com.example.xtiti.utils.HibernateUtil;

public class LoginDAO {

	public CargaMinima intentoLogin(String user, String pass) {

		CargaMinima cargaMinima = new CargaMinima();
		cargaMinima.setComprobacion(false);
		
		Session session = null;
		Usuario usuario = null;
		Empresa empresa = null;
		boolean correcto = true;

		if (user != null && pass != null && !user.isEmpty() && !pass.isEmpty()) {
			try {
				session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();

				usuario = (Usuario) session.createQuery("FROM Usuario WHERE estado='ACTIVO' AND nombre=:nombre AND pass=:pass").setString("nombre", user).setString("pass", pass).list().get(0);
				
			} catch (Exception ex) {
				correcto = false;
			}
			
			if (usuario != null) {
				
				try{
					empresa = (Empresa) session.createQuery("FROM Empresa WHERE id=:id_empresa").setInteger("id_empresa", usuario.getId_empresa()).list().get(0);
				}
				catch(Exception ex){
					correcto = false;
				}
			}

			session.close();
			
			if (correcto){
				
				cargaMinima.setId_usuario(usuario.getId());
				cargaMinima.setRol(usuario.getRol());
				cargaMinima.setId_empresa(empresa.getId());
				cargaMinima.setNombreEmpresa(empresa.getNombre());
				cargaMinima.setLatitud(empresa.getLatitud());
				cargaMinima.setLongitud(empresa.getLongitud());
				cargaMinima.setDistancia(empresa.getDistancia());
				
				cargaMinima.setComprobacion(true);
			}	
		}

		return cargaMinima;
	}
}
