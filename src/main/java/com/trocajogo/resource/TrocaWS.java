package com.trocajogo.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.Troca.StatusTroca;
import com.trocajogo.Troca.Troca;
import com.trocajogo.Troca.TrocaCRUD;
import com.trocajogo.Troca.ItemTroca.ItemTroca;
import com.trocajogo.defs.Retorno;
import com.trocajogo.defs.TipoDef;

@Path("/IncluirTroca")
public class TrocaWS {
	@Context
    UriInfo uriInfo;
   
    
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.TEXT_PLAIN)
    public String respondAsReady() {
        return "Serviço WEBLocal funcionando!";
    }
    
    @PUT
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
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno postTroca(MultivaluedMap<String, String> trocaParams) throws ParseException, Exception {
    	
    	TrocaCRUD trocaCrud = new TrocaCRUD();
    	JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    	
    	Troca troca = new Troca();
    	troca.setId(Integer.valueOf(trocaParams.getFirst("idTroca")));
    
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	java.util.Date date = dateFormat.parse(trocaParams.getFirst("dataTroca"));
    	
    	troca.setStatusTroca(StatusTroca.ANALISE);
    	
    	troca.setDataTroca(date);

    	ItemTroca itemTroca = new ItemTroca();
    	itemTroca.setIdUsuarioOferta(Integer.valueOf(trocaParams.getFirst("idUsuarioOferta")));
    	itemTroca.setIdUsuarioTroca(Integer.valueOf(trocaParams.getFirst("idUsuarioTroca")));
    	
    	JogoPlataforma jogoPlataformaOferta = jogoPlataformaCRUD.obterJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoPlataformaOferta")));
    	itemTroca.setJogoPlataformaOferta(jogoPlataformaOferta);
    	
    	JogoPlataforma jogoPlataformaTroca = jogoPlataformaCRUD.obterJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoPlataformaTroca"))); 
    	itemTroca.setJogoPlataformaTroca(jogoPlataformaTroca);
    	
    	itemTroca.setTroca(troca);
    	troca.setItemTroca(itemTroca);
    	
    	try{
    		if (trocaCrud.persistirTroca(troca) > 0){
    			return new Retorno(1, "Troca incluída com sucesso");
    		}else{
    			return new Retorno(999, "Falha ao incluir troca remotamente, tente novamente mais tarde!");
    		}
    	}catch(Exception e){
    		e.printStackTrace(); 
    		return new Retorno (998, "Ocorreu um erro ao tentar incluir uma troca, tente novamente mais tarde!");
    	}
    }
}