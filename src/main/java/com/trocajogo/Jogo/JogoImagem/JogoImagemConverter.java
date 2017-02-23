package com.trocajogo.Jogo.JogoImagem;

import com.genericdata.AbstractConverter;

public class JogoImagemConverter extends AbstractConverter<JogoImagem, JogoImagemDTO> {

	@Override
	public JogoImagem toEntity(JogoImagemDTO jogoImagemDTO) {
		return toEntity(jogoImagemDTO, new JogoImagem());
	}

	@Override
	public JogoImagem toEntity(JogoImagemDTO jogoImagemDTO, JogoImagem jogoImagem) {
		
		return jogoImagem.setId(jogoImagemDTO.id)
				  .setIdJogo(jogoImagemDTO.idJogo)
				  .setImagemJogo(jogoImagemDTO.imagemJogo);
	}

	@Override
	public JogoImagemDTO toRepresentation(JogoImagem jogoImagem) {
		JogoImagemDTO jogoImagemDTO = new JogoImagemDTO();
		jogoImagemDTO.id = jogoImagem.getId();
		jogoImagemDTO.idJogo = jogoImagem.getIdJogo();
		jogoImagemDTO.imagemJogo = jogoImagem.getImagemJogo();
		
		return jogoImagemDTO;
	}

}
