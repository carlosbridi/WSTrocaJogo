package com.trocajogo.ResourceWS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.Troca.StatusTroca;
import com.trocajogo.Troca.Troca;
import com.trocajogo.Troca.TrocaCRUD;
import com.trocajogo.Troca.TrocaDTO;
import com.trocajogo.Troca.TrocaExpcetion;
import com.trocajogo.Troca.ItemTroca.ItemTroca;
import com.trocajogo.defs.Retorno;
import com.trocajogo.defs.TipoDef;

@Path("/TrocaWS")
public class TrocaWS {
	@Context
    UriInfo uriInfo;
   
    @Context
    Request request;	
	
    @GET
    @Produces(TipoDef.APPLICATION_JSON)
    public List<TrocaDTO> buscarTrocasUsuario(@QueryParam("idUsuario") int idUsuario) {
        TrocaCRUD trocaCRUD = new TrocaCRUD();
        return trocaCRUD.listarTrocasUsuario(idUsuario > 0 ? idUsuario : 1);
    }
    
    @PUT
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno postTroca(MultivaluedMap<String, String> trocaParams) throws ParseException, Exception {
    	
    	TrocaCRUD trocaCrud = new TrocaCRUD();
    	JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    	
    	Troca troca = new Troca();
    	troca.setId(Integer.valueOf(trocaParams.getFirst("idTroca")));
    	troca.setIdUsuarioOferta(Integer.valueOf(trocaParams.getFirst("idUsuarioOferta")));
    	troca.setIdUsuarioTroca(Integer.valueOf(trocaParams.getFirst("idUsuarioTroca")));
    	
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	java.util.Date date = dateFormat.parse(trocaParams.getFirst("dataTroca"));
    	
    	troca.setStatusTroca(StatusTroca.ANALISE);
    	
    	troca.setDataTroca(date);

    	ItemTroca itemTroca = new ItemTroca();
    	itemTroca.setIdUsuarioOferta(troca.getIdUsuarioOferta());
    	itemTroca.setIdUsuarioTroca(troca.getIdUsuarioTroca());
    	
    	JogoPlataforma jogoPlataformaOferta = jogoPlataformaCRUD.obterJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoPlataformaOferta")));
    	itemTroca.setJogoPlataformaOferta(jogoPlataformaOferta);
    	
    	JogoPlataforma jogoPlataformaTroca = jogoPlataformaCRUD.obterJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoPlataformaTroca"))); 
    	itemTroca.setJogoPlataformaTroca(jogoPlataformaTroca);
    	
    	itemTroca.setTroca(troca);
    	troca.setItemTroca(itemTroca);
    	
    	try{
    		if (trocaCrud.inserirTroca(troca) > 0){
    			return new Retorno(troca.getId(), "Troca incluída com sucesso");
    		}else{
    			return new Retorno(999, "Falha ao incluir troca remotamente, tente novamente mais tarde!");
    		}
    	}catch(TrocaExpcetion e){
    		return new Retorno (998, e.getMessage());
    	}
    }
    
    @POST
    @Consumes(TipoDef.APPLICATION_FORM_URLENCODED)
    @Produces(TipoDef.APPLICATION_JSON)
    public Retorno atualizarStatusTroca(MultivaluedMap<String, String> statusTrocaParams) {
    	int idTroca = Integer.valueOf(statusTrocaParams.getFirst("idTroca"));
    	String statusTroca = statusTrocaParams.getFirst("statusTroca");
    	
    	StatusTroca status = StatusTroca.from(statusTroca);	
    	
    	TrocaCRUD trocaCrud = new TrocaCRUD();
    	if (trocaCrud.atualizarStatusTroca(idTroca, status) > 0){
    		return new Retorno(1, "Atualizada com sucesso");
    	}else{
    		return new Retorno(909, "Problemas ao atualizar");
    	}
    }
}
