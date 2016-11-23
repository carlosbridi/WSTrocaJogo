package com.trocajogo.Jogo.JogoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.banco.HibernateUtil;
import com.banco.conexao;
import com.data.generic.EntityUtils;
import com.trocajogo.Jogo.Jogo;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;

public class JogoUsuarioCRUD {

	public int adicionarJogoUsuario(JogoUsuario jogoUsuario){
		EntityManager em = EntityUtils.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(jogoUsuario);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		return jogoUsuario.getId();
	}
	
	
	public int removerJogoUsuario(JogoUsuario jogoUsuario){
		Session sessao = HibernateUtil.getSession();
		
		String sql = "DELETE FROM JogoUsuario "
						 + "WHERE IDUSUARIO = :idUsuario AND "
						 	   + "JOGOPLATAFORMA_ID = :jogoplataforma_id ";
		
		try{
			sessao.getTransaction().begin();
			int reg = sessao.createQuery(sql)
							.setInteger("idUsuario", jogoUsuario.getIdUsuario())
							.setInteger("jogoplataforma_id", jogoUsuario.getJogoPlataforma().getId())
							.executeUpdate();
			sessao.getTransaction().commit();
			return reg;
		}catch(Exception e){
			sessao.getTransaction().rollback();
			e.printStackTrace();
			return 0;
		}
	}
	
//	public int removerJogoUsuarioInteresse(JogoUsuario jogoUsuario){
//		Session sessao = HibernateUtil.getSession();
//		
//		String sql = "DELETE FROM JogoUsuario "
//				         + "WHERE idusuario = :idUsuario and "
//					           + "idjogo = :idJogo and "
//					           + "idplataforma = :idPlataforma and "
//					           + "interesse = :interesse ";
//		
//		try{
//			sessao.getTransaction().begin();
//			int reg = sessao.createQuery(sql)
//							.setInteger("idUsuario", jogoUsuario.getIdUsuario())
//							.setInteger("idJogo", jogoUsuario.getIdJogo())
//							.setInteger("idPlataforma", jogoUsuario.getIdPlataforma())
//							.setBoolean("interesse", true).executeUpdate();
//			sessao.getTransaction().commit();
//			return reg;
//		}catch(Exception e){
//			sessao.getTransaction().rollback();
//			e.printStackTrace();
//			return 0;
//		}
//	}
	
	public ArrayList<Jogo> buscarJogosUsuario(int idUsuario){
		
		JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
		
		//Rever parte do join usando criteria
		String sql = "SELECT DISTINCT JOGO.ID, JOGO.NOMEJOGO, JOGO.DESCRICAO, "+
			                "JOGO.CATEGORIA, JOGO.IMAGEM, JOGO.ANO, JOGO.IMAGEM "+
			           "FROM JOGO JOGO, JOGOUSUARIO "+
					  "WHERE JOGO.ID = JOGOUSUARIO.IDJOGO "+
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
				jogo.setPlataforma(jogoPlataformaCRUD.obterListaPlataformaJogo(jogo.getId()));
				jogo.setImagem(res.getString("imagem"));
				
				jogos.add(jogo);
			}
		  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogos;
			
	}
	
	public ArrayList<Jogo> buscarJogosUsuarioInteresse(int idUsuario){
		
		JogoPlataformaCRUD jogoPlataformaCRUD = new JogoPlataformaCRUD();
		
		//Rever parte do join usando criteria
		String sql = "SELECT JOGO.ID, JOGO.NOMEJOGO, JOGO.DESCRICAO, "+
			       "JOGO.CATEGORIA, JOGO.IMAGEM, JOGO.ANO, JOGO.IMAGEM "+
			"FROM JOGO JOGO, JOGOUSUARIO "+
			"WHERE JOGO.ID = JOGOUSUARIO.IDJOGO "+
			  "AND JOGOUSUARIO.IDUSUARIO = ? AND JOGOUSUARIO.INTERESSE = 't' "; 
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
				jogo.setPlataforma(jogoPlataformaCRUD.obterListaPlataformaJogo(jogo.getId()) );
				jogo.setImagem(res.getString("imagem"));
				
				jogos.add(jogo);
			}
		  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jogos;
			
	}
	
}
