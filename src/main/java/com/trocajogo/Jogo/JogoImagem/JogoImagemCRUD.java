package com.trocajogo.Jogo.JogoImagem;

import javax.inject.Inject;

import com.genericdata.ServiceException;

public class JogoImagemCRUD {
	
	@Inject
	private JogoImagemConverter jogoImagemConverter;
	
	public JogoImagemCRUD() {
		jogoImagemConverter = new JogoImagemConverter();
	}
	
	public JogoImagem criarJogoImagem(){
		return new JogoImagem();
	}
	
	public JogoImagemDTO obterImagemJogo(int idJogo) throws ServiceException{
		JogoImagemRepository jogoImagemRepository = new JogoImagemRepository();
		JogoImagem jogoImagem = jogoImagemRepository.findByIdThrowsException(idJogo);
		
		return jogoImagemConverter.toRepresentation(jogoImagem);
	}

}
