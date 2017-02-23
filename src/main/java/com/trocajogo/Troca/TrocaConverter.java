package com.trocajogo.Troca;

import javax.inject.Inject;

import com.genericdata.AbstractConverter;
import com.trocajogo.Troca.ItemTroca.ItemTrocaConverter;
import com.trocajogo.Troca.ItemTroca.ItemTrocaRepository;
import com.trocajogo.Usuario.UsuarioRepository;

public class TrocaConverter extends AbstractConverter<Troca, TrocaDTO> {

	@Inject
	private ItemTrocaRepository itemTrocaRepository;
	
	@Inject
	private ItemTrocaConverter itemTrocaConverter;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
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
		usuarioRepository = new UsuarioRepository();
		
		TrocaDTO trocaDTO = new TrocaDTO();
		trocaDTO.id = troca.getId();
		trocaDTO.idUsuarioOferta = troca.getIdUsuarioOferta();
		trocaDTO.nomeUsuarioOferta = usuarioRepository.findByIdThrowsException(trocaDTO.idUsuarioOferta).getNome();
		trocaDTO.idUsuarioTroca = troca.getIdUsuarioTroca();
		trocaDTO.nomeUsuarioTroca = usuarioRepository.findByIdThrowsException(trocaDTO.idUsuarioTroca).getNome();
		trocaDTO.dataTroca = troca.getDataTroca();
		trocaDTO.itemTroca = itemTrocaConverter.toRepresentation(itemTrocaRepository.findByIdThrowsExpcetion(troca.getId()));
		trocaDTO.statusTroca = troca.getStatusTroca();
		
		return trocaDTO;
	}

}
