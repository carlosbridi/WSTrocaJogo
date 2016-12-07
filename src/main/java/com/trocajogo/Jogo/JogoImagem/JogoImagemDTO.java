package com.trocajogo.Jogo.JogoImagem;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "JogoImagem")
public class JogoImagemDTO {
	public int id;
	public int idJogo;
	public String imagemJogo;
}
