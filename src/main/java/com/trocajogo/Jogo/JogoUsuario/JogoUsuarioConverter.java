package com.trocajogo.Jogo.JogoUsuario;

import javax.inject.Inject;
import com.data.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaConverter;

public class JogoUsuarioConverter extends AbstractConverter<JogoUsuario, JogoUsuarioDTO> {

	
	@Inject
	private JogoPlataformaConverter jogoPlataformaConverter;
	
	
	public JogoUsuarioConverter() {
		super();
		jogoPlataformaConverter = new JogoPlataformaConverter();
	}
	
	@Override
	public JogoUsuario toEntity(JogoUsuarioDTO jogoUsuarioDTO) {
		return toEntity(jogoUsuarioDTO);
	}

	@Override
	public JogoUsuario toEntity(JogoUsuarioDTO jogoUsuarioDTO, JogoUsuario jogoUsuario) {
		return jogoUsuario.setId(jogoUsuarioDTO.id)
				.setIdUsuario(jogoUsuarioDTO.idUsuario)
				.setInteresse(jogoUsuarioDTO.interesse)
				.setJogoPlataforma(jogoPlataformaConverter.toEntity(jogoUsuarioDTO.jogoPlataforma));
	}

	@Override
	public JogoUsuarioDTO toRepresentation(JogoUsuario jogoUsuario) {
		JogoUsuarioDTO jogoUsuarioDTO = new JogoUsuarioDTO();
		jogoUsuarioDTO.id = jogoUsuario.getId();
		jogoUsuarioDTO.idUsuario = jogoUsuario.getIdUsuario();
		jogoUsuarioDTO.interesse = jogoUsuario.isInteresse();
		
		JogoConverter jogoConverter = new JogoConverter();
		jogoUsuarioDTO.jogoDTO = jogoConverter.toRepresentation(jogoUsuario.getJogoPlataforma().getJogo());
		
		JogoPlataformaConverter jogoPlataformaConverter = new JogoPlataformaConverter();
		jogoUsuarioDTO.jogoPlataforma = jogoPlataformaConverter.toRepresentation(jogoUsuario.getJogoPlataforma());
		return jogoUsuarioDTO;
	}

}
