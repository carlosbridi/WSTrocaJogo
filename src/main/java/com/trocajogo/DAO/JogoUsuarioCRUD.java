package com.trocajogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;

import com.banco.HibernateUtil;
import com.banco.conexao;
import com.trocajogo.model.Jogo;
import com.trocajogo.model.JogoUsuario;
import com.trocajogo.model.Plataforma.Plataforma;

public class JogoUsuarioCRUD {

	public int adicionarJogoUsuario(JogoUsuario jogoUsuario){
		Session sessao = HibernateUtil.getSession();
		sessao.getTransaction().begin();
		
		try{
			sessao.persist(jogoUsuario);
			sessao.getTransaction().commit();
		}catch (Exception e){
			sessao.getTransaction().rollback();
			e.printStackTrace();
		}
		return jogoUsuario.getId();
	}
	
	
	public int removerJogoUsuario(JogoUsuario jogoUsuario){
		Session sessao = HibernateUtil.getSession();
		
		String sql = "DELETE FROM JogoUsuario "
						 + "WHERE IDUSUARIO = :idUsuario AND "
						 	   + "IDJOGO = :idJogo AND "
						 	   + "IDPLATAFORMA = :idPlataforma ";
		
		try{
			sessao.getTransaction().begin();
			int reg = sessao.createQuery(sql)
							.setInteger("idUsuario", jogoUsuario.getIdUsuario())
							.setInteger("idJogo", jogoUsuario.getIdJogo())
							.setInteger("idPlataforma", jogoUsuario.getIdPlataforma()).executeUpdate();
			sessao.getTransaction().commit();
			return reg;
		}catch(Exception e){
			sessao.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}
	}
	
	public int removerJogoUsuarioInteresse(JogoUsuario jogoUsuario){
		Session sessao = HibernateUtil.getSession();
		
		String sql = "DELETE FROM JogoUsuario "
				         + "WHERE idusuario = :idUsuario and "
					           + "idjogo = :idJogo and "
					           + "idplataforma = :idPlataforma and "
					           + "interesse = :interesse ";
		
		try{
			sessao.getTransaction().begin();
			int reg = sessao.createQuery(sql)
							.setInteger("idUsuario", jogoUsuario.getIdUsuario())
							.setInteger("idJogo", jogoUsuario.getIdJogo())
							.setInteger("idPlataforma", jogoUsuario.getIdPlataforma())
							.setBoolean("interesse", true).executeUpdate();
			sessao.getTransaction().commit();
			return reg;
		}catch(Exception e){
			sessao.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}
	}
	
	public ArrayList<Jogo> buscarJogosUsuario(int idUsuario){
		
		//Rever parte do join usando criteria
		String sql = "SELECT jogo.ID, "+
			       "jogo.NOMEJOGO, "+
			       "jogo.DESCRICAO, "+
			       "jogo.CATEGORIA, "+
			       "jogo.IMAGEM, jogo.ano, jogo.imagem, "+
			       "JOGOUSUARIO.idplataforma  as plataforma "+
			"FROM JOGO jogo, JOGOUSUARIO, JOGOPLATAFORMA, plataforma "+
			"WHERE JOGO.ID = JOGOUSUARIO.IDJOGO "+
			  "AND JOGO.ID = JOGOPLATAFORMA.IDJOGO "+
			  "AND plataforma.id = jogoplataforma.idplataforma "+
			  "AND JOGOUSUARIO.IDUSUARIO = ?"; 
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				Jogo jogo = new Jogo();
				jogo.setId(res.getInt("id"));
				jogo.setNomejogo(res.getString("nomejogo"));
				jogo.setDescricao(res.getString("descricao"));
				jogo.setCategoria(res.getInt("categoria"));
				jogo.setAno(res.getInt("ano"));
				jogo.setPlataforma(new Plataforma(res.getInt("plataforma")));
				jogo.setImagem(res.getString("imagem"));
				
				jogos.add(jogo);
			}
		  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogos;
			
	}
	
	public ArrayList<Jogo> buscarJogosUsuarioInteresse(int idUsuario){
		
		//Rever parte do join usando criteria
		String sql = "SELECT jogo.ID, "+
			       "jogo.NOMEJOGO, "+
			       "jogo.DESCRICAO, "+
			       "jogo.CATEGORIA, "+
			       "jogo.IMAGEM, jogo.ano, jogo.imagem, "+
			       "JOGOUSUARIO.idplataforma  as plataforma "+
			"FROM JOGO jogo, JOGOUSUARIO, JOGOPLATAFORMA, plataforma "+
			"WHERE JOGO.ID = JOGOUSUARIO.IDJOGO "+
			  "AND JOGO.ID = JOGOPLATAFORMA.IDJOGO "+
			  "AND plataforma.id = jogoplataforma.idplataforma "+
			  "AND JOGOUSUARIO.IDUSUARIO = ? AND INTERESSE = true "; 
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				Jogo jogo = new Jogo();
				jogo.setId(res.getInt("id"));
				jogo.setNomejogo(res.getString("nomejogo"));
				jogo.setDescricao(res.getString("descricao"));
				jogo.setCategoria(res.getInt("categoria"));
				jogo.setAno(res.getInt("ano"));
				jogo.setPlataforma(new Plataforma(res.getInt("plataforma")));
				jogo.setImagem(res.getString("imagem"));
				
				jogos.add(jogo);
			}
		  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogos;
			
	}
	
}
