package com.trocajogo.Jogo.JogoImagem;

import javax.inject.Inject;

import com.data.generic.ServiceException;

public class JogoImagemCRUD {
	
	@Inject
	private JogoImagemConverter jogoImagemConverter;
	
	public JogoImagem criarJogoImagem(){
		return new JogoImagem();
	}
	
	public JogoImagemDTO obterImagemJogo(int idJogo) throws ServiceException{
		JogoImagemRepository jogoImagemRepository = new JogoImagemRepository();
		JogoImagem jogoImagem = jogoImagemRepository.findByIdThrowsException(idJogo);
		
		return jogoImagemConverter.toRepresentation(jogoImagem);
	}

}
