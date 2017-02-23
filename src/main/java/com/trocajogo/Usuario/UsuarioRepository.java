package com.trocajogo.Usuario;

import static com.trocajogo.Usuario.QUsuario.usuario;

import org.springframework.stereotype.Repository;

import com.genericdata.AbstractRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Repository
public class UsuarioRepository extends AbstractRepository<Usuario, QUsuario> {

	@Override
	protected QUsuario getEntityPath() {
		return usuario;
	}

	public Usuario findByIdThrowsException(Long id) {
		BooleanExpression predicate = usuario.id.eq(id);
		return findOneThrowsException(predicate);
	}
}
