package com.trocajogo.resouce;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.DAO.UsuarioDAO;
import com.trocajogo.defs.ReturnCodes;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.defs.UserFields;
import com.trocajogo.model.Retorno;
import com.trocajogo.model.Usuario;

@Path("/UsuarioWS")
public class UsuarioWS {

    
    @Context
    UriInfo uriInfo;
   
    	
    @Context
    Request request;	
	
    @GET
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.TEXT_PLAIN)
    public Usuario obterDadosUsuario(MultivaluedMap<String, String> usuarioParams) {
    	UsuarioDAO dao = new UsuarioDAO();
    	Usuario usuario = dao.buscarUsuario(Integer.valueOf(usuarioParams.getFirst("id")));
    	return usuario;
    }
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno postUsuario(MultivaluedMap<String, String> usuarioParams) {
    	Integer id = Integer.valueOf(usuarioParams.getFirst(UserFields.ID));
    	String nomeusuario = usuarioParams.getFirst(UserFields.NOMEUSUARIO);
    	String nome = usuarioParams.getFirst(UserFields.NOME);
    	String telefone = usuarioParams.getFirst(UserFields.TELEFONE);
    	String senha = usuarioParams.getFirst(UserFields.SENHA);
    	String email = usuarioParams.getFirst(UserFields.EMAIL);
    	
    	Usuario usuario = new Usuario();
    	usuario.setId(id)
    		   .setNomeUsuario(nomeusuario)
    		   .setNome(nome)
    		   .setEmail(email)
    		   .setSenha(senha)
    		   .setTelefone(telefone);
    	
    	try{
	    	UsuarioDAO userdao = new UsuarioDAO();
	    	
	    	//verificar por email também
	    	if (userdao.nomeUsuarioCadastrado(nomeusuario)){
	    		return new Retorno(ReturnCodes.NOMEUSUARIO_CADASTRADO, "Já existe um usuário com esse nome de usuário cadastrado.");
	    	}else if (userdao.verificarEmailUsuario(usuario)){
	    		return new Retorno(ReturnCodes.EMAILUSUARIO_CADASTRADO, "Já existe um usuário com esse email cadastradao.");
	    	}else{
	    		userdao.persistirUsuario(usuario);
	    		return new Retorno(ReturnCodes.OK, "Usuário cadastrado com sucesso");
	    	}
	    }catch(SQLException e){
    		e.printStackTrace();
    		return new Retorno(0, "Erro ao cadastrar usuário");
    	}
    }
    
    
    @PUT
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno atualizarDadosEnderecoUsuario(MultivaluedMap<String, String> usuarioParams) {
    	Integer id = Integer.valueOf(usuarioParams.getFirst(UserFields.ID));
    	
    	String cep = usuarioParams.getFirst(UserFields.CEP);
    	String logradouro = usuarioParams.getFirst(UserFields.LOGRADOURO);
    	String numero = usuarioParams.getFirst(UserFields.NUMERO);
    	String complemento = usuarioParams.getFirst(UserFields.COMPLEMENTO);
    	String bairro = usuarioParams.getFirst(UserFields.BAIRRO);
    	String estado = usuarioParams.getFirst(UserFields.ESTADO);
    	String cidade = usuarioParams.getFirst(UserFields.CIDADE);
    	
    	Usuario usuario = new Usuario();
    	usuario.setId(id)
    		   .setCep(cep)
    		   .setLogradouro(logradouro)
    		   .setNumero(numero)
    		   .setComplemento(complemento)
    		   .setBairro(bairro)
    		   .setEstado(estado)
    		   .setCidade(cidade);
    	
    	try{
	    	UsuarioDAO userdao = new UsuarioDAO();
	    	
	    	if (userdao.updDadosComplementares(usuario) > 0){
	    		return new Retorno(ReturnCodes.OK, "Usuário atualizado com sucesso");
	    	}else{
	    		return new Retorno(ReturnCodes.ATUALIZARDADOSENDERECO, "Ocorreu um erro ao atualizar os dados de endereço!");
	    	}	    	
	    }catch(Exception e){
    		e.printStackTrace();
    		return new Retorno(0, "Erro ao atualizar dados de endereço do usuário.");
    	}
    }
    
}
