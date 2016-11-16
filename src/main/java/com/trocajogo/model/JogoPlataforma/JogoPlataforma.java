package com.trocajogo.model.JogoPlataforma;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.trocajogo.model.ItemTroca;
import com.trocajogo.model.Jogo;
import com.trocajogo.model.Plataforma.Plataforma;


@SequenceGenerator(name = "jogoplataformaid_seq", sequenceName = "jogoplataformaid_seq", allocationSize = 1, initialValue = 1)
@Entity
@Table(name = "jogoplataforma")
public class JogoPlataforma {
	
	@Id
	@Column(name = "jogoplataforma_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idjogo")
	private Jogo jogoPlataforma;
	
	@OneToOne
	@JoinColumn(name = "plataforma_id")
	private Plataforma plataforma;
	
	public JogoPlataforma(){
	}

	public JogoPlataforma(int idJogo, Plataforma plataforma) {
		super();
		//this.idJogo = idJogo;
		this.plataforma = plataforma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Jogo getJogoPlataforma() {
		return jogoPlataforma;
	}

	public void setJogoPlataforma(Jogo jogoPlataforma) {
		this.jogoPlataforma = jogoPlataforma;
	}

	
}
