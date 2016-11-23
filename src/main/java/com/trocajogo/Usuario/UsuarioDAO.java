package com.trocajogo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.banco.HibernateUtil;

public class UsuarioDAO {

	public int loginUsuario(String email, String senha){
		Session sessao = HibernateUtil.getSession();
		Criteria cri = sessao.createCriteria(Usuario.class);
		
		if (cri.list().size() == 0)
			return 0;
		else
			return 1;
	}
	
}
