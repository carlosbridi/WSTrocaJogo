package com.trocajogo.resouce;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.DAO.JogoUsuarioCRUD;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.model.Jogo;


@Path("/listarInteressesJogosUsuario")
public class ListarInteressesJogosUsuario {
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
    public ArrayList<Jogo> obterColecaoJogosUsuario(MultivaluedMap<String, String> usuarioParams) {
    	JogoUsuarioCRUD jogoCRUD = new JogoUsuarioCRUD();
    	return jogoCRUD.buscarJogosUsuarioInteresse(Integer.valueOf(usuarioParams.getFirst("idUsuario")));
    }
}
