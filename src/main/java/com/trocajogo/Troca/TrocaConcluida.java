package com.trocajogo.Troca;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioCRUD;

public class TrocaConcluida {

	public int idTroca;
	public Troca troca;
	private JogoPlataforma jogoOferta;
	private JogoPlataforma jogoTroca;
	
	private JogoUsuarioCRUD jogoUsuarioCRUD;
	
	public TrocaConcluida(int idTroca){
		this.idTroca = idTroca;
		troca = obterTroca();
		int i = troca.getItemTroca().getJogoPlataformaOferta().getId();
		int x = troca.getItemTroca().getJogoPlataformaTroca().getId();
		jogoOferta = troca.getItemTroca().getJogoPlataformaOferta();
		jogoTroca = troca.getItemTroca().getJogoPlataformaTroca();
		jogoUsuarioCRUD = new JogoUsuarioCRUD();
	}
	
	private Troca obterTroca(){
		TrocaCRUD trocaCRUD = new TrocaCRUD();
		return trocaCRUD.obterTroca(idTroca);
	}
	
	public void efetuarTroca(){
		removerJogoColecaoUsuarioOferta();
		removerJogoColecaoUsuarioTroca();
		incluirJogoColecaoUsuarioOferta();
		incluirJogoColecaoUsuarioTroca();
	}
	
	private void removerJogoColecaoUsuarioOferta(){
		jogoUsuarioCRUD.removerJogoUsuario(troca.getIdUsuarioOferta(), jogoOferta.getJogoPlataforma().getId(), false);
	}
	
	private void removerJogoColecaoUsuarioTroca(){
		jogoUsuarioCRUD.removerJogoUsuario(troca.getIdUsuarioTroca(), jogoTroca.getJogoPlataforma().getId(), false);
	}
	
	private void incluirJogoColecaoUsuarioOferta(){
		jogoUsuarioCRUD.adicionarJogoUsuario(troca.getIdUsuarioTroca(), jogoOferta, false);
	}
	
	private void incluirJogoColecaoUsuarioTroca(){
		jogoUsuarioCRUD.adicionarJogoUsuario(troca.getIdUsuarioOferta(), jogoTroca, false);
	}
}
