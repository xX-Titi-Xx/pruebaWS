package com.example.xtiti.dao;

import org.hibernate.Session;

import com.example.xtiti.model.Empresa;
import com.example.xtiti.model.Usuario;
import com.example.xtiti.utils.HibernateUtil;

public class LoginDAO {

	public Empresa intentoLogin(String user, String pass) {

		Empresa empresa = null;
		Session session = null;
		Usuario usuario = null;

		if (user != null && pass != null && !user.isEmpty() && !pass.isEmpty()) {
			try {
				session = HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();

				usuario = (Usuario) session.createQuery("FROM Usuario WHERE estado='ACTIVO' AND nombre=:nombre AND pass=:pass").setString("nombre", user).setString("pass", pass).list().get(0);
				
			} catch (Exception ex) {

			}
			
			if (usuario != null) {
				
				try{
					empresa = (Empresa) session.createQuery("FROM Empresa WHERE id=:id_empresa").setInteger("id_empresa", usuario.getId_empresa()).list().get(0);
				}
				catch(Exception ex){
					
				}
			}

			session.close();
		}

		return empresa;
	}
}
