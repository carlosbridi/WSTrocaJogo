package com.trocajogo.Usuario;

import com.generic.AbstractConverter;

public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDTO> {

	@Override
	public Usuario toEntity(UsuarioDTO representation) {
		return toEntity(representation, new Usuario());
	}

	@Override
	public Usuario toEntity(UsuarioDTO usuarioDTO, Usuario usuario) {
		return usuario.setNome(usuarioDTO.nome)
				.setNomeUsuario(usuarioDTO.nomeUsuario)
				.setEmail(usuarioDTO.email)
				.setSenha(usuarioDTO.senha)
				.setTelefone(usuarioDTO.telefone)
				.setCep(usuarioDTO.cep)
				.setLogradouro(usuarioDTO.logradouro)
				.setNumero(usuarioDTO.numero)
				.setComplemento(usuarioDTO.complemento)
				.setBairro(usuarioDTO.bairro)
				.setEstado(usuarioDTO.estado)
				.setCidade(usuarioDTO.cidade);
	}

	@Override
	public UsuarioDTO toRepresentation(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.id = usuario.getId();
		usuarioDTO.nome = usuario.getNome();
		usuarioDTO.nomeUsuario = usuario.getNomeUsuario();
		usuarioDTO.email = usuario.getEmail();
		usuarioDTO.senha = usuario.getSenha();
		usuarioDTO.telefone = usuario.getTelefone();
		usuarioDTO.cep = usuario.getCep();
		usuarioDTO.logradouro = usuario.getLogradouro();
		usuarioDTO.complemento = usuario.getComplemento();
		usuarioDTO.bairro = usuario.getBairro();
		usuarioDTO.estado = usuario.getEstado();
		usuarioDTO.cidade = usuario.getCidade();
		return usuarioDTO;
	}

}
