package com.trocajogo.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Troca")

public class Troca {

	private int id; // Id Troca
    private int idUsuarioOferta; // Meu ID
    private int idUsuarioTroca; // ID Usuário remoto
    private ItensJogoTroca jogoTroca; // Jogo troca do usuário remoto
    private Date dataTroca; // Data da troca
    private StatusTroca statusTroca; // Status da Troca (Analise, Cancelada, Finalizada)
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuarioOferta() {
		return idUsuarioOferta;
	}
	public void setIdUsuarioOferta(int idUsuarioOferta) {
		this.idUsuarioOferta = idUsuarioOferta;
	}
	public int getIdUsuarioTroca() {
		return idUsuarioTroca;
	}
	public void setIdUsuarioTroca(int idUsuarioTroca) {
		this.idUsuarioTroca = idUsuarioTroca;
	}
	public ItensJogoTroca getJogoTroca() {
		return jogoTroca;
	}
	public void setJogoTroca(ItensJogoTroca jogoTroca) {
		this.jogoTroca = jogoTroca;
	}
	public Date getDataTroca() {
		return dataTroca;
	}
	public void setDataTroca(Date dataTroca) {
		this.dataTroca = dataTroca;
	}
	public StatusTroca getStatusTroca() {
		return statusTroca;
	}
	public void setStatusTroca(StatusTroca statusTroca) {
		this.statusTroca = statusTroca;
	}

}