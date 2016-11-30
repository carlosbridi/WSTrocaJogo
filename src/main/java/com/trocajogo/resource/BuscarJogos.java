package com.trocajogo.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.Jogo.JogoDTO;
import com.trocajogo.Jogo.JogoRepository;
import com.trocajogo.defs.TipoDef;

@Path("/BuscarJogos")
public class BuscarJogos {

	@Context
    UriInfo uriInfo;
   
    
    @Context
    Request request;	
	
 
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public List<JogoDTO> postUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
    	String nomeJogo = buscaJogosParams.getFirst("nome");
    	int plataforma = Integer.valueOf(buscaJogosParams.getFirst("plataforma"));
    	int categoria = Integer.valueOf(buscaJogosParams.getFirst("categoria"));
    	
    	JogoRepository  jogoPlataforma = new JogoRepository();
    	
    	try{
    		return jogoPlataforma.buscarJogos(nomeJogo, categoria, plataforma);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new ArrayList<JogoDTO>();
    	}
    }
}
