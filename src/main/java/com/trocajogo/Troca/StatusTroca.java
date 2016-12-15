package com.trocajogo.Troca;

public enum StatusTroca {
	ANALISE("A"),
	ANDAMENTO("N"),
	CONCLUIDA("C"),
	CANCELADA("D"),
	REJEITADA("R");
	
	private String statusTroca;
	
	private StatusTroca(String statusTroca){
		this.statusTroca = statusTroca;
	}
	
	public static StatusTroca from(String statusTroca){
		if(statusTroca.equals("")) return null;
		for (StatusTroca status : values()) {
			if (status.statusTroca.equals(statusTroca))
				return status;
		}
		throw new StatusTrocaException("Status da troca inválido: " + statusTroca);
	}
}
