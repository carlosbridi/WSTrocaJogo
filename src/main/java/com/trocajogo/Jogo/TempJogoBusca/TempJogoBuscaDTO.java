package com.trocajogo.Jogo.TempJogoBusca;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.Jogo;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Plataforma.Plataforma;

@XmlRootElement(name = "TempJogoBusca")
public class TempJogoBuscaDTO {

    public int idUsuarioTroca;
    public String nomeUsuarioTroca;
    public Jogo jogo;
    public List<Plataforma> plataforma = new ArrayList<Plataforma>(); 
	 
}
