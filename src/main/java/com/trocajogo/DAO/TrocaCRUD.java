package com.trocajogo.DAO;


import java.text.SimpleDateFormat;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.model.StatusTroca;
import com.trocajogo.model.Troca;

public class TrocaCRUD {
	
	
	public int persistirTroca(Troca troca){
		
		Session sessao = HibernateUtil.getSession();
		sessao.getTransaction().begin();
		
		try{
			if (troca.getId() > 0){
				sessao.merge(troca);
			}else{
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				final String stringDate= dateFormat.format(troca.getDataTroca());
				final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
				troca.setDataTroca(sqlDate);
				troca.setStatusTroca(StatusTroca.TROCA_ANALISE);
				
				sessao.persist(troca);
			
				sessao.getTransaction().commit();
			}
		}catch(Exception e){
			sessao.getTransaction().rollback();
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public int atualizarStatusTroca(int idTroca, StatusTroca status){
		
		if (status.toString().equals(StatusTroca.TROCA_CONCLUIDA.toString())){
			TrocaConcluida trocaConcluida = new TrocaConcluida(idTroca);
			trocaConcluida.efetuarTroca();
		}

		Session sessao = HibernateUtil.getSession();
		sessao.getTransaction().begin();
		try{
			Troca troca = buscarTroca(idTroca);
			troca.setStatusTroca(status);
			sessao.merge(troca);
			sessao.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			sessao.getTransaction().rollback();
			return 0;
		}
	}
	
	
	public Troca buscarTroca(int idTroca){
		Session session = HibernateUtil.getSession();
		Criteria cri = session.createCriteria(Troca.class)
							  .add(Restrictions.eq("idTroca", idTroca));
		
		return (Troca) cri.list().get(0);
	}
	
	
}

