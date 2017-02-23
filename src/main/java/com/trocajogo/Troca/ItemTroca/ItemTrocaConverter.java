package com.trocajogo.Troca.ItemTroca;

import javax.inject.Inject;

import com.genericdata.AbstractConverter;
import com.trocajogo.Jogo.JogoConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaRepository;

public class ItemTrocaConverter extends AbstractConverter<ItemTroca, ItemTrocaDTO> {

	@Inject
	private JogoConverter jogoConverter;
	
	@Inject
	private JogoPlataformaRepository jogoPlataformaRepository;
	
	@Inject
	private JogoPlataformaConverter jogoPlataformaConverter;
	
	@Override
	public ItemTroca toEntity(ItemTrocaDTO itemTrocaDTO) {
		return toEntity(itemTrocaDTO, new ItemTroca());
	}

	@Override
	public ItemTroca toEntity(ItemTrocaDTO itemTrocaDTO, ItemTroca itemTroca) {
		return itemTroca.setId(itemTrocaDTO.id)
				.setIdUsuarioOferta(itemTrocaDTO.idUsuarioOferta)
				.setIdUsuarioTroca(itemTrocaDTO.idUsuarioTroca)
				.setJogoPlataformaOferta(jogoPlataformaRepository.findByIdThrowsException(itemTrocaDTO.jogoPlataformaOferta.id))
				.setJogoPlataformaTroca(jogoPlataformaRepository.findByIdThrowsException(itemTrocaDTO.jogoPlataformaTroca.id));
	}

	@Override
	public ItemTrocaDTO toRepresentation(ItemTroca itemTroca) {
		jogoPlataformaConverter = new JogoPlataformaConverter();
		jogoConverter = new JogoConverter();
		
		ItemTrocaDTO itemTrocaDTO = new ItemTrocaDTO();
		itemTrocaDTO.id = itemTroca.getId();
		itemTrocaDTO.idUsuarioOferta = itemTroca.getIdUsuarioOferta();
		itemTrocaDTO.idUsuarioTroca = itemTroca.getIdUsuarioTroca();
		itemTrocaDTO.jogoPlataformaOferta = jogoPlataformaConverter.toRepresentation(itemTroca.getJogoPlataformaOferta());
		itemTrocaDTO.jogoOferta = jogoConverter.toRepresentation(itemTroca.getJogoPlataformaOferta().getJogo());
		itemTrocaDTO.jogoPlataformaTroca = jogoPlataformaConverter.toRepresentation(itemTroca.getJogoPlataformaTroca());
		itemTrocaDTO.jogoTroca = jogoConverter.toRepresentation(itemTroca.getJogoPlataformaTroca().getJogo());
		return itemTrocaDTO;
	}

}
