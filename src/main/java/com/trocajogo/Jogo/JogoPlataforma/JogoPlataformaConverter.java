package com.trocajogo.Jogo.JogoPlataforma;

import javax.inject.Inject;

import com.genericdata.AbstractConverter;
import com.trocajogo.Plataforma.PlataformaConverter;

public class JogoPlataformaConverter extends AbstractConverter<JogoPlataforma, JogoPlataformaDTO> {

		
	@Inject 
	private PlataformaConverter plataformaConverter;
	
	public JogoPlataformaConverter() {
		super();
		plataformaConverter = new PlataformaConverter();
	}
	
	@Override
	public JogoPlataforma toEntity(JogoPlataformaDTO representation) {
		return toEntity(representation);
	}

	@Override
	public JogoPlataforma toEntity(JogoPlataformaDTO jogoPlataformaDTO, JogoPlataforma jogoPlataforma) {
		return jogoPlataforma.setId(jogoPlataformaDTO.id)
				.setJogo(jogoPlataforma.getJogo())
				.setPlataforma(jogoPlataforma.getPlataforma());
	}

	@Override
	public JogoPlataformaDTO toRepresentation(JogoPlataforma jogoPlataforma) {
		JogoPlataformaDTO jogoPlataformaDTO = new JogoPlataformaDTO();
		jogoPlataformaDTO.id = jogoPlataforma.getId();
		jogoPlataformaDTO.plataforma = plataformaConverter.toRepresentation(jogoPlataforma.getPlataforma());
		return jogoPlataformaDTO;
	}

}
