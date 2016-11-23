package com.trocajogo.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.Usuario.UsuarioDAO;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.defs.UserFields;
import com.trocajogo.model.Retorno;



@Path("/login")
public class LoginUsuario {

	@Context
	UriInfo uriInfo;


	@Context
	Request request;	


	@GET
	@Produces(TipoDef.TEXT_PLAIN)
	public String respondAsReady() {
		return "Serviço WEBLocal funcionando!";
	}

    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno loginUsuario(MultivaluedMap<String, String> usuarioParams) {
    	String email = usuarioParams.getFirst(UserFields.EMAIL);
    	String senha = usuarioParams.getFirst(UserFields.SENHA);
    	
    	UsuarioDAO usuarioCrud = new UsuarioDAO();

		int retorno = usuarioCrud.loginUsuario(email, senha);
		
		if (retorno == 0){
			return new Retorno(0, "Ocorreu erro ao fazer login.");
		}else
		if (retorno == -1){
			return new Retorno(-1, "Login ou senha inválidos!");
		}else{
			return new Retorno (retorno, "");
		}
    }

	
}
