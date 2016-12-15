package com.trocajogo.Jogo.JogoUsuario;

import static com.trocajogo.Jogo.JogoUsuario.QJogoUsuario.jogoUsuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.generic.EntityUtils;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Usuario.Usuario;
import com.trocajogo.Usuario.UsuarioRepository;

@Controller
public class JogoUsuarioCRUD {
	
	@Inject
	private JogoUsuarioRepository jogoUsuarioRepository;

	@Inject
	private UsuarioRepository usuarioRepository;
	
	public JogoUsuarioCRUD() {
		super();
		jogoUsuarioRepository = new JogoUsuarioRepository();
		usuarioRepository = new UsuarioRepository();
	}
	
	private void validarJogoUsuario(int idUsuario, int idJogoPlataforma){
		if (!consistirJogoColecaoUsuario(idUsuario, idJogoPlataforma)){
			throw new JogoUsuarioException("Usuário já possui esse jogo cadastrado em sua coleção");
		}
	}
	
	private boolean consistirJogoColecaoUsuario(int idUsuario, int idJogoPlataforma){
		JPAQuery<JogoUsuario> query = new JPAQuery<>(EntityUtils.getEntityManager());
		JogoUsuario anyUsuario = query.from(jogoUsuario).where(jogoUsuario.jogoUsuarioCadastrado(idUsuario, idJogoPlataforma)).fetchFirst();
		return anyUsuario == null;
	}
	
	
	
	public int adicionarJogoUsuario(int idUsuario, JogoPlataforma jogoPlataforma, boolean interesse){
		validarJogoUsuario(idUsuario, jogoPlataforma.getId());
		Usuario usuario = usuarioRepository.findByIdThrowsException(idUsuario);
		return this.persistirJogoUsuario(new JogoUsuario(usuario, jogoPlataforma, interesse));
	}
	
	private int persistirJogoUsuario(JogoUsuario jogoUsuario){
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
	public void removerJogoUsuario(int idUsuario, int idJogoPlataforma, boolean interesse){
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogoUsuario.usuario.id.eq(idUsuario).and(jogoUsuario.jogoPlataforma.id.eq(idJogoPlataforma)).and(jogoUsuario.interesse.eq(interesse)));
		
		EntityManager em = EntityUtils.getEntityManager();
		try{
			JogoUsuario jogoUsuario = jogoUsuarioRepository.findOne(booleanBuilder.getValue());
			em.getTransaction().begin();
			em.remove(em.merge(jogoUsuario));
			em.getTransaction().commit();
			
		}catch(Exception e){
			throw new JogoUsuarioException("Erro ao remover jogo do usuario: "+e.getMessage());
		}
		
	}
	
	
	
}
