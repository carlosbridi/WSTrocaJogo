package com.trocajogo.model;

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
	
	@Column(name = "idjogoplataformatroca")
	private int idPlataformaJogoTroca;
	
	@Column(name = "idjogoplataformaoferta")
	private int idPlataformaJogoOferta;
	
	@Column(name = "idusuariooferta")
	private int idUsuarioOferta;
	
	@Column(name = "idusuariotroca")
	private int idUsuarioTroca;

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

	public int getIdPlataformaJogoTroca() {
		return idPlataformaJogoTroca;
	}

	public ItemTroca setIdPlataformaJogoTroca(int idPlataformaJogoTroca) {
		this.idPlataformaJogoTroca = idPlataformaJogoTroca;
		return this;
	}

	public int getIdPlataformaJogoOferta() {
		return idPlataformaJogoOferta;
	}

	public ItemTroca setIdPlataformaJogoOferta(int idPlataformaJogoOferta) {
		this.idPlataformaJogoOferta = idPlataformaJogoOferta;
		return this;
	}

	public int getIdUsuarioOferta() {
		return idUsuarioOferta;
	}

	public ItemTroca setIdUsuarioOferta(int idUsuarioOferta) {
		this.idUsuarioOferta = idUsuarioOferta;
		return this;
	}

	public int getIdUsuarioTroca() {
		return idUsuarioTroca;
	}

	public ItemTroca setIdUsuarioTroca(int idUsuarioTroca) {
		this.idUsuarioTroca = idUsuarioTroca;
		return this;
	}
	
	
	
}
