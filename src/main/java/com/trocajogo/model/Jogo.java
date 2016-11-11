package com.trocajogo.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.model.JogoPlataforma.JogoPlataforma;
import com.trocajogo.model.Plataforma.Plataforma;

@XmlRootElement(name = "Jogo")
@SequenceGenerator(name="jogoid_seq", sequenceName = "jogoid_seq", 
					allocationSize = 1, initialValue = 1)
@Entity
@Table(name="jogo")
public class Jogo {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogoid_seq")
	@Id
	private int id;
	private String nomejogo;
	private String descricao;
	private int categoria;
	private int ano;
	private String imagem;
	
	@OneToMany(mappedBy = "jogoPlataforma", cascade = CascadeType.ALL)
	private List<JogoPlataforma> plataforma = new ArrayList<JogoPlataforma>(); 
	
	public Jogo(){
		
	}	
	
	public Jogo(int id, String nomejogo, String descricao, int categoria,
			int ano, Plataforma plataforma, String imagem) {
		super();
		this.id = id;
		this.nomejogo = nomejogo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.ano = ano;
		this.imagem = imagem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomejogo() {
		return nomejogo;
	}
	public void setNomejogo(String nomejogo) {
		this.nomejogo = nomejogo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<JogoPlataforma> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(List<JogoPlataforma> plataforma) {
		this.plataforma = plataforma;
	}

	
}
