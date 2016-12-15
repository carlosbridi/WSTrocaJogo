package com.trocajogo.Jogo;

import javax.inject.Inject;

import com.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaConverter;

public class JogoConverter extends AbstractConverter<Jogo, JogoDTO> {
	
	@Inject
	private JogoPlataformaConverter jogoPlataformaConverter;
	
	@Override
	public Jogo toEntity(JogoDTO jogoDTO) {
		return toEntity(jogoDTO, new Jogo());
	}

	@Override
	public Jogo toEntity(JogoDTO jogoDTO, Jogo jogo) {
		return jogo.setId(jogoDTO.id)
				.setNomejogo(jogoDTO.nomejogo)
				.setDescricao(jogoDTO.descricao)
				.setCategoria(jogoDTO.categoria)
				.setAno(jogoDTO.ano)
				.setImagem(jogoDTO.imagem)
				.setPlataforma(jogoPlataformaConverter.toEntity(jogoDTO.jogoPlataforma));
	}

	@Override
	public JogoDTO toRepresentation(Jogo jogo) {
		JogoDTO jogoDTO = new JogoDTO();
		jogoDTO.id = jogo.getId();
		jogoDTO.nomejogo = jogo.getNomejogo();
		jogoDTO.descricao = jogo.getDescricao();
		jogoDTO.categoria = jogo.getCategoria();
		jogoDTO.ano = jogo.getAno();
		jogoDTO.imagem = jogo.getImagem();
		JogoPlataformaConverter plataformaConverter = new JogoPlataformaConverter();
		jogoDTO.jogoPlataforma =  plataformaConverter.toRepresentation(jogo.getPlataforma());
		
		return jogoDTO;
		
	}

	
}
