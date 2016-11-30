package com.trocajogo.Jogo.JogoPlataforma;

import javax.inject.Inject;

import com.data.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoRepository;
import com.trocajogo.Plataforma.PlataformaConverter;
import com.trocajogo.Plataforma.PlataformaRepository;

public class JogoPlataformaConverter extends AbstractConverter<JogoPlataforma, JogoPlataformaDTO> {

	@Inject
	private JogoRepository jogoRepository;
	
	@Inject
	private PlataformaRepository plataformaRepository;
	
	@Inject 
	private PlataformaConverter plataformaConverter;
	
	public JogoPlataformaConverter() {
		super();
		jogoRepository = new JogoRepository();
		plataformaRepository = new PlataformaRepository();
		plataformaConverter = new PlataformaConverter();
	}
	
	@Override
	public JogoPlataforma toEntity(JogoPlataformaDTO representation) {
		return toEntity(representation);
	}

	@Override
	public JogoPlataforma toEntity(JogoPlataformaDTO jogoPlataformaDTO, JogoPlataforma jogoPlataforma) {
		return jogoPlataforma.setId(jogoPlataformaDTO.id)
				.setJogo(jogoRepository.findByIdThrowsException(jogoPlataformaDTO.idJogo))
				.setPlataforma(plataformaRepository.findByIdThrowsException(jogoPlataformaDTO.plataforma.id));
	}

	@Override
	public JogoPlataformaDTO toRepresentation(JogoPlataforma jogoPlataforma) {
		JogoPlataformaDTO jogoPlataformaDTO = new JogoPlataformaDTO();
		jogoPlataformaDTO.id = jogoPlataforma.getId();
		jogoPlataformaDTO.idJogo = jogoPlataforma.getJogo().getId();
		jogoPlataformaDTO.plataforma =  plataformaConverter.toRepresentation(jogoPlataforma.getPlataforma());
		return jogoPlataformaDTO;
	}

}
