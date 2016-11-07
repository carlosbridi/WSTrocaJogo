package com.trocajogo.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "TempJogoBusca")
public class TempJogoBusca extends Jogo {


    private int idUsuarioTroca;
    private String nomeUsuarioTroca;

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
    
}
