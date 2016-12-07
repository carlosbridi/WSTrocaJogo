package com.trocajogo.resource;

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

import com.trocajogo.Troca.Troca;
import com.trocajogo.defs.TipoDef;

@Path("/BuscarTrocas")
public class BuscarTrocas {

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
    public ArrayList<Troca> postUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
//    	int idCodUsuario = Integer.valueOf(buscaJogosParams.getFirst("idUsuario"));
//    	TrocaDAO trocaDAO = new TrocaDAO();
//    	try{
//    		return trocaDAO.listarTroca(idCodUsuario);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		return new ArrayList<Troca>();
//    	}
    	return null;
    }
	
}
