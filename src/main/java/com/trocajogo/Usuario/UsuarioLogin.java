package com.trocajogo.Usuario;

import javax.persistence.EntityManager;

import com.genericdata.EntityConnectionUtils;
import com.querydsl.jpa.impl.JPAQuery;
import static com.trocajogo.Usuario.QUsuario.usuario;

public class UsuarioLogin {

	public Long loginUsuario(String emailUsuario, String senhaUsuario){
		EntityManager em = EntityConnectionUtils.getEntityManager();
		
		JPAQuery<Usuario> queryUsuario = new JPAQuery<>(em);
		Usuario anyUsuario = queryUsuario.from(usuario).where(usuario.loginUsuario(emailUsuario, senhaUsuario)).fetchOne();
		if (anyUsuario != null)
			return anyUsuario.getId();
		else
			return -1L;
	}
	
}
