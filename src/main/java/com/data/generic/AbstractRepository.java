package com.data.generic;

import java.util.List;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

public interface AbstractRepository {

	public <T> List<T> find(Predicate... predicates);
	public <T> T findOne(Predicate... predicates);
	public <T> T findOne(OrderSpecifier<?> order, Predicate... predicates);

	public <T> T findOneThrowsException(OrderSpecifier<?> order, Predicate... predicates) throws Exception;
	public <T> T findOneThrowsException(Predicate... predicates) throws Exception;

}
