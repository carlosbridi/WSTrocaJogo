package com.trocajogo.Troca.ItemTroca;

import com.querydsl.core.BooleanBuilder;

import static com.trocajogo.Troca.ItemTroca.QItemTroca.itemTroca;

import com.generic.AbstractRepository;

public class ItemTrocaRepository extends AbstractRepository<ItemTroca, QItemTroca> {

	@Override
	protected QItemTroca getEntityPath() {
		return itemTroca;
	}
	
	public ItemTroca findByIdThrowsExpcetion(int idTroca){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(itemTroca.troca.id.eq(idTroca));
		
		return findOne(booleanBuilder.getValue());
	}

}
