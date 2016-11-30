package com.trocajogo.Jogo.JogoUsuario;

import static com.trocajogo.Jogo.JogoUsuario.QJogoUsuario.jogoUsuario;

import java.util.List;

import javax.inject.Inject;

import com.data.generic.AbstractRepository;
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

	public List<JogoUsuarioDTO> listarJogos(int idUsuario){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogoUsuario.idUsuario.eq(idUsuario));
		
		List<JogoUsuario> listaJogoUsuario = find(booleanBuilder.getValue());
		return jogoUsuarioConverter.toRepresentation(listaJogoUsuario);
	}
	
}
