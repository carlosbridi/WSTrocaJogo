package com.trocajogo.model;

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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.Converter;


@XmlRootElement(name = "Troca")
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
    
    @Transient
    private ItensJogoTroca jogoTroca; // Jogo troca do usuário remoto
    
    @OneToOne(mappedBy = "troca", cascade = CascadeType.ALL)
    private ItemTroca itemTroca;
    
    @Column(name="datatroca")
    private Date dataTroca; // Data da troca
    
    @Column(name="status")
    private StatusTroca statusTroca; // Status da Troca (Analise, Cancelada, Finalizada)
   
    public int getId() {
		return id;
	}
	
    public void setId(int id) {
		this.id = id;
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
	
	public ItensJogoTroca getJogoTroca() {
		return jogoTroca;
	}
	
	public void setJogoTroca(ItensJogoTroca jogoTroca) {
		this.jogoTroca = jogoTroca;
	}
	
	public Date getDataTroca() {
		return dataTroca;
	}
	
	public void setDataTroca(Date dataTroca) {
		this.dataTroca = dataTroca;
	}
	
	public StatusTroca getStatusTroca() {
		return statusTroca;
	}
	
	public void setStatusTroca(StatusTroca statusTroca) {
		this.statusTroca = statusTroca;
	}
	
	public ItemTroca getItemTroca() {
		return itemTroca;
	}
	
	public void setItemTroca(ItemTroca itemTroca) {
		this.itemTroca = itemTroca;
	}
	
	
	
}