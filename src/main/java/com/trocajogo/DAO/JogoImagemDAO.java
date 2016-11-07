package com.trocajogo.DAO;


import javax.ws.rs.Path;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.model.JogoImagem;

@Path("/JogoImagem")
public class JogoImagemDAO {
	
	public JogoImagem obterImagemJogo(int idJogo){
		Session sessao = HibernateUtil.getSession();
		
		Criteria cri = sessao.createCriteria(JogoImagem.class)
				.add(Restrictions.eq("idJogo", idJogo));
		
		if (!cri.list().isEmpty())
			return (JogoImagem) cri.list().get(0);
   	    else
   	    	return new JogoImagem();
	}

}
