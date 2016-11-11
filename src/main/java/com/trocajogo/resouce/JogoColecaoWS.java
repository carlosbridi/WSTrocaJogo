package com.trocajogo.resouce;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.DAO.JogoUsuarioCRUD;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.model.Jogo;
import com.trocajogo.model.JogoUsuario;
import com.trocajogo.model.Retorno;

@Path("/JogoColecaoWS")
public class JogoColecaoWS {

	@Context
    UriInfo uriIØnfo;
   
    
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.APPLICATION_JSON)
    public ArrayList<Jogo> obterColecaoJogosUsuario(@QueryParam("idUsuario") int idUsuario) {
    	JogoUsuarioCRUD jogoCRUD = new JogoUsuarioCRUD();
    	return jogoCRUD.buscarJogosUsuario(idUsuario);
    }
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno inserirJogoUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
    	int idJogo = Integer.valueOf(buscaJogosParams.getFirst("idJogo"));
    	int idUsuario = Integer.valueOf(buscaJogosParams.getFirst("idUsuario"));
    	int idPlataforma = Integer.valueOf(buscaJogosParams.getFirst("idPlataforma"));
    	
    	JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
    	
    	try{
    		
    		if (jogoUsuarioCrud.adicionarJogoUsuario(new JogoUsuario(idUsuario, idJogo, idPlataforma))> 0){
    			return new Retorno(1, "Jogo adicionado com sucesso!");
    		}else{
    			return new Retorno(908, "Problemas ao adicionar jogo!");
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Retorno(908, "Problemas ao adicionar jogo!");
    	}
    }
    
    @DELETE
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno removerJogoUsuario(@QueryParam("idJogo") int idJogo, @QueryParam("idUsuario") int idUsuario, @QueryParam("idPlataforma") int idPlataforma) {
    	JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
    	
    	try{
    		if (jogoUsuarioCrud.removerJogoUsuario(new JogoUsuario(idUsuario, idJogo, idPlataforma)) > 0){
    			return new Retorno(1, "Jogo removido com sucesso!");
    		}else{
    			return new Retorno(908, "Problemas ao remover jogo!");
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    		return new Retorno(908, "Problemas ao remover jogo!");
    	}
    }
    
	
}
