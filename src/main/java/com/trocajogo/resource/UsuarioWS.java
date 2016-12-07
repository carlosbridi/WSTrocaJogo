package com.trocajogo.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.data.generic.ServiceException;
import com.trocajogo.Usuario.Usuario;
import com.trocajogo.Usuario.UsuarioConverter;
import com.trocajogo.Usuario.UsuarioCRUD;
import com.trocajogo.Usuario.UsuarioDTO;
import com.trocajogo.defs.Retorno;
import com.trocajogo.defs.ReturnCodes;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.defs.UserFields;

@Path("/UsuarioWS")
public class UsuarioWS {

	@Context
    UriInfo uriInfo;
    	
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.APPLICATION_JSON)
    public UsuarioDTO obterDadosUsuario(@QueryParam("idUsuario") int idUsuario) {
    	UsuarioCRUD dao = new UsuarioCRUD();
    	return dao.buscarDadosUsuario(idUsuario);
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
	    	UsuarioCRUD userdao = new UsuarioCRUD();
	    		    	
	    	//verificar por email também
	    	userdao.persistirUsuario(usuario);
	    	return new Retorno(ReturnCodes.OK, "Usuário cadastrado com sucesso");
	    	
	    }catch(ServiceException e){
    		return new Retorno(0, e.getMessage());
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
	    	UsuarioCRUD userdao = new UsuarioCRUD();
	    	
	    	if (userdao.atualizarDadosComplementares(usuario) > 0){
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
