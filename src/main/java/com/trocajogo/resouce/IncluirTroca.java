package com.trocajogo.resouce;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import com.trocajogo.model.ItemTroca;
import com.trocajogo.model.ItensJogoTroca;
import com.trocajogo.model.Retorno;
import com.trocajogo.model.Troca;
import com.trocajogo.model.JogoPlataforma.JogoPlataforma;
import com.trocajogo.model.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.model.Plataforma.Plataforma;

@Path("/IncluirTroca")
public class IncluirTroca {
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
    public Retorno postTroca(MultivaluedMap<String, String> trocaParams) throws ParseException {
    	
    	TrocaCRUD trocaCrud = new TrocaCRUD();
    	JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    	
    	Troca troca = new Troca();
    	troca.setId(Integer.valueOf(trocaParams.getFirst("idTroca")));
    
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	java.util.Date date = dateFormat.parse(trocaParams.getFirst("dataTroca"));
    	
    	troca.setDataTroca(date);

    	ItemTroca itemTroca = new ItemTroca();
    	itemTroca.setTroca(troca);
    	itemTroca.setIdUsuarioOferta(Integer.valueOf(trocaParams.getFirst("idUsuarioOferta")));
    	itemTroca.setIdUsuarioTroca(Integer.valueOf(trocaParams.getFirst("idUsuarioTroca")));
    	itemTroca.setIdPlataformaJogoOferta(jogoPlataformaCRUD.obterIdJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoOferta")), Integer.valueOf(trocaParams.getFirst("idPlataformaOferta"))));
    	itemTroca.setIdPlataformaJogoTroca(jogoPlataformaCRUD.obterIdJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoTroca")), Integer.valueOf(trocaParams.getFirst("idPlataformaTroca"))));
    	
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
