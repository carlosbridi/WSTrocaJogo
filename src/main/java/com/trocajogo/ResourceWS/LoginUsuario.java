package com.trocajogo.ResourceWS;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.Usuario.UsuarioLogin;
import com.trocajogo.defs.Retorno;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.defs.UserFields;



@Path("/login")
public class LoginUsuario {

	@Context
	UriInfo uriInfo;


	@Context
	Request request;	

    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno loginUsuario(MultivaluedMap<String, String> usuarioParams) {
    	String email = usuarioParams.getFirst(UserFields.EMAIL);
    	String senha = usuarioParams.getFirst(UserFields.SENHA);
    	
    	UsuarioLogin usuarioLogin = new UsuarioLogin();
    	int idUsuario = usuarioLogin.loginUsuario(email, senha);
    	
    	return new Retorno(idUsuario, idUsuario >= 0 ? "" : "Login ou senha inválidos");
    }

	
}
