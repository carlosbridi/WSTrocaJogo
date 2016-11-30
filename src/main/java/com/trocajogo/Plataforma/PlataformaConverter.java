package com.trocajogo.Plataforma;

import java.util.Optional;
import javax.inject.Inject;

import com.data.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoConverter;
import com.trocajogo.Jogo.JogoRepository;

public class PlataformaConverter extends AbstractConverter<Plataforma, PlataformaDTO> {

	@Inject
	private JogoConverter jogoConverter;
	
	@Inject
	private JogoRepository jogoRepository;
	
	public PlataformaConverter() {
		jogoConverter = new JogoConverter();
		jogoRepository = new JogoRepository();
	}
	
	@Override
	public Plataforma toEntity(PlataformaDTO plataformaDTO) {
		return toEntity(plataformaDTO, new Plataforma());
	}

	@Override
	public Plataforma toEntity(PlataformaDTO plataformaDTO, Plataforma plataforma) {
		plataforma.setId(plataformaDTO.id)
				.setDescricao(plataformaDTO.descricao);
				
		return plataforma;

	}

	@Override
	public PlataformaDTO toRepresentation(Plataforma plataforma) {
		PlataformaDTO plataformaDTO = new PlataformaDTO();
		plataformaDTO.id = plataforma.getId();
		plataformaDTO.descricao = plataforma.getDescricao();
		//plataformaDTO.jogo = jogoConverter.toRepresentation(plataforma.getJogo());
		return plataformaDTO;
	}

	
}
