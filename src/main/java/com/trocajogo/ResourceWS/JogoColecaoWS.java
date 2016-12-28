package com.trocajogo.ResourceWS;

import java.util.List;

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

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaRepository;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioCRUD;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioDTO;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioException;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioRepository;
import com.trocajogo.defs.Retorno;
import com.trocajogo.defs.TipoDef;

@Path("/JogoColecaoWS")
public class JogoColecaoWS {

	@Context
    UriInfo uriIØnfo;
   
    
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.APPLICATION_JSON)
    public List<JogoUsuarioDTO> obterColecaoJogosUsuario(@QueryParam("idUsuario") int idUsuario) {
    	JogoUsuarioRepository jogoRepository = new JogoUsuarioRepository();
    	return jogoRepository.listarJogosColecao(idUsuario);
    }
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno inserirJogoUsuario(MultivaluedMap<String, String> buscaJogosParams) {
    	
    	String strUsuario = buscaJogosParams.getFirst("idUsuario");
    	int codUsuario = Integer.valueOf(strUsuario);
    	
    	int idJogoPlataforma = Integer.valueOf(buscaJogosParams.getFirst("idJogoPlataforma"));
    	int idUsuario = codUsuario;
    	
    	JogoPlataformaRepository jogoPlataformaCRUD = new JogoPlataformaRepository();
    	JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
    	
    	try{
    		JogoPlataforma jogoPlataforma = jogoPlataformaCRUD.findByIdThrowsException(idJogoPlataforma);
        	
    		if (jogoUsuarioCrud.adicionarJogoUsuario(idUsuario, jogoPlataforma, false)> 0){
    			return new Retorno(1, "Jogo adicionado com sucesso!");
    		}else{
    			return new Retorno(908, "Problemas ao adicionar jogo!");
    		}
    		
    	}catch(Exception e){
    		return new Retorno(908, e.getMessage());
    	}
    }
    
    @DELETE
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno removerJogoUsuario(@QueryParam("idUsuario") int idUsuario, @QueryParam("idJogoPlataforma") int idJogoPlataforma) {
    	try{
    		JogoUsuarioCRUD jogoUsuarioCrud = new JogoUsuarioCRUD();
        	jogoUsuarioCrud.removerJogoUsuario(idUsuario, idJogoPlataforma, false);
    		return new Retorno(1, "Jogo removido com sucesso!");
    		
    	}catch(JogoUsuarioException e){
    		return new Retorno(908, e.getMessage());
    	}
    }
    
	
}
