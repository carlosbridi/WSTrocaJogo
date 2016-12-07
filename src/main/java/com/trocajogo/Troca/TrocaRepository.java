package com.trocajogo.Troca;

import com.data.generic.AbstractRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.trocajogo.Jogo.Jogo;

import static com.trocajogo.Troca.QTroca.troca;

public class TrocaRepository extends AbstractRepository<Troca, QTroca> {

	@Override
	protected QTroca getEntityPath() {
		return troca;
	}
	
	public Troca findByIdThrowsException(int idTroca) {
		BooleanExpression predicate = troca.id.eq(idTroca);
		return findOneThrowsException(predicate);
	}


}
