package com.trocajogo.Jogo.JogoImagem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "JogoImagem")
@Entity
@Table(name="jogoimagem")
public class JogoImagem {

	@Id
	private int id;
	private int idJogo;
	private String imagemJogo;
	
	public JogoImagem(){
		
	}

	public JogoImagem(int idJogo, String imagemJogo) {
		super();
		this.idJogo = idJogo;
		this.imagemJogo = imagemJogo;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public JogoImagem setIdJogo(int idJogo) {
		this.idJogo = idJogo;
		return this;
	}

	public String getImagemJogo() {
		return imagemJogo;
	}

	public JogoImagem setImagemJogo(String imagemJogo) {
		this.imagemJogo = imagemJogo;
		return this;
	}

	public int getId() {
		return id;
	}

	public JogoImagem setId(int id) {
		this.id = id;
		return this;
	}
	
	
}
