package com.trocajogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.banco.conexao;
import com.trocajogo.model.Jogo;
import com.trocajogo.model.TempJogoBusca;
import com.trocajogo.model.JogoPlataforma.JogoPlataforma;
import com.trocajogo.model.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.model.Plataforma.Plataforma;
import com.trocajogo.model.Plataforma.PlataformaCRUD;

public class JogoDAO {

	String sqlWhere = " and 1=1 ";
	
	public ArrayList<Jogo> buscarJogos(String nomeJogo, int categoria, int plataforma){
		Session sessao = HibernateUtil.getSession();
		
		Criteria cri = sessao.createCriteria(Jogo.class);
		String nome = "%"+nomeJogo+"%";
		nome = nome.replace("\"", "");
		cri.add(Restrictions.like("nomejogo", nome));
		//cri.add(Restrictions.eq("nomejogo", "Call of Duty: Black Ops"));

		return (ArrayList) cri.list();
	}
	
	
	public Jogo buscarDadosJogo(int idJogo, int idPlataforma){
		Jogo jogo = new Jogo();
		String sql = "SELECT JOGO.ID, JOGO.NOMEJOGO, JOGO.DESCRICAO JOGODESCRICAO, "+
	            "JOGO.ANO,JOGO.CATEGORIA, CATEGORIAJOGO.CATEGORIA DESCRICAOCATEGORIA, "+
	            "PLATAFORMA.DESCRICAO PLATAFORMADESCRICAO, JOGOPLATAFORMA.IDPLATAFORMA IDPLATAFORMA, JOGO.IMAGEM "+
           "FROM JOGO, JOGOPLATAFORMA, PLATAFORMA, CATEGORIAJOGO "+
          "WHERE JOGO.ID = JOGOPLATAFORMA.IDJOGO "+
          	"AND JOGOPLATAFORMA.IDPLATAFORMA = PLATAFORMA.ID "+
          	"AND CATEGORIAJOGO.ID = JOGO.CATEGORIA "+
          	"AND JOGO.ID = "+idJogo + 
            " AND JOGOPLATAFORMA.IDPLATAFORMA = " + String.valueOf(idPlataforma);
		
		sql += sqlWhere;
		
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()){
				jogo = new Jogo();
				jogo.setId(res.getInt("id"));
				jogo.setNomejogo(res.getString("nomejogo"));
				jogo.setDescricao(res.getString("jogodescricao"));
				jogo.setCategoria(res.getInt("categoria"));
				jogo.setAno(res.getInt("ano"));
				jogo.getPlataforma().add(new JogoPlataforma(jogo.getId(), PlataformaCRUD.buscarPlataforma(res.getInt("idplataforma"))));
				jogo.setImagem(res.getString("imagem"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jogo;
	}
	
	public ArrayList<TempJogoBusca> buscarJogosUsuario(int idUsuario, String nomeJogo, int categoria, int plataforma){
		ArrayList<TempJogoBusca> jogos = new ArrayList<TempJogoBusca>();	
		
		String sql = "SELECT JOGO.ID, JOGOUSUARIO.ID idjogousuario, JOGOUSUARIO.IDUSUARIO, JOGOUSUARIO.IDJOGO, JOGO.NOMEJOGO, "+
				            "JOGO.DESCRICAO, JOGO.CATEGORIA, JOGO.DESCRICAO JOGODESCRICAO, "+
						    "JOGO.ANO, JOGO.IMAGEM, PLATAFORMA.DESCRICAO, USUARIO.ID CODUSUARIO, "+
				            "USUARIO.NOME, JOGOPLATAFORMA.IDPLATAFORMA "+
					   "FROM JOGOUSUARIO, JOGO, CATEGORIAJOGO, JOGOPLATAFORMA, PLATAFORMA, USUARIO "+
				   	  "WHERE JOGOUSUARIO.IDJOGO = JOGO.ID "+
						"AND JOGOUSUARIO.IDPLATAFORMA = JOGOPLATAFORMA.ID "+
					    "AND JOGOUSUARIO.IDPLATAFORMA = PLATAFORMA.ID "+
						"AND CATEGORIAJOGO.ID = JOGO.CATEGORIA "+
						"AND JOGOUSUARIO.IDUSUARIO = USUARIO.ID "+
						"AND JOGOUSUARIO.IDUSUARIO <> " + String.valueOf(idUsuario);
		
		String[] ar = nomeJogo.split(" ");
		sqlWhere += " and (";
		for (int x=0; ar.length-1 >= x ; x++){
			sqlWhere += "(lower(jogo.nomejogo) like lower('%" + ar[x].toLowerCase() + "%')) or ";
		}
		
		sqlWhere = sqlWhere.substring(0, sqlWhere.length()-3) + ")";
		
		if (categoria > 0)
			sqlWhere += " AND JOGO.CATEGORIA = " + String.valueOf(categoria);
		
		if (plataforma > 0)
			sqlWhere += " AND JOGOPLATAFORMA.IDPLATAFORMA = " + String.valueOf(plataforma);
			
		sql += sqlWhere;
		
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		try {
			JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
			
			ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				TempJogoBusca jogo = new TempJogoBusca();
				jogo.setId(res.getInt("ID"));
				jogo.setId(res.getInt("idjogo"));
				jogo.setNomejogo(res.getString("nomejogo"));
				jogo.setDescricao(res.getString("jogodescricao"));
				jogo.setCategoria(res.getInt("categoria"));
				jogo.setAno(res.getInt("ano"));
				
				jogo.setPlataforma(jogoPlataformaCRUD.obterListaPlataformaJogo(jogo.getId()));
				
				//jogo.setPlataforma(PlataformaCRUD.buscarPlataforma(res.getInt("idplataforma")));
				
				jogo.setImagem(res.getString("imagem"));
				jogo.setIdUsuarioTroca(res.getInt("codusuario"));
				jogo.setNomeUsuarioTroca(res.getString("nome"));
				jogos.add(jogo);
			}
		  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogos;
		
	}
	
}

