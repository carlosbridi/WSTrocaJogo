package com.trocajogo.Troca;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Troca.ItemTroca.ItemTroca;


@SequenceGenerator(name="trocaid_seq", sequenceName = "trocaid_seq", 
allocationSize = 1, initialValue = 1)
@Entity
@Table(name="troca")
public class Troca {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trocaid_seq")
	@Id
	@Column(name = "idtroca")
	private int id; // Id Troca
    private int idUsuarioOferta; // Meu ID
    private int idUsuarioTroca; // ID Usuário remoto
    
    @OneToOne(mappedBy = "troca", cascade = CascadeType.ALL)
    private ItemTroca itemTroca;
    
    @Column(name="datatroca")
    private Date dataTroca; // Data da troca
    
    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    private StatusTroca statusTroca; // Status da Troca (Analise, Cancelada, Finalizada)
   
    public int getId() {
		return id;
	}
	
    public Troca setId(int id) {
		this.id = id;
		return this;
	}
	
	public int getIdUsuarioOferta() {
		return idUsuarioOferta;
	}
	
	public Troca setIdUsuarioOferta(int idUsuarioOferta) {
		this.idUsuarioOferta = idUsuarioOferta;
		return this;
	}
	
	public int getIdUsuarioTroca() {
		return idUsuarioTroca;
	}
	
	public Troca setIdUsuarioTroca(int idUsuarioTroca) {
		this.idUsuarioTroca = idUsuarioTroca;
		return this;
	}
	
	public Date getDataTroca() {
		return dataTroca;
	}
	
	public Troca setDataTroca(Date dataTroca) {
		this.dataTroca = dataTroca;
		return this;
	}
	
	public StatusTroca getStatusTroca() {
		return statusTroca;
	}
	
	public Troca setStatusTroca(StatusTroca statusTroca) {
		this.statusTroca = statusTroca;
		return this;
	}
	
	public ItemTroca getItemTroca() {
		return itemTroca;
	}
	
	public Troca setItemTroca(ItemTroca itemTroca) {
		this.itemTroca = itemTroca;
		return this;
	}
	
}