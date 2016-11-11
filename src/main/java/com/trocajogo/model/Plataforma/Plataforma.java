package com.trocajogo.model.Plataforma;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.trocajogo.model.Jogo;
import com.trocajogo.model.JogoPlataforma.JogoPlataforma;

@XmlRootElement(name = "Plataforma")
@Entity
@Table(name="plataforma")
public class Plataforma {

	@Id
	private int id;
	private String descricao;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id")
	private Jogo jogo;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id")
	private JogoPlataforma jogoPlataforma;
	
	
	
	public Plataforma(){
		
	}
	
	public Plataforma(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Plataforma(int idPlataforma){
		super();
		this.id = idPlataforma;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@XmlTransient
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
}
