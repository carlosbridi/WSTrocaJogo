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

import com.trocajogo.Jogo.Jogo;
import com.trocajogo.Jogo.JogoDAO;
import com.trocajogo.defs.TipoDef;

@Path("/BuscarDadosJogo")
public class BuscarDadosJogo {
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
    public Jogo postUsuario(MultivaluedMap<String, String> dadosJogosParams) {
    	
    	int idJogo = Integer.valueOf(dadosJogosParams.getFirst("idJogo"));
    	int idPlataforma = Integer.valueOf(dadosJogosParams.getFirst("idPlataforma"));
    	
    	JogoDAO jogoDAO = new JogoDAO();
    	
    	Jogo jogo = jogoDAO.buscarDadosJogo(idJogo, idPlataforma);
    	return jogo;
    }
}
