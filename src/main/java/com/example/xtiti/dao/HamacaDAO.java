package com.example.xtiti.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.xtiti.model.Alquiler;
import com.example.xtiti.model.Hamaca;
import com.example.xtiti.model.Usuario;
import com.example.xtiti.utils.HibernateUtil;

public class HamacaDAO {
	
	public Alquiler alquilarHamaca(Alquiler alquiler){
		
		Session session = null;
		Hamaca hamaca = null;
		int idAlquiler;
		
		alquiler.setHora_inicio(new Date());
		
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = session.getTransaction();
			
			hamaca = (Hamaca) session.createQuery("FROM Hamaca WHERE id=:id").setInteger("id", alquiler.getId_hamaca()).list().get(0);
			hamaca.setEstado("OCUPADA");
			
			session.update(hamaca);
			
			session.save(alquiler);
			session.flush();
			
			idAlquiler = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
			alquiler = (Alquiler) session.createQuery("FROM Alquiler WHERE id=:id").setInteger("id", idAlquiler).list().get(0);
			
			transaction.commit();
		}
		finally{
		
			session.close();
		}
		
		return alquiler;
	}
	
	public List<Hamaca> getListaHamacas(){
		
		List<Hamaca> listaHamacas = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
        //start transaction
        session.beginTransaction();
        
        listaHamacas = session.createQuery("FROM Hamaca").list();
        
        session.close();
        
        return listaHamacas;
	}
	
	public Hamaca saveHamaca(Hamaca hamaca){
		
		Hamaca hamacaSaved = null;
		int id = hamaca.getId();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		if(id == -1){
			try{
				session.save(hamaca);
				session.flush();
				id = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
				hamacaSaved = (Hamaca) session.createQuery("FROM Hamaca WHERE id=:id").setInteger("id", id).list().get(0);
				transaction.commit();
			}catch(Exception ex){
				hamacaSaved = null;
			}
		}
		else{
			try{
				session.update(hamaca);
				session.flush();
				hamacaSaved = hamaca;
				transaction.commit();
			}
			catch(Exception ex){
				hamacaSaved = null;
			}
					}
		
		return hamacaSaved;
	}
	
	public boolean deleteHamaca(Hamaca hamaca){
		
		boolean comprobacion = true;
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			
			session.delete(hamaca);
			
			transaction.commit();
		}
		catch(Exception ex){
			comprobacion = false;
		}
		
		return comprobacion;
	}
}
