package com.trocajogo.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.banco.conexao;
import com.trocajogo.Plataforma.Plataforma;
import com.trocajogo.model.ItensJogoTroca;
import com.trocajogo.model.Troca;

public class TrocaDAO {
	
	
	public Troca obterTroca(int idTroca){
		
		Troca troca = new Troca();
		String sqlTroca = "SELECT idtroca, datatroca, status FROM TROCA WHERE IDTROCA = "+idTroca;
		
		Connection conn = conexao.conectar();
		PreparedStatement psTroca;
		
		try{
			psTroca = conn.prepareStatement(sqlTroca);
			ResultSet resTroca = psTroca.executeQuery();
			
			if (resTroca.next()){
				troca = parseCabecalhoTroca(resTroca);
				
				String SQLItens = sqlItens(troca.getId());

				PreparedStatement psItensJogo = conn.prepareStatement(SQLItens);
				ResultSet resItens = psItensJogo.executeQuery();
				
				while (resItens.next()){
					troca.setJogoTroca(parseItemTroca(resItens));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return troca;
		
	}
	
	public java.util.ArrayList<Troca> listarTroca(int idUsuario){
		String sqlTroca = "SELECT idtroca, datatroca, status "+
						    "FROM TROCA WHERE IDTROCA IN (SELECT IDTROCA FROM ITEMTROCA WHERE ((IDUSUARIOOFERTA = "+idUsuario+") or (IDUSUARIOTROCA = "+idUsuario+")))";
		
		Connection conn = conexao.conectar();
		PreparedStatement psTroca;
		
		java.util.ArrayList<Troca> listaTroca = new ArrayList<Troca>();
		
		try{
			psTroca = conn.prepareStatement(sqlTroca);
			ResultSet resTroca = psTroca.executeQuery();
			
			while (resTroca.next()){
				Troca troca = parseCabecalhoTroca(resTroca);
				
				String SQLItens = sqlItens(troca.getId());
				
				PreparedStatement psItensJogo = conn.prepareStatement(SQLItens);
				ResultSet resItens = psItensJogo.executeQuery();
				
				while (resItens.next()){
					troca.setJogoTroca(parseItemTroca(resItens));
				}
				
				listaTroca.add(troca);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listaTroca;
	}
	
	
	
	private String sqlItens(int idTroca){
		return "SELECT ITEMTROCA.IDITEMTROCA, "+
					  "ITEMTROCA.IDTROCA, "+
					  "ITEMTROCA.IDUSUARIOOFERTA, "+
					  "ITEMTROCA.IDUSUARIOTROCA, "+
					  "ITEMTROCA.IDJOGOOFERTA, "+
					  "ITEMTROCA.IDJOGOTROCA, "+
					  "ITEMTROCA.PLATAFORMATROCA, "+
					  "ITEMTROCA.PLATAFORMAOFERTA, "+
					  "ITEMTROCA.NOMEUSUARIOTROCA, "+
					  "ITEMTROCA.NOMEUSUARIOOFERTA, "+
					  "JOGOTROCA.ID JOGOTROCAID, "+
					  "JOGOTROCA.NOMEJOGO NOMEJOGOTROCA, "+
					  "JOGOTROCA.DESCRICAO JOGOTROCADESCRICAO, "+
					  "JOGOTROCA.CATEGORIA JOGOTROCACATEGORIA, "+
					  "JOGOTROCA.ANO JOGOTROCAANO, "+
					  "JOGOTROCA.IMAGEM JOGOTROCAIMAGEM, "+
					  "JOGOOFERTA.ID JOGOOFERTAID, "+
					  "JOGOOFERTA.NOMEJOGO NOMEJOGOOFERTA, "+
					  "JOGOOFERTA.DESCRICAO JOGOOFERTADESCRICAO, "+
					  "JOGOOFERTA.CATEGORIA JOGOOFERTACATEGORIA, "+
					  "JOGOOFERTA.ANO JOGOOFERTAANO, "+
					  "JOGOOFERTA.IMAGEM JOGOOFERTAIMAGEM "+
				"FROM ITEMTROCA ITEMTROCA,  "+
				     "JOGO JOGOTROCA, JOGO JOGOOFERTA "+  
				"WHERE JOGOTROCA.ID = ITEMTROCA.IDJOGOTROCA "+ 
				  "AND JOGOOFERTA.ID = ITEMTROCA.IDJOGOOFERTA ";
	}
	
	
	private Troca parseCabecalhoTroca(ResultSet resTroca){
		Troca troca = new Troca();
		
		try{
			troca.setId(resTroca.getInt("idtroca"));
			troca.setDataTroca(resTroca.getDate("datatroca"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return troca;
	}
	
	
	private ItensJogoTroca parseItemTroca(ResultSet resItens){
		ItensJogoTroca itemjogoTroca = new ItensJogoTroca();
		
		try{
//			itemjogoTroca.getJogoOferta().setId(resItens.getInt("idjogooferta"));
//			itemjogoTroca.getJogoTroca().setId(resItens.getInt("idjogotroca"));
//			
//			itemjogoTroca.getJogoOferta().setNomejogo(resItens.getString("nomejogooferta"));
//			itemjogoTroca.getJogoTroca().setNomejogo(resItens.getString("nomejogotroca"));
//			itemjogoTroca.getJogoOferta().setDescricao(resItens.getString("jogoofertadescricao"));
//			itemjogoTroca.getJogoTroca().setDescricao(resItens.getString("jogotrocadescricao"));
//			itemjogoTroca.getJogoOferta().setCategoria(resItens.getInt("jogoofertacategoria"));
//			itemjogoTroca.getJogoTroca().setCategoria(resItens.getInt("jogotrocacategoria"));;
//			itemjogoTroca.getJogoTroca().setPlataforma(new Plataforma(resItens.getInt("plataformatroca")));
//			itemjogoTroca.getJogoOferta().setPlataforma(new Plataforma(resItens.getInt("plataformaoferta")));
//			itemjogoTroca.getJogoTroca().setAno(resItens.getInt("jogotrocaano"));
//			itemjogoTroca.getJogoOferta().setAno(resItens.getInt("jogoofertaano"));
//			itemjogoTroca.getJogoTroca().setImagem(resItens.getString("jogotrocaimagem"));
//			itemjogoTroca.getJogoOferta().setImagem(resItens.getString("jogoofertaimagem"));
			
			itemjogoTroca.setIdUsuarioOferta(resItens.getInt("idusuariooferta"));
			itemjogoTroca.setIdUsuarioTroca(resItens.getInt("idusuariotroca"));
			itemjogoTroca.setNomeUsuarioTroca(resItens.getString("nomeusuariotroca"));
			itemjogoTroca.setNomeUsuarioOferta(resItens.getString("nomeusuariooferta"));
			//itemjogoTroca.setImagem(resItens.getString("imagem"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return itemjogoTroca;
	}
	
}