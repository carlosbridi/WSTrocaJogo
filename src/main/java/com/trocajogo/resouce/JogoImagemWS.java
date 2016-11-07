package com.trocajogo.resouce;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.DAO.JogoImagemDAO;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.model.JogoImagem;


@Path("/JogoImagem")
public class JogoImagemWS {
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
    public JogoImagem obterImagemJogo(MultivaluedMap<String, String> imagemJogoParams) {
    	
    	int idJogo = Integer.valueOf(imagemJogoParams.getFirst("idJogo"));
    	
    	JogoImagemDAO jogoImagemDAO = new JogoImagemDAO();
    	
    	return jogoImagemDAO.obterImagemJogo(idJogo);
    	
    }
}
