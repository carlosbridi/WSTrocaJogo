package com.trocajogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.Jogo;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Plataforma.Plataforma;
import com.trocajogo.Troca.Troca;

@XmlRootElement(name = "ItensJogoTroca")
@SequenceGenerator(name = "itemtrocaid_seq", sequenceName = "itemtrocaid_seq", allocationSize = 1, initialValue = 1)
@Entity

public class ItensJogoTroca{
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemtrocaid_seq")
	@Id
	private int iditemtroca;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "idtroca")
	private Troca troca;
	
	@OneToOne
	private Jogo jogoOferta;
	
	@OneToOne
	private Jogo jogoTroca;

	@OneToOne
	private Plataforma plataformaOferta;
	
	@OneToOne
	private Plataforma plataformaTroca;
	
	@Transient
	private JogoPlataforma jogoTrocaPlataforma;
	
    @Column(name = "idusuariooferta")
    private int idUsuarioOferta;
    
    @Column(name = "idusuariotroca")
    private int idUsuarioTroca;
    
    @Column(name = "nomeusuariotroca")
    private String nomeUsuarioTroca;
    
    @Column(name = "nomeusuariooferta")
    private String nomeUsuarioOferta;
        
    public ItensJogoTroca(){
    	
    }

    public int getIditemtroca() {
		return iditemtroca;
	}

	public void setIditemtroca(int iditemtroca) {
		this.iditemtroca = iditemtroca;
	}
    
	public int getIdUsuarioOferta() {
        return idUsuarioOferta;
    }

    public void setIdUsuarioOferta(int idUsuarioOferta) {
        this.idUsuarioOferta = idUsuarioOferta;
    }

    public int getIdUsuarioTroca() {
        return idUsuarioTroca;
    }

    public void setIdUsuarioTroca(int idUsuarioTroca) {
        this.idUsuarioTroca = idUsuarioTroca;
    }

    public String getNomeUsuarioTroca() {
        return nomeUsuarioTroca;
    }

    public void setNomeUsuarioTroca(String nomeUsuarioTroca) {
        this.nomeUsuarioTroca = nomeUsuarioTroca;
    }

    public String getNomeUsuarioOferta() {
        return nomeUsuarioOferta;
    }

    public void setNomeUsuarioOferta(String nomeUsuarioOferta) {
        this.nomeUsuarioOferta = nomeUsuarioOferta;
    }

	public Troca getTroca() {
		return troca;
	}

	public void setTroca(Troca troca) {
		this.troca = troca;
	}

	public JogoPlataforma getJogoTrocaPlataforma() {
		return jogoTrocaPlataforma;
	}

	public void setJogoTrocaPlataforma(JogoPlataforma jogoTrocaPlataforma) {
		this.jogoTrocaPlataforma = jogoTrocaPlataforma;
	}

	public Jogo getJogoOferta() {
		return jogoOferta;
	}

	public void setJogoOferta(Jogo jogoOferta) {
		this.jogoOferta = jogoOferta;
	}

	public Jogo getJogoTroca() {
		return jogoTroca;
	}

	public void setJogoTroca(Jogo jogoTroca) {
		this.jogoTroca = jogoTroca;
	}

	public Plataforma getPlataformaOferta() {
		return plataformaOferta;
	}

	public void setPlataformaOferta(Plataforma plataformaOferta) {
		this.plataformaOferta = plataformaOferta;
	}

	public Plataforma getPlataformaTroca() {
		return plataformaTroca;
	}

	public void setPlataformaTroca(Plataforma plataformaTroca) {
		this.plataformaTroca = plataformaTroca;
	}

	

	
	
	
	
}
