package com.trocajogo.Usuario;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.data.generic.EntityUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import static com.trocajogo.Usuario.QUsuario.usuario;


public class UsuarioCRUD {
	
	public UsuarioCRUD() {
	}
	
	public Usuario criarUsuario(){
		return new Usuario();
	}
	
	public boolean verificarEmailUsuario(Usuario usuarioInclusao){
		JPAQuery<Usuario> query = new JPAQuery<>(EntityUtils.getEntityManager());
		Usuario anyUsuario = query.from(usuario).where(usuario.equalsEmailCadastrado(usuarioInclusao)).fetchFirst();
		return anyUsuario == null;
	}
	
	public boolean nomeUsuarioCadastrado(Usuario usuarioInclusao){
		JPAQuery<Usuario> query = new JPAQuery<>(EntityUtils.getEntityManager());
		Usuario anyUsuario = query.from(usuario).where(usuario.equalsNomeUsuarioCadastrado(usuarioInclusao)).fetchFirst();
		return anyUsuario == null;
	}
	
	public int persistirUsuario(Usuario user) throws SQLException {
		EntityManager em = EntityUtils.getEntityManager();
		try{
			em.getTransaction().begin();
			if (user.getId() == 0)
				em.persist(user);	
			else
				em.merge(user);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			em.close();
		}
		
		return user.getId();
	}
	
	public Usuario buscarUsuario(int id){
		UsuarioRepository repository = new UsuarioRepository();
		
		BooleanExpression predicate = usuario.id.eq(id);
		return (Usuario) repository.findOne(predicate);
	}
	
	public int atualizarUsuario(Usuario usuario) throws SQLException{
		Usuario userDB = this.buscarUsuario(usuario.getId());
		userDB.setNome(usuario.getNome())
		   .setNomeUsuario(usuario.getNomeUsuario())
		   .setEmail(usuario.getEmail())
		   .setSenha(usuario.getSenha())
		   .setTelefone(usuario.getTelefone())
		   .setLogradouro(usuario.getLogradouro())
		   .setNumero(usuario.getNumero())
		   .setComplemento(usuario.getComplemento())
		   .setBairro(usuario.getBairro())
		   .setEstado(usuario.getEstado())
		   .setCidade(usuario.getCidade());
		
		return this.persistirUsuario(userDB);
	}
	
	public int atualizarDadosComplementares(Usuario usuario) throws SQLException{
		Usuario userDB = this.buscarUsuario(usuario.getId());
		userDB.setCep(usuario.getCep())
		   .setLogradouro(usuario.getLogradouro())
		   .setNumero(usuario.getNumero())
		   .setComplemento(usuario.getComplemento())
		   .setBairro(usuario.getBairro())
		   .setEstado(usuario.getEstado())
		   .setCidade(usuario.getCidade());
		
		return this.persistirUsuario(userDB);
	}
	
}