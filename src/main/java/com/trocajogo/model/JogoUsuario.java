package com.trocajogo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="jogousuario")
public class JogoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogousuarioid_seq")
	@SequenceGenerator(name="jogousuarioid_seq", sequenceName = "jogousuarioid_seq", 
	  allocationSize = 1, initialValue = 1)
	private int id;
	private int idUsuario;
	private int idJogo;
	private int idPlataforma;
	private boolean interesse;
	
	public JogoUsuario(){
		
	}
	
	public JogoUsuario(int idUsuario, int idJogo, int idPlataforma) {
		super();
		this.idUsuario = idUsuario;
		this.idJogo = idJogo;
		this.idPlataforma = idPlataforma;
	}


	public JogoUsuario(int idUsuario, int idJogo, int idPlataforma, boolean interesse) {
		super();
		this.idUsuario = idUsuario;
		this.idJogo = idJogo;
		this.idPlataforma = idPlataforma;
		this.interesse = interesse;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}
	public int getIdPlataforma() {
		return idPlataforma;
	}
	public void setIdPlataforma(int idPlataforma) {
		this.idPlataforma = idPlataforma;
	}

	public boolean isInteresse() {
		return interesse;
	}

	public void setInteresse(boolean interesse) {
		this.interesse = interesse;
	}
	
}
