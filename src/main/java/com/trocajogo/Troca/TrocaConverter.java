package com.trocajogo.Troca;

import javax.inject.Inject;

import com.generic.AbstractConverter;
import com.trocajogo.Troca.ItemTroca.ItemTrocaConverter;
import com.trocajogo.Troca.ItemTroca.ItemTrocaRepository;

public class TrocaConverter extends AbstractConverter<Troca, TrocaDTO> {

	@Inject
	private ItemTrocaRepository itemTrocaRepository;
	
	@Inject
	private ItemTrocaConverter itemTrocaConverter;
	
	@Override
	public Troca toEntity(TrocaDTO trocaDTO) {
		return toEntity(trocaDTO, new Troca());
	}

	@Override
	public Troca toEntity(TrocaDTO trocaDTO, Troca troca) {
		return troca.setId(trocaDTO.id)
				.setIdUsuarioOferta(trocaDTO.idUsuarioOferta)
				.setIdUsuarioTroca(trocaDTO.idUsuarioTroca)
				.setDataTroca(trocaDTO.dataTroca)
				.setItemTroca(itemTrocaConverter.toEntity(trocaDTO.itemTroca))
				.setStatusTroca(troca.getStatusTroca());
				
	}

	@Override
	public TrocaDTO toRepresentation(Troca troca) {
		itemTrocaConverter = new ItemTrocaConverter();
		itemTrocaRepository = new ItemTrocaRepository();
		
		TrocaDTO trocaDTO = new TrocaDTO();
		trocaDTO.id = troca.getId();
		trocaDTO.idUsuarioOferta = troca.getIdUsuarioOferta();
		trocaDTO.idUsuarioTroca = troca.getIdUsuarioTroca();
		trocaDTO.dataTroca = troca.getDataTroca();
		trocaDTO.itemTroca = itemTrocaConverter.toRepresentation(itemTrocaRepository.findByIdThrowsExpcetion(troca.getId()));
		trocaDTO.statusTroca = troca.getStatusTroca();
		
		return trocaDTO;
	}

}
