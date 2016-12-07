package com.trocajogo.Jogo.JogoUsuario;

import static com.trocajogo.Jogo.JogoUsuario.QJogoUsuario.jogoUsuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.data.generic.EntityUtils;
import com.querydsl.core.BooleanBuilder;

@Controller
public class JogoUsuarioCRUD {
	
	@Inject
	private JogoUsuarioRepository jogoUsuarioRepository;

	public JogoUsuarioCRUD() {
		super();
		jogoUsuarioRepository = new JogoUsuarioRepository();
	}
	
	public int adicionarJogoUsuario(JogoUsuario jogoUsuario){
		EntityManager em = EntityUtils.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(jogoUsuario);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return jogoUsuario.getId();
	}
	
	@Transactional
	public void removerJogoUsuario(int idUsuario, int idJogoPlataforma){
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogoUsuario.idUsuario.eq(idUsuario).and(jogoUsuario.jogoPlataforma.id.eq(idJogoPlataforma)));
		
		EntityManager em = EntityUtils.getEntityManager();
		try{
			JogoUsuario jogoUsuario = jogoUsuarioRepository.findOne(booleanBuilder.getValue());
			em.getTransaction().begin();
			em.remove(em.merge(jogoUsuario));
			em.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Transactional
	public int removerJogoUsuarioInteresse(JogoUsuario jogoUsuarioRemover){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogoUsuario.idUsuario.eq(jogoUsuarioRemover.getIdUsuario())
				.and(jogoUsuario.jogoPlataforma.id.eq(jogoUsuarioRemover.getJogoPlataforma().getId()))
				.and(jogoUsuario.interesse.eq(true)));
		
		EntityManager em = EntityUtils.getEntityManager();
		try{
			JogoUsuario jogoUsuario = jogoUsuarioRepository.findOne(booleanBuilder.getValue());
			em.getTransaction().begin();
			em.remove(em.merge(jogoUsuario));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
}
