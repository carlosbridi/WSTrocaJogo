package com.trocajogo.Jogo.JogoUsuario;

import javax.inject.Inject;

import com.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaConverter;
import com.trocajogo.Usuario.UsuarioRepository;

public class JogoUsuarioConverter extends AbstractConverter<JogoUsuario, JogoUsuarioDTO> {

	
	@Inject
	private JogoPlataformaConverter jogoPlataformaConverter;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	public JogoUsuarioConverter() {
		super();
		jogoPlataformaConverter = new JogoPlataformaConverter();
		usuarioRepository = new UsuarioRepository();
	}
	
	@Override
	public JogoUsuario toEntity(JogoUsuarioDTO jogoUsuarioDTO) {
		return toEntity(jogoUsuarioDTO);
	}

	@Override
	public JogoUsuario toEntity(JogoUsuarioDTO jogoUsuarioDTO, JogoUsuario jogoUsuario) {
		return jogoUsuario.setId(jogoUsuarioDTO.id)
				.setUsuario(usuarioRepository.findByIdThrowsException(jogoUsuarioDTO.idUsuario))
				.setInteresse(jogoUsuarioDTO.interesse)
				.setJogoPlataforma(jogoPlataformaConverter.toEntity(jogoUsuarioDTO.jogoPlataforma));
	}

	@Override
	public JogoUsuarioDTO toRepresentation(JogoUsuario jogoUsuario) {
		JogoUsuarioDTO jogoUsuarioDTO = new JogoUsuarioDTO();
		jogoUsuarioDTO.id = jogoUsuario.getId();
		jogoUsuarioDTO.idUsuario = jogoUsuario.getUsuario().getId();
		jogoUsuarioDTO.nomeUsuario = jogoUsuario.getUsuario().getNome();
		jogoUsuarioDTO.interesse = jogoUsuario.isInteresse();
		
		JogoConverter jogoConverter = new JogoConverter();
		jogoUsuarioDTO.jogo = jogoConverter.toRepresentation(jogoUsuario.getJogoPlataforma().getJogo());
		
		JogoPlataformaConverter jogoPlataformaConverter = new JogoPlataformaConverter();
		jogoUsuarioDTO.jogoPlataforma = jogoPlataformaConverter.toRepresentation(jogoUsuario.getJogoPlataforma());
		return jogoUsuarioDTO;
	}

}
