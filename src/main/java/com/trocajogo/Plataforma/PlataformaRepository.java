package com.trocajogo.Plataforma;

import static com.trocajogo.Plataforma.QPlataforma.plataforma;

import com.genericdata.AbstractRepository;
import com.genericdata.ServiceException;
import com.querydsl.core.types.dsl.BooleanExpression;

public class PlataformaRepository extends AbstractRepository<Plataforma, QPlataforma>{

	@Override
	protected QPlataforma getEntityPath() {
		return plataforma;
	}

	public Plataforma findByIdThrowsException(Long id) throws ServiceException {
		BooleanExpression predicate = plataforma.id.eq(id);
		return findOneThrowsException(predicate);
	}

	
}
