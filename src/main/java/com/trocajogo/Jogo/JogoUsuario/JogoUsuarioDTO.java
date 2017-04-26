package com.trocajogo.Jogo.JogoUsuario;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoBase;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaDTO;


@XmlRootElement(name = "JogoUsuarioDTO")
public class JogoUsuarioDTO {
	public Long id;
	public Long idUsuario;
	public String nomeUsuario;
	public JogoBase jogo;
	public JogoPlataformaDTO jogoPlataforma;
	public boolean interesse;	
}
