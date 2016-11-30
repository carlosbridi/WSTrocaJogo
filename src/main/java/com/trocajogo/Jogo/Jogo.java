package com.trocajogo.Jogo;

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

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Plataforma.Plataforma;

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
	
	@OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
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
	public Jogo setId(int id) {
		this.id = id;
		return this;
	}
	public String getNomejogo() {
		return nomejogo;
	}
	public Jogo setNomejogo(String nomejogo) {
		this.nomejogo = nomejogo;
		return this;
	}
	public String getDescricao() {
		return descricao;
	}
	public Jogo setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	public int getCategoria() {
		return categoria;
	}
	public Jogo setCategoria(int categoria) {
		this.categoria = categoria;
		return this;
	}
	public int getAno() {
		return ano;
	}
	public Jogo setAno(int ano) {
		this.ano = ano;
		return this;
	}
	public String getImagem() {
		return imagem;
	}
	public Jogo setImagem(String imagem) {
		this.imagem = imagem;
		return this;
	}
	public List<JogoPlataforma> getPlataforma() {
		return plataforma;
	}
	public Jogo setPlataforma(List<JogoPlataforma> plataforma) {
		this.plataforma = plataforma;
		return this;
	}

	
}
