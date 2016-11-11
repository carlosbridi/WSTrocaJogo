package com.trocajogo.model.JogoPlataforma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.banco.conexao;
import com.trocajogo.model.Plataforma.Plataforma;

public class JogoPlataformaCRUD {

	public List<JogoPlataforma> obterJogoPlataforma(final int idJogo){
		List<JogoPlataforma> listaJogoPlataforma = new ArrayList<JogoPlataforma>();
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		String sql = "SELECT PLATAFORMA.ID, PLATAFORMA.DESCRICAO "+ 
					   "FROM JOGOPLATAFORMA "+
				 "INNER JOIN PLATAFORMA ON JOGOPLATAFORMA.IDPLATAFORMA = PLATAFORMA.ID "+
					  "WHERE JOGOPLATAFORMA.IDJOGO = " + idJogo;
		
		try{
			ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while (res.next())
				listaJogoPlataforma.add(new JogoPlataforma(idJogo, new Plataforma(res.getInt("id"), res.getString("descricao"))));
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listaJogoPlataforma;
	}
	
	
	public List<JogoPlataforma> obterJogoPlataformaUsuario(final int idJogo){
		List<JogoPlataforma> listaJogoPlataforma = new ArrayList<JogoPlataforma>();
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		String sql = "SELECT PLATAFORMA.ID, PLATAFORMA.DESCRICAO "+ 
					   "FROM JOGOUSUARIO "+
				 "INNER JOIN PLATAFORMA ON JOGOUSUARIO.IDPLATAFORMA = PLATAFORMA.ID "+
				      "WHERE JOGOUSUARIO.IDJOGO = "+ idJogo;
		
		try{
			ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while (res.next())
				listaJogoPlataforma.add(new JogoPlataforma(idJogo, new Plataforma(res.getInt("id"), res.getString("descricao"))));
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listaJogoPlataforma;
	}
	
	public int obterIdJogoPlataforma(final int idJogo, final int idPlataforma){
		Session sessao = HibernateUtil.getSession();
		
 		Criteria criteria = sessao.createCriteria(JogoPlataforma.class)
				                  .add(Restrictions.eq("idJogo", idJogo))
				                  .add(Restrictions.eq("plataforma.id", idPlataforma));
 		
		
		return ((JogoPlataforma) criteria.list().get(0)).getId();
		
	}
	
	
}
