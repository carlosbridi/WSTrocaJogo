package com.trocajogo.resource;

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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.Jogo.Jogo;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuario;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioCRUD;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.model.Retorno;

@Path("/JogoColecaoWS")
public class JogoColecaoWS {

	@Context
    UriInfo uriIØnfo;
   
    
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.APPLICATION_JSON)
    public ArrayList<JogoUsuario> obterColecaoJogosUsuario(@QueryParam("idUsuario") int idUsuario) {
    	JogoUsuarioCRUD jogoCRUD = new JogoUsuarioCRUD();
    	return null; //jogoCRUD.buscarJogosUsuario(idUsuario);
    }
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno inserirJogoUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
    	int idJogoPlataforma = Integer.valueOf(buscaJogosParams.getFirst("idJogoPlataforma"));
    	int idUsuario = Integer.valueOf(buscaJogosParams.getFirst("idUsuario"));
    	
    	JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    	JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
    	
    	try{
    		JogoPlataforma jogo = jogoPlataformaCRUD.obterJogoPlataforma(idJogoPlataforma);
        	
    		if (jogoUsuarioCrud.adicionarJogoUsuario(new JogoUsuario(idUsuario, jogo))> 0){
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
    public Retorno removerJogoUsuario(@QueryParam("idUsuario") int idUsuario, @QueryParam("idJogoPlataforma") int idJogoPlataforma) {
    	JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
    	
    	try{
    		JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    		JogoPlataforma jogoPlataforma = jogoPlataformaCRUD.obterJogoPlataforma(idJogoPlataforma);
    		
    		JogoUsuario jogo = new JogoUsuario(idUsuario, jogoPlataforma);
    		
    		if (jogoUsuarioCrud.removerJogoUsuario(jogo) > 0){
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
