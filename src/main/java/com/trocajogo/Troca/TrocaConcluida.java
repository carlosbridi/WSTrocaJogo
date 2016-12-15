package com.trocajogo.Troca;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioCRUD;

public class TrocaConcluida {

	public Troca troca;
	private JogoPlataforma jogoOferta;
	private JogoPlataforma jogoTroca;
	
	private JogoUsuarioCRUD jogoUsuarioCRUD;
	
	public TrocaConcluida(Troca troca){
		this.troca = troca;
		jogoOferta = troca.getItemTroca().getJogoPlataformaOferta();
		jogoTroca = troca.getItemTroca().getJogoPlataformaTroca();
		jogoUsuarioCRUD = new JogoUsuarioCRUD();
	}
	
	public void efetuarTroca(){
		removerJogoColecaoUsuarioOferta();
		removerJogoColecaoUsuarioTroca();
		incluirJogoColecaoUsuarioOferta();
		incluirJogoColecaoUsuarioTroca();
	}
	
	private void removerJogoColecaoUsuarioOferta(){
		jogoUsuarioCRUD.removerJogoUsuario(troca.getIdUsuarioOferta(), jogoOferta.getId(), false);
	}
	
	private void removerJogoColecaoUsuarioTroca(){
		jogoUsuarioCRUD.removerJogoUsuario(troca.getIdUsuarioTroca(), jogoTroca.getId(), false);
	}
	
	private void incluirJogoColecaoUsuarioOferta(){
		jogoUsuarioCRUD.adicionarJogoUsuario(troca.getIdUsuarioTroca(), jogoOferta, false);
	}
	
	private void incluirJogoColecaoUsuarioTroca(){
		jogoUsuarioCRUD.adicionarJogoUsuario(troca.getIdUsuarioOferta(), jogoTroca, false);
	}
}
