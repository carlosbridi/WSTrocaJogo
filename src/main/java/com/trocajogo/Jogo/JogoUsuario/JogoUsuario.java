package com.trocajogo.Jogo.JogoUsuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;

@Entity
@Table(name="jogousuario")
@XmlRootElement(name = "JogoUsuario")
public class JogoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogousuarioid_seq")
	@SequenceGenerator(name="jogousuarioid_seq", sequenceName = "jogousuarioid_seq", 
	  allocationSize = 1, initialValue = 1)
	private int id;
	private int idUsuario;
	
	@OneToOne
	@JoinColumn(name = "jogoplataforma_id")
	private JogoPlataforma jogoPlataforma;
	
	private boolean interesse;
	
	public JogoUsuario(){
		
	}
	
	public JogoUsuario(int idUsuario, JogoPlataforma jogoPlataforma) {
		super();
		this.idUsuario = idUsuario;
		this.jogoPlataforma = jogoPlataforma;
		
	}

	public JogoUsuario(int idUsuario, JogoPlataforma jogoPlataforma, boolean interesse) {
		super();
		this.idUsuario = idUsuario;
		this.jogoPlataforma = jogoPlataforma;
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
	
	public boolean isInteresse() {
		return interesse;
	}

	public void setInteresse(boolean interesse) {
		this.interesse = interesse;
	}

	public JogoPlataforma getJogoPlataforma() {
		return jogoPlataforma;
	}

	public void setJogoPlataforma(JogoPlataforma jogoPlataforma) {
		this.jogoPlataforma = jogoPlataforma;
	}
	
}
