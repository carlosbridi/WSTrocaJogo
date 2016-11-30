package com.trocajogo.Jogo.JogoPlataforma;

import static com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma.jogoPlataforma;

import javax.inject.Inject;

import com.data.generic.AbstractRepository;
import com.data.generic.ServiceException;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.trocajogo.Jogo.JogoConverter;

public class JogoPlataformaRepository extends AbstractRepository<JogoPlataforma, QJogoPlataforma> {


	@Inject 
	private JogoConverter jogoConverter;

	@Override
	protected QJogoPlataforma getEntityPath() {
		return jogoPlataforma;
	}
	
	public JogoPlataformaRepository() {
		super();
		jogoConverter = new JogoConverter();
	}
	
	public JogoPlataforma findByIdThrowsException(Integer id) throws ServiceException {
		BooleanExpression predicate = jogoPlataforma.id.eq(id);
		return findOneThrowsException(predicate);
	}
	
	

}
