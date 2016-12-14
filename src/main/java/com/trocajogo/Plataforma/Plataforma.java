package com.trocajogo.Plataforma;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;

@XmlRootElement(name = "Plataforma")
@Entity
@Table(name="plataforma")
public class Plataforma {

	@Id
	private int id;
	private String descricao;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<JogoPlataforma> jogoPlataforma = new ArrayList<JogoPlataforma>();
	
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
	
	public Plataforma setId(int id) {
		this.id = id;
		return this;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Plataforma setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	
	
}
