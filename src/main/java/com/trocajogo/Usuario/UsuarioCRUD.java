package com.trocajogo.Usuario;

import static com.trocajogo.Usuario.QUsuario.usuario;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.data.generic.EntityUtils;
import com.data.generic.ServiceException;
import com.querydsl.jpa.impl.JPAQuery;


public class UsuarioCRUD {
	
	@Inject
	private UsuarioConverter usuarioConverter;
	
	public UsuarioCRUD() {
		usuarioConverter = new UsuarioConverter();
	}
	
	public Usuario criarUsuario(){
		return new Usuario();
	}
	
	protected boolean emailCadastrado(Usuario usuarioInclusao){
		JPAQuery<Usuario> query = new JPAQuery<>(EntityUtils.getEntityManager());
		Usuario anyUsuario = query.from(usuario).where(usuario.equalsEmailCadastrado(usuarioInclusao)).fetchFirst();
		return anyUsuario == null;
	}
	
	protected boolean nomeUsuarioCadastrado(Usuario usuarioInclusao){
		JPAQuery<Usuario> query = new JPAQuery<>(EntityUtils.getEntityManager());
		Usuario anyUsuario = query.from(usuario).where(usuario.equalsNomeUsuarioCadastrado(usuarioInclusao)).fetchFirst();
		return anyUsuario == null;
	}
	
	public int persistirUsuario(Usuario user)  {
		if (this.emailCadastrado(user))
			throw new ServiceException("Email já cadastrado");	
		else if (this.nomeUsuarioCadastrado(user))
			throw new ServiceException("Nome de usuário já cadastrado");
		else
			return this.save(user);
	}
	
	private int save(Usuario usuario){
		EntityManager em = EntityUtils.getEntityManager();
		try{
			em.getTransaction().begin();
			if (usuario.getId() == 0)
				em.persist(usuario);	
			else
				em.merge(usuario);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			em.close();
		}		
		return usuario.getId();
	}
	
	public UsuarioDTO buscarDadosUsuario(int id) throws ServiceException{
		UsuarioRepository repository = new UsuarioRepository();
		Usuario usuario = repository.findByIdThrowsException(id);
		return usuarioConverter.toRepresentation(usuario);
	}
	
	public int atualizarUsuario(Usuario usuario) throws SQLException, ServiceException{
		Usuario userDB = usuarioConverter.toEntity(this.buscarDadosUsuario(usuario.getId()));
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
	
	public int atualizarDadosComplementares(Usuario usuario) throws SQLException, ServiceException{
		Usuario userDB = usuarioConverter.toEntity(this.buscarDadosUsuario(usuario.getId()));
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