package com.trocajogo.Troca.ItemTroca;

import javax.xml.bind.annotation.XmlRootElement;

import com.trocajogo.Jogo.JogoBase;
import com.trocajogo.Jogo.JogoDTO;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaDTO;

@XmlRootElement(name = "ItemTrocaDTO")
public class ItemTrocaDTO {
	public int id;
	public JogoPlataformaDTO jogoPlataformaTroca;
	public JogoBase jogoTroca;
	public JogoPlataformaDTO jogoPlataformaOferta;
	public JogoBase jogoOferta;
	public int idUsuarioOferta;
	public int idUsuarioTroca;
}
