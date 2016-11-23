package com.trocajogo.resource;

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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.DAO.TrocaCRUD;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.Plataforma.Plataforma;
import com.trocajogo.defs.TipoDef;
import com.trocajogo.model.ItemTroca;
import com.trocajogo.model.ItensJogoTroca;
import com.trocajogo.model.Retorno;
import com.trocajogo.model.StatusTroca;
import com.trocajogo.model.Troca;

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
    public Retorno postTroca(MultivaluedMap<String, String> trocaParams) throws ParseException, Exception {
    	
    	TrocaCRUD trocaCrud = new TrocaCRUD();
    	JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
    	
    	Troca troca = new Troca();
    	troca.setId(Integer.valueOf(trocaParams.getFirst("idTroca")));
    
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	java.util.Date date = dateFormat.parse(trocaParams.getFirst("dataTroca"));
    	//troca.setStatusTroca(StatusTroca.TROCA_ANALISE);
    	
    	troca.setDataTroca(date);

    	ItemTroca itemTroca = new ItemTroca();
    	itemTroca.setIdUsuarioOferta(Integer.valueOf(trocaParams.getFirst("idUsuarioOferta")));
    	itemTroca.setIdUsuarioTroca(Integer.valueOf(trocaParams.getFirst("idUsuarioTroca")));
    	
    	JogoPlataforma jogoPlataformaOferta = jogoPlataformaCRUD.obterJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoPlataformaOferta")));
    	itemTroca.setJogoPlataformaOferta(jogoPlataformaOferta);
    	//jogoPlataformaOferta.setItemOferta(itemTroca);
    	
    	JogoPlataforma jogoPlataformaTroca = jogoPlataformaCRUD.obterJogoPlataforma(Integer.valueOf(trocaParams.getFirst("idJogoPlataformaTroca"))); 
    	itemTroca.setJogoPlataformaTroca(jogoPlataformaTroca);
    	//jogoPlataformaTroca.setItemTroca(itemTroca);
    	
    	
    	troca.setStatusTroca(StatusTroca.TROCA_ANALISE);
    	itemTroca.setTroca(troca);
    	troca.setItemTroca(itemTroca);
    	
    	try{
    		if (trocaCrud.persistirTroca(troca) > 0){
    			Session sessao2 = HibernateUtil.getSession();
				Criteria cri = sessao2.createCriteria(Troca.class);
				cri.add(Restrictions.eq("id", troca.getId()));
				
				Troca tc1;
				if (cri.list().size() > 0){
				  tc1 = (Troca) cri.list().get(0);
				  	
				  System.out.println(tc1.getItemTroca().getJogoPlataformaOferta().getJogoPlataforma().getNomejogo());
				  System.out.println(tc1.getItemTroca().getJogoPlataformaTroca().getJogoPlataforma().getNomejogo());
				}
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