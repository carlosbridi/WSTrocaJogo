package com.trocajogo.ResourceWS;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioCRUD;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioException;
import com.trocajogo.defs.Retorno;
import com.trocajogo.defs.TipoDef;

@Path("/JogoInteresseWS")
public class JogoInteresseWS {
	
	@Context
    UriInfo uriInfo;
    
    @Context
    Request request;
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno inserirJogoUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
    	int idJogoPlataforma = Integer.valueOf(buscaJogosParams.getFirst("idJogoPlataforma"));
    	int idUsuario = Integer.valueOf(buscaJogosParams.getFirst("idUsuario"));
    	
    	JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    	JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
    	
    	try{
    		JogoPlataforma jogoPlataforma = jogoPlataformaCRUD.obterJogoPlataforma(idJogoPlataforma);
        	
    		if (jogoUsuarioCrud.adicionarJogoUsuario(idUsuario, jogoPlataforma, true) > 0){
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
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
	public Retorno removerJogoUsuario(@QueryParam("idUsuario") int idUsuario,
			@QueryParam("idJogoPlataforma") int idJogoPlataforma) {

		JogoUsuarioCRUD jogoUsuarioCRUD = new JogoUsuarioCRUD();
		
		try {
			jogoUsuarioCRUD.removerJogoUsuario(idUsuario, idJogoPlataforma, true);
			return new Retorno(1, "Jogo removido com sucesso!");
		} catch (JogoUsuarioException e) {
			return new Retorno(908, e.getMessage());

		}

	}
}
