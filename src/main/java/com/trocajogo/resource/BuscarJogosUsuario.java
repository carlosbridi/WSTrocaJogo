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

import com.trocajogo.Jogo.TempJogoBusca.JogoBuscaRepository;
import com.trocajogo.Jogo.TempJogoBusca.TempJogoBuscaDTO;
import com.trocajogo.defs.TipoDef;

@Path("/BuscarJogosUsuario")
public class BuscarJogosUsuario {
	
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
    public ArrayList<TempJogoBuscaDTO> postUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
    	int idCodUsuario = Integer.valueOf(buscaJogosParams.getFirst("idUsuario"));
    	String nomeJogo = buscaJogosParams.getFirst("nome");
    	int plataforma = Integer.valueOf(buscaJogosParams.getFirst("plataforma"));
    	int categoria = Integer.valueOf(buscaJogosParams.getFirst("categoria"));
    	
    	JogoBuscaRepository jogoBuscaRepository = new JogoBuscaRepository();
    	
    	try{
    		return jogoBuscaRepository.buscarJogosUsuario(idCodUsuario, nomeJogo, categoria, plataforma);
    	}catch(Exception e){
    		e.printStackTrace();
    		return new ArrayList<TempJogoBuscaDTO>();
    	}
    }
    
}
