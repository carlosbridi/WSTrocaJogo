package com.trocajogo.model.Plataforma;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;

public class PlataformaDAO {

	public static Plataforma buscarPlataforma(int idPlataforma){
		Session sessao = HibernateUtil.getSession();
		Criteria cri = sessao.createCriteria(Plataforma.class).add(Restrictions.eq("id", idPlataforma));
		
		return (Plataforma) cri.list().get(0);
	}
	
}
