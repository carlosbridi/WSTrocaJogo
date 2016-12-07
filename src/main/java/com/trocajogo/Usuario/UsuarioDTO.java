package com.trocajogo.Usuario;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Usuario")
public class UsuarioDTO {
	
	public int id;
	public String nomeUsuario; //nickname
	public String nome; // Nome do Usu�rio - ok
	public String senha; // Senha do Usu�rio
	public String email; // Email do Usu�rio
	public String telefone; //Telefone do usuário
	
	public String cep;
	public String logradouro;
	public String numero;
	public String complemento;
	public String bairro;
	public String estado;
	public String cidade;
	
}
