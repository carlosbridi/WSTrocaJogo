package com.trocajogo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItensJogoTroca")
public class ItensJogoTroca{

	private Jogo jogoOferta;
    private Jogo jogoTroca;
    private int idUsuarioOferta;
    private int idUsuarioTroca;
    private String nomeUsuarioTroca;
    private String nomeUsuarioOferta;
    
    public ItensJogoTroca(){
    	this.jogoOferta = new Jogo();
    	this.jogoTroca = new Jogo();
    }

    public Jogo getJogoOferta() {
        return jogoOferta;
    }

    public void setJogoOferta(Jogo jogoOferta) {
        this.jogoOferta = jogoOferta;
    }

    public Jogo getJogoTroca() {
        return jogoTroca;
    }

    public void setJogoTroca(Jogo jogoTroca) {
        this.jogoTroca = jogoTroca;
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

    public String getNomeUsuarioTroca() {
        return nomeUsuarioTroca;
    }

    public void setNomeUsuarioTroca(String nomeUsuarioTroca) {
        this.nomeUsuarioTroca = nomeUsuarioTroca;
    }

    public String getNomeUsuarioOferta() {
        return nomeUsuarioOferta;
    }

    public void setNomeUsuarioOferta(String nomeUsuarioOferta) {
        this.nomeUsuarioOferta = nomeUsuarioOferta;
    }
	
	
}
