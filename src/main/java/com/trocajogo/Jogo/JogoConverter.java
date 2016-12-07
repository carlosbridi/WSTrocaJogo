package com.trocajogo.Jogo;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.data.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaRepository;

public class JogoConverter extends AbstractConverter<Jogo, JogoDTO> {
	
	@Inject
	private JogoPlataformaRepository jogoPlataformaRepository;
		
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
				.setPlataforma(Optional.ofNullable(jogoDTO.plataforma).map(plataformas -> {
					return plataformas.stream().map(plataforma -> {
						if (plataforma.id != 0){
							JogoPlataforma jogoPlat = jogoPlataformaRepository.findByIdThrowsException(plataforma.id);
							return jogoPlataformaConverter.toEntity(plataforma, jogoPlat);
						}else{
							return jogoPlataformaConverter.toEntity(plataforma);
						}
					}).collect(Collectors.toList());
				}).orElse(null));
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
		jogoDTO.plataforma =  plataformaConverter.toRepresentation(jogo.getPlataforma());
		
		return jogoDTO;
		
	}

	
}
