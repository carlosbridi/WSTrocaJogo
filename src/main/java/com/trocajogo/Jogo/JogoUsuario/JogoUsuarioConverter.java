package com.trocajogo.Jogo.JogoUsuario;

import javax.inject.Inject;
import com.data.generic.AbstractConverter;
import com.trocajogo.Jogo.JogoConverter;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaConverter;
import com.trocajogo.Usuario.UsuarioConverter;
import com.trocajogo.Usuario.UsuarioRepository;

public class JogoUsuarioConverter extends AbstractConverter<JogoUsuario, JogoUsuarioDTO> {

	
	@Inject
	private JogoPlataformaConverter jogoPlataformaConverter;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private UsuarioConverter usuarioConverter;
	
	
	public JogoUsuarioConverter() {
		super();
		jogoPlataformaConverter = new JogoPlataformaConverter();
		usuarioRepository = new UsuarioRepository();
		usuarioConverter = new UsuarioConverter();
	}
	
	@Override
	public JogoUsuario toEntity(JogoUsuarioDTO jogoUsuarioDTO) {
		return toEntity(jogoUsuarioDTO);
	}

	@Override
	public JogoUsuario toEntity(JogoUsuarioDTO jogoUsuarioDTO, JogoUsuario jogoUsuario) {
		return jogoUsuario.setId(jogoUsuarioDTO.id)
				.setUsuario(usuarioRepository.findByIdThrowsException(jogoUsuarioDTO.usuario.id))
				.setInteresse(jogoUsuarioDTO.interesse)
				.setJogoPlataforma(jogoPlataformaConverter.toEntity(jogoUsuarioDTO.jogoPlataforma));
	}

	@Override
	public JogoUsuarioDTO toRepresentation(JogoUsuario jogoUsuario) {
		JogoUsuarioDTO jogoUsuarioDTO = new JogoUsuarioDTO();
		jogoUsuarioDTO.id = jogoUsuario.getId();
		jogoUsuarioDTO.usuario = usuarioConverter.toRepresentation(jogoUsuario.getUsuario());
		jogoUsuarioDTO.interesse = jogoUsuario.isInteresse();
		
		JogoConverter jogoConverter = new JogoConverter();
		jogoUsuarioDTO.jogoDTO = jogoConverter.toRepresentation(jogoUsuario.getJogoPlataforma().getJogo());
		
		JogoPlataformaConverter jogoPlataformaConverter = new JogoPlataformaConverter();
		jogoUsuarioDTO.jogoPlataforma = jogoPlataformaConverter.toRepresentation(jogoUsuario.getJogoPlataforma());
		return jogoUsuarioDTO;
	}

}
