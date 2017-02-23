package com.trocajogo.Plataforma;

import com.genericdata.AbstractConverter;

public class PlataformaConverter extends AbstractConverter<Plataforma, PlataformaDTO> {

	
	public PlataformaConverter() {
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
		return plataformaDTO;
	}

	
}
