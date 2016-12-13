package com.trocajogo.Jogo.JogoPlataforma;

public class JogoPlataformaCRUD {
	
	public JogoPlataforma obterJogoPlataforma(final int idJogoPlataforma) throws Exception{
		JogoPlataformaRepository jogoPlataformaRepository = new JogoPlataformaRepository();
		
		return jogoPlataformaRepository.findByIdThrowsException(idJogoPlataforma);
		
	}
	
}
