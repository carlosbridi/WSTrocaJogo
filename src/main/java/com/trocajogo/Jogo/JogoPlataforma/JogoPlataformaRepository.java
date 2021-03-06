package com.trocajogo.Jogo.JogoPlataforma;

import static com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma.jogoPlataforma;

import com.genericdata.AbstractRepository;
import com.genericdata.ServiceException;
import com.querydsl.core.types.dsl.BooleanExpression;

public class JogoPlataformaRepository extends AbstractRepository<JogoPlataforma, QJogoPlataforma> {


	@Override
	protected QJogoPlataforma getEntityPath() {
		return jogoPlataforma;
	}
	
	public JogoPlataforma findByIdThrowsException(Integer id) throws ServiceException {
		BooleanExpression predicate = jogoPlataforma.id.eq(id);
		return findOneThrowsException(predicate);
	}
	
}
