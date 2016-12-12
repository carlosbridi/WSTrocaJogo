package com.trocajogo.Troca;

import static com.trocajogo.Troca.QTroca.troca;

import java.util.List;

import com.data.generic.AbstractRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

public class TrocaRepository extends AbstractRepository<Troca, QTroca> {

	@Override
	protected QTroca getEntityPath() {
		return troca;
	}
	
	public Troca findByIdThrowsException(int idTroca) {
		BooleanExpression predicate = troca.id.eq(idTroca);
		return findOneThrowsException(predicate);
	}

	
	public List<Troca> obterTrocasUsuario(int idUsuario){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(troca.idUsuarioOferta.eq(idUsuario));
		
		return find(booleanBuilder.getValue());
	}

}
