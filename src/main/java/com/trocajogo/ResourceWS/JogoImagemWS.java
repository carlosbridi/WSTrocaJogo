package com.trocajogo.ResourceWS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import com.trocajogo.Jogo.JogoImagem.JogoImagemCRUD;
import com.trocajogo.Jogo.JogoImagem.JogoImagemDTO;
import com.trocajogo.defs.TipoDef;


@Path("/JogoImagem")
public class JogoImagemWS {
	@Context
    UriInfo uriInfo;
   
    
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.APPLICATION_JSON)
    public JogoImagemDTO obterImagemJogo(@QueryParam("idJogo") int idJogo) {
        JogoImagemCRUD jogoImagemCRUD = new JogoImagemCRUD();
    	return jogoImagemCRUD.obterImagemJogo(idJogo);    	
    }
    
}
