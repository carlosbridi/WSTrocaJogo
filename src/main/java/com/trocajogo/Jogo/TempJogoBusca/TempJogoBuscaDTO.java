package com.trocajogo.Jogo.TempJogoBusca;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaDTO;

@XmlRootElement(name = "TempJogoBusca")
public class TempJogoBuscaDTO {

    public int idUsuarioTroca;
    public String nomeUsuarioTroca;
    public List<JogoPlataformaDTO> plataforma = new ArrayList<JogoPlataformaDTO>(); 
	 
}
