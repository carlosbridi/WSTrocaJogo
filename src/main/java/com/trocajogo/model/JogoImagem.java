package com.trocajogo.model;

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

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getImagemJogo() {
		return imagemJogo;
	}

	public void setImagemJogo(String imagemJogo) {
		this.imagemJogo = imagemJogo;
	}
	
	
}
