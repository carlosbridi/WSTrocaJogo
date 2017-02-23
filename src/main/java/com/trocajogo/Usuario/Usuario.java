package com.trocajogo.Usuario;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.genericdata.EntityId;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.Predicate;


@SequenceGenerator(name="usuarioid_seq", sequenceName = "usuarioid_seq", 
				  allocationSize = 1, initialValue = 1)
@Entity
@Table(name="usuario")
public class Usuario implements EntityId<Long> {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioid_seq")
	@Id
	private Long id;
	private String nomeUsuario; //nickname
	private String nome; // Nome do Usu�rio - ok
	private String senha; // Senha do Usu�rio
	@Column(name = "email")
	private String email; // Email do Usu�rio
	private String telefone; //Telefone do usuário
	
	private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String estado;
    private String cidade;
	 
    public Usuario() {
		
	}
	
	public Usuario(Long id, String nomeUsuario, String nome, String senha,
			String email, String telefone, String cep, String logradouro,
			String numero, String complemento, String bairro, String estado,
			String cidade) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	@QueryDelegate(Usuario.class)
	protected static Predicate equalsEmailCadastrado(QUsuario qusuario, Usuario usuario) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qusuario.id.ne(usuario.getId()))
			   .and(qusuario.email.eq(usuario.getEmail()));
		return builder.getValue();
	}
	
	@QueryDelegate(Usuario.class)
	protected static Predicate equalsNomeUsuarioCadastrado(QUsuario qUsuario, Usuario usuario){
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qUsuario.id.ne(usuario.getId()))
			   .and(qUsuario.nomeUsuario.eq(usuario.getEmail()));
		return builder.getValue();
	}
	
	@QueryDelegate(Usuario.class)
	protected static Predicate loginUsuario(QUsuario qUsuario, String emailUsuario, String senhaUsuario){
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qUsuario.email.eq(emailUsuario))
					.and(qUsuario.senha.eq(senhaUsuario));
					
		return builder.getValue();
	}
	
	@Override
	public Long getId() {
		return id;
	}


	public Usuario setId(Long id) {
		this.id = id;
		return this;
	}


	public String getNome() {
		return nome;
	}


	public Usuario setNome(String nome) {
		this.nome = nome;
		return this;
	}


	public String getSenha() {
		return senha;
	}


	public Usuario setSenha(String senha) {
		this.senha = senha;
		return this;
	}


	public String getEmail() {
		return email;
	}


	public Usuario setEmail(String email) {
		this.email = email;
		return this;
	}


	public String getTelefone() {
		return telefone;
	}


	public Usuario setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	
	public String getCep() {
		return cep;
	}

	public Usuario setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Usuario setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public Usuario setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public Usuario setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public Usuario setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getEstado() {
		return estado;
	}

	public Usuario setEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Usuario setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public Usuario setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
		return this;
	}

	
}
