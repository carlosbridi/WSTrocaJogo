package com.trocajogo.model;

import org.hibernate.service.spi.ServiceException;

public enum StatusTroca {

	TROCA_ANALISE(0),
	TROCA_ANDAMENTO(1),
	TROCA_CONCLUIDA(2),
	TROCA_CANCELADA(3),
	TROCA_REJEITADA(4);
	
	private Integer statusTroca;
	
	private StatusTroca(Integer statusTroca){
		this.statusTroca = statusTroca;
	}
	
	public Integer getStatusTroca(){
		return statusTroca;
	}
	
	public static StatusTroca from(Integer status) {
		if (status == null) return null;
		for (StatusTroca statusTroca: values()){
			if (statusTroca.getStatusTroca().equals(status))
				return statusTroca;
		}
		
		throw new ServiceException("Status de Troca não encontrado!");
	}

}
