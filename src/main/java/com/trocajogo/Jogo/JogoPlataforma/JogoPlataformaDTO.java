package com.trocajogo.Jogo.JogoPlataforma;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Plataforma.PlataformaDTO;

@XmlRootElement(name = "JogoPlataformaDTO")
public class JogoPlataformaDTO {

	public int id;
	public PlataformaDTO plataforma;
}
