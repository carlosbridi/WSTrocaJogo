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

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.Predicate;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Usuario.QUsuario;
import com.trocajogo.Usuario.Usuario;

@Entity
@Table(name="jogousuario")
@XmlRootElement(name = "JogoUsuario")
public class JogoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogousuarioid_seq")
	@SequenceGenerator(name="jogousuarioid_seq", sequenceName = "jogousuarioid_seq", 
	  allocationSize = 1, initialValue = 1)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "jogoplataforma_id")
	private JogoPlataforma jogoPlataforma;
	
	private boolean interesse;
	
	public JogoUsuario(){
		
	}
	
	public JogoUsuario(Usuario usuario, JogoPlataforma jogoPlataforma) {
		super();
		this.usuario = usuario;
		this.jogoPlataforma = jogoPlataforma;
		
	}

	public JogoUsuario(Usuario usuario, JogoPlataforma jogoPlataforma, boolean interesse) {
		super();
		this.usuario = usuario;
		this.jogoPlataforma = jogoPlataforma;
		this.interesse = interesse;
	}
	
	@QueryDelegate(JogoUsuario.class)
	protected static Predicate jogoUsuarioCadastrado(QJogoUsuario qJogoUsuario, int idUsuario, int idJogoPlataforma) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qJogoUsuario.usuario.id.eq(idUsuario))
			   .and(qJogoUsuario.jogoPlataforma.id.eq(idJogoPlataforma));
		return builder.getValue();
	}
	 

	public int getId() {
		return id;
	}
	public JogoUsuario setId(int id) {
		this.id = id;
		return this;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public JogoUsuario setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public boolean isInteresse() {
		return interesse;
	}

	public JogoUsuario setInteresse(boolean interesse) {
		this.interesse = interesse;
		return this;
	}

	public JogoPlataforma getJogoPlataforma() {
		return jogoPlataforma;
	}

	public JogoUsuario setJogoPlataforma(JogoPlataforma jogoPlataforma) {
		this.jogoPlataforma = jogoPlataforma;
		return this;
	}
	
}
