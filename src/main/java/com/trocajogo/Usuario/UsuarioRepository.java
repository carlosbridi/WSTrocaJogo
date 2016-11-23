package com.trocajogo.Usuario;

import static com.trocajogo.Usuario.QUsuario.usuario;

import java.util.List;

import javax.persistence.EntityManager;

import com.data.generic.AbstractRepository;
import com.data.generic.EntityUtils;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

public class UsuarioRepository implements AbstractRepository {

	@Override
	public <T> T findOneThrowsException(OrderSpecifier<?> order, Predicate... predicates) throws Exception {
		T entity = findOne(order, predicates);
		if (entity == null) {
			throw new Exception("Registro de Usuário não encontrado.");
		}
		return entity;
	}

	@Override
	public <T> T findOne(OrderSpecifier<?> order, Predicate... predicates) {
		EntityManager em = EntityUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(usuario)
			.where(predicates)
			.orderBy(order);
		return query.fetchOne();
	}

	@Override
	public <T> List<T> find(Predicate... predicates) {
		EntityManager em = EntityUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(usuario);
		query.where(predicates);
		return query.fetch();
	}

	@Override
	public <T> T findOneThrowsException(Predicate... predicates)  throws Exception {
		T entity = findOne(predicates);
		if (entity == null) {
			throw new Exception("Registro de Usuário não encontrado.");
		}
		return entity;
	}

	@Override
	public <T> T findOne(Predicate... predicates) {
		EntityManager em = EntityUtils.getEntityManager();
		JPAQuery<T> query = new JPAQuery<>(em);
		query.from(usuario)
			.where(predicates);
		return query.fetchOne();
	}

}
