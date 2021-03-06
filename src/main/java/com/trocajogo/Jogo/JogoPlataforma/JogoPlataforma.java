package com.trocajogo.Jogo.JogoPlataforma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.trocajogo.Jogo.Jogo;
import com.trocajogo.Plataforma.Plataforma;

@SequenceGenerator(name = "jogoplataformaid_seq", sequenceName = "jogoplataformaid_seq", allocationSize = 1, initialValue = 1)
@Entity
@Table(name = "jogoplataforma")
public class JogoPlataforma {
	
	@Id
	@Column(name = "jogoplataforma_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idjogo")
	private Jogo jogo;
	
	@OneToOne
	@JoinColumn(name = "plataforma_id")
	private Plataforma plataforma = new Plataforma();
	
	public JogoPlataforma(){
	}

	public JogoPlataforma(int idJogo, Plataforma plataforma) {
		super();
		this.plataforma = plataforma;
	}

	public int getId() {
		return id;
	}

	public JogoPlataforma setId(int id) {
		this.id = id;
		return this;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public JogoPlataforma setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
		return this;
	}

	public Jogo getJogoPlataforma() {
		return jogo;
	}

	public JogoPlataforma setJogoPlataforma(Jogo jogoPlataforma) {
		this.jogo = jogoPlataforma;
		return this;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public JogoPlataforma setJogo(Jogo jogo) {
		this.jogo = jogo;
		return this;
	}

	
}
