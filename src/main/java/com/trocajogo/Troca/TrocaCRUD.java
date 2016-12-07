package com.trocajogo.Troca;

import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import com.data.generic.EntityUtils;

public class TrocaCRUD {
	
	
	public int persistirTroca(Troca troca){
		
		EntityManager em = EntityUtils.getEntityManager();
		em.getTransaction().begin();
		
		try{
			if (troca.getId() > 0){
				em.merge(troca);
			}else{
				em.persist(troca);
				em.getTransaction().commit();				
			}
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return troca.getId();
	}
	
	
	
	public int atualizarStatusTroca(int idTroca, StatusTroca status){
		
		if (status.toString().equals(StatusTroca.CONCLUIDA.toString())){
			TrocaConcluida trocaConcluida = new TrocaConcluida(idTroca);
			trocaConcluida.efetuarTroca();
		}

		TrocaRepository trocaRepository = new TrocaRepository();
		Troca troca = trocaRepository.findByIdThrowsException(idTroca);
		
		troca.setStatusTroca(status);
		return this.persistirTroca(troca);
		
	}
	
	
	public Troca obterTroca(int idTroca){
		TrocaRepository trocaRepository = new TrocaRepository();
		return trocaRepository.findByIdThrowsException(idTroca);
	}
	
	
}

