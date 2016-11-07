package com.trocajogo.DAO;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.*;
import com.trocajogo.model.Usuario;

public class UsuarioDAO {
	
	private Session sessao;
	
	public UsuarioDAO() {
		sessao = HibernateUtil.getSession();
	}
	
	public boolean verificarEmailUsuario(Usuario usuarioInclusao){
		Criteria cri = sessao.createCriteria(Usuario.class)
                 .add(Restrictions.ne("id", usuarioInclusao.getId()))
                 .add(Restrictions.eq("email", usuarioInclusao.getEmail()));
				
		return !cri.list().isEmpty();
	}
	
	public boolean nomeUsuarioCadastrado(final String nomeUsuario){
		Criteria cri = sessao.createCriteria(Usuario.class)
                 .add(Restrictions.eq("nomeUsuario", nomeUsuario));
		return !cri.list().isEmpty();
	}
	
	public int persistirUsuario(Usuario user) throws SQLException {
		sessao.getTransaction().begin();
		if (user.getId() == 0)
			sessao.persist(user);
		else
			sessao.merge(user);
		sessao.getTransaction().commit();
		
		return user.getId();
	}
	
	public Usuario buscarUsuario(int id){
		if (!sessao.isOpen())
			sessao = HibernateUtil.getSession();
		Criteria cri = sessao.createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id));
		return (Usuario) cri.list().get(0);
	}

	
	public Usuario toRepresentation(Usuario usuDB, Usuario usuInstancia){
		usuInstancia.setNome(usuDB.getNome());
		usuInstancia.setNomeUsuario(usuDB.getNomeUsuario());
		usuInstancia.setEmail(usuDB.getEmail());
		usuInstancia.setSenha(usuDB.getSenha());
		usuInstancia.setTelefone(usuDB.getTelefone());
		usuInstancia.setCep(usuDB.getCep());
		usuInstancia.setLogradouro(usuDB.getLogradouro());
		usuInstancia.setComplemento(usuDB.getComplemento());
		usuInstancia.setNumero(usuDB.getNumero());
		usuInstancia.setBairro(usuDB.getBairro());
		usuInstancia.setEstado(usuDB.getEstado());
		usuInstancia.setCidade(usuDB.getCidade());
		return usuInstancia;
	}
	
	public int updInfoUsuario(Usuario usu) throws SQLException{
		Usuario usuBanco = buscarUsuario(usu.getId());
		return persistirUsuario(toRepresentation(usuBanco, usu));
		
	}
	
	public int updDadosComplementares(Usuario usu) throws SQLException{
		Usuario usuBanco = buscarUsuario(usu.getId());
		usuBanco.setCep(usu.getCep());
		usuBanco.setLogradouro(usu.getLogradouro());
		usuBanco.setNumero(usu.getNumero());
		usuBanco.setComplemento(usu.getComplemento());
		usuBanco.setBairro(usu.getBairro());
		usuBanco.setEstado(usu.getEstado());
		usuBanco.setCidade(usu.getCidade());
		
		return persistirUsuario(usuBanco);
		
	}
	
}