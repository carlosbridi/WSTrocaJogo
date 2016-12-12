package com.trocajogo.Troca;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Troca.ItemTroca.ItemTrocaDTO;

@XmlRootElement(name = "TrocaDTO")
public class TrocaDTO {
	public int id; 
    public int idUsuarioOferta; 
    public int idUsuarioTroca; 
    public ItemTrocaDTO itemTroca;
    public Date dataTroca;
    public StatusTroca statusTroca;
}
