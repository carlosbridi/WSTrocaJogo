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

import com.trocajogo.DAO.TrocaCRUD;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.model.Retorno;
import com.trocajogo.model.StatusTroca;

@Path("/AtualizarStatusTroca")
public class AtualizarStatusTroca {

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
    public Retorno atualizarStatusTroca(MultivaluedMap<String, String> statusTrocaParams) {
    	int idTroca = Integer.valueOf(statusTrocaParams.getFirst("idTroca"));
    	String statusTroca = statusTrocaParams.getFirst("statusTroca");
    	
    	StatusTroca status = null;
    	
    	
    	TrocaCRUD trocaCrud = new TrocaCRUD();
    	if (trocaCrud.atualizarStatusTroca(idTroca, status) > 0){
    		return new Retorno(1, "Atualizada com sucesso");
    	}else{
    		return new Retorno(909, "Problemas ao atualizar");
    	}
    	
    	
    }
	
}

