package com.trocajogo.Jogo.JogoImagem;

import static com.trocajogo.Jogo.JogoImagem.QJogoImagem.jogoImagem;

import com.genericdata.AbstractRepository;
import com.genericdata.ServiceException;
import com.querydsl.core.types.dsl.BooleanExpression;

public class JogoImagemRepository extends AbstractRepository<JogoImagem, QJogoImagem> {

	@Override
	protected QJogoImagem getEntityPath() {
		return jogoImagem;
	}
	
	public JogoImagem findByIdThrowsException(Integer idJogo) throws ServiceException {
		BooleanExpression predicate = jogoImagem.idJogo.eq(idJogo);
		return findOneThrowsException(predicate);
	}

}
