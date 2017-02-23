package com.trocajogo.Troca;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Troca.ItemTroca.ItemTrocaDTO;

@XmlRootElement(name = "TrocaDTO")
public class TrocaDTO {
	public int id; 
    public Long idUsuarioOferta; 
    public String nomeUsuarioOferta;
    public Long idUsuarioTroca; 
    public String nomeUsuarioTroca;
    public ItemTrocaDTO itemTroca;
    public Date dataTroca;
    public StatusTroca statusTroca;
}
