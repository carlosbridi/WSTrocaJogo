package com.trocajogo.Troca.ItemTroca;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Troca.Troca;

@SequenceGenerator(name = "itemtrocaid_seq", sequenceName = "itemtrocaid_seq", allocationSize = 1, initialValue = 1)
@Entity
@Table(name = "itemtroca")
public class ItemTroca {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemtrocaid_seq")
	@Id
	@Column(name = "iditemtroca")
	private int id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "idtroca")
	private Troca troca;
	
	@OneToOne
	private JogoPlataforma jogoPlataformaTroca;
	
	@OneToOne
	private JogoPlataforma jogoPlataformaOferta;	
	
	@Column(name = "idusuariooferta")
	private Long idUsuarioOferta;
	
	@Column(name = "idusuariotroca")
	private Long idUsuarioTroca;

	public ItemTroca(){
		
	}
	
	public int getId() {
		return id;
	}

	public ItemTroca setId(int id) {
		this.id = id;
		return this;
	}

	public Troca getTroca() {
		return troca;
	}

	public ItemTroca setTroca(Troca troca) {
		this.troca = troca;
		return this;
	}

	
	public Long getIdUsuarioOferta() {
		return idUsuarioOferta;
	}

	public ItemTroca setIdUsuarioOferta(Long idUsuarioOferta) {
		this.idUsuarioOferta = idUsuarioOferta;
		return this;
	}

	public Long getIdUsuarioTroca() {
		return idUsuarioTroca;
	}

	public ItemTroca setIdUsuarioTroca(Long idUsuarioTroca) {
		this.idUsuarioTroca = idUsuarioTroca;
		return this;
	}

	public JogoPlataforma getJogoPlataformaTroca() {
		return jogoPlataformaTroca;
	}

	public ItemTroca setJogoPlataformaTroca(JogoPlataforma jogoPlataformaTroca) {
		this.jogoPlataformaTroca = jogoPlataformaTroca;
		return this;
	}

	public JogoPlataforma getJogoPlataformaOferta() {
		return jogoPlataformaOferta;
	}

	public ItemTroca setJogoPlataformaOferta(JogoPlataforma jogoPlataformaOferta) {
		this.jogoPlataformaOferta = jogoPlataformaOferta;
		return this;
	}
	
	
	
}
