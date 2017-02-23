package com.trocajogo.Jogo.JogoUsuario;

import static com.trocajogo.Jogo.JogoUsuario.QJogoUsuario.jogoUsuario;

import java.util.List;

import javax.inject.Inject;

import com.genericdata.AbstractRepository;
import com.querydsl.core.BooleanBuilder;

public class JogoUsuarioRepository extends AbstractRepository<JogoUsuario, QJogoUsuario> {

	@Inject
	private JogoUsuarioConverter jogoUsuarioConverter;
	
	public JogoUsuarioRepository() {
		super();
		jogoUsuarioConverter = new JogoUsuarioConverter();
	}
	
	@Override
	protected QJogoUsuario getEntityPath() {
		return jogoUsuario;
	}

	public List<JogoUsuarioDTO> listarJogosColecao(Long idUsuario){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogoUsuario.usuario.id.eq(idUsuario));
		
		List<JogoUsuario> listaJogoUsuario = find(booleanBuilder.getValue());
		return jogoUsuarioConverter.toRepresentation(listaJogoUsuario);
	}
	
	public List<JogoUsuarioDTO> listarJogosUsuarios(Long idUsuario, String nomeJogo, int categoria, int idPlataforma){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogoUsuario.usuario.id.ne(idUsuario));
		booleanBuilder.and(jogoUsuario.jogoPlataforma.jogo.nomejogo.toUpperCase().like("%" + nomeJogo.toUpperCase() + "%"));
		
		if (categoria > 0)
			booleanBuilder.and(jogoUsuario.jogoPlataforma.jogo.categoria.eq(categoria));
		
		List<JogoUsuario> listaJogoUsuario = find(booleanBuilder.getValue());
		return jogoUsuarioConverter.toRepresentation(listaJogoUsuario);
	}
		
}
