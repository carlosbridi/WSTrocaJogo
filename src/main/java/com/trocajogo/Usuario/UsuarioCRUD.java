package com.trocajogo.Usuario;

import static com.trocajogo.Usuario.QUsuario.usuario;

import java.sql.SQLException;

import javax.inject.Inject;

import com.genericdata.AbstractService;
import com.genericdata.EntityConnectionUtils;
import com.genericdata.ServiceException;
import com.querydsl.jpa.impl.JPAQuery;


public class UsuarioCRUD extends AbstractService<Usuario> {
	
	@Inject
	private UsuarioConverter usuarioConverter;
	
	public UsuarioCRUD() {
		usuarioConverter = new UsuarioConverter();
	}
	
	public Usuario criarUsuario(){
		return new Usuario();
	}
	
	protected boolean emailCadastrado(Usuario usuarioInclusao){
		JPAQuery<Usuario> query = new JPAQuery<>(EntityConnectionUtils.getEntityManager());
		Usuario anyUsuario = query.from(usuario).where(usuario.equalsEmailCadastrado(usuarioInclusao)).fetchFirst();
		return anyUsuario == null;
	}
	
	protected boolean nomeUsuarioCadastrado(Usuario usuarioInclusao){
		JPAQuery<Usuario> query = new JPAQuery<>(EntityConnectionUtils.getEntityManager());
		Usuario anyUsuario = query.from(usuario).where(usuario.equalsNomeUsuarioCadastrado(usuarioInclusao)).fetchFirst();
		return anyUsuario == null;
	}
	
	public Usuario persistirUsuario(Usuario user)  {
		//this.validarChaveUsuarioCadastrado(user);
		return super.save(user);
	}
	
	private void validarChaveUsuarioCadastrado(Usuario usuarioInclusao){
		Usuario anyUsuario = null;
		JPAQuery<Usuario> query = new JPAQuery<>(EntityConnectionUtils.getEntityManager());
		
		anyUsuario = query.from(usuario).where(usuario.equalsNomeUsuarioCadastrado(usuarioInclusao)).fetchFirst();
		if (!(anyUsuario == null))
			throw new ServiceException("Nome de usuário já cadastrado");

		anyUsuario = query.from(usuario).where(usuario.equalsEmailCadastrado(usuarioInclusao)).fetchFirst();
		if (!(anyUsuario == null))
			throw new ServiceException("Email já cadastrado");
	}
	
	public UsuarioDTO buscarDadosUsuario(Long id) throws ServiceException{
		UsuarioRepository repository = new UsuarioRepository();
		Usuario usuario = repository.findByIdThrowsException(id);
		return usuarioConverter.toRepresentation(usuario);
	}
	
	public Usuario atualizarDadosComplementares(Usuario usuario) throws SQLException, ServiceException{
		Usuario userDB = usuarioConverter.toEntity(this.buscarDadosUsuario(usuario.getId()));
		userDB.setCep(usuario.getCep())
		   .setLogradouro(usuario.getLogradouro())
		   .setNumero(usuario.getNumero())
		   .setComplemento(usuario.getComplemento())
		   .setBairro(usuario.getBairro())
		   .setEstado(usuario.getEstado())
		   .setCidade(usuario.getCidade());
		
		return super.save(userDB);
	}
	
}