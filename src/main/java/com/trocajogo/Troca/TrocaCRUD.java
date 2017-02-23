package com.trocajogo.Troca;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.genericdata.EntityConnectionUtils;

public class TrocaCRUD {
	
	
	@Inject
	private TrocaRepository trocaRepository; 
	
	@Inject
	private TrocaConverter trocaConverter;
	
	public Troca obterTroca(int idTroca){
		TrocaRepository trocaRepository = new TrocaRepository();
		return trocaRepository.findByIdThrowsException(idTroca);
	}
	
	public int inserirTroca(Troca troca){
		validarInclusaoTroca(troca);
		return this.persistirTroca(troca);
	}
	
	public void validarInclusaoTroca(Troca troca){
		//Verificar trocas usando esse jogo (oferta-Troca)
	}
	
	private int persistirTroca(Troca troca){
		EntityManager em = EntityConnectionUtils.getEntityManager();
		em.getTransaction().begin();
		
		try{
			if (troca.getId() > 0){
				em.merge(troca);
			}else{
				em.persist(troca);				
			}
			em.getTransaction().commit();	
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return troca.getId();
	}
	
	
	public int atualizarStatusTroca(int idTroca, StatusTroca status){
		TrocaRepository trocaRepository = new TrocaRepository();
		Troca troca = trocaRepository.findByIdThrowsException(idTroca);

		if (status.toString().equals(StatusTroca.CONCLUIDA.toString())){
			TrocaConcluida trocaConcluida = new TrocaConcluida(troca);
			trocaConcluida.efetuarTroca();
		}

		troca.setStatusTroca(status);
		return this.persistirTroca(troca);
	}
	
	
	public List<TrocaDTO> listarTrocasUsuario(Long idUsuario){
		trocaRepository = new TrocaRepository();
		trocaConverter = new TrocaConverter();
		return trocaConverter.toRepresentation(trocaRepository.obterTrocasUsuario(idUsuario));
	}
	
	
}

