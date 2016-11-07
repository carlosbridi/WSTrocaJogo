package com.trocajogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.banco.conexao;
import com.trocajogo.model.Usuario;

public class UsuarioCRUD {

	public int loginUsuario(String email, String senha){
		
		Session sessao = HibernateUtil.getSession();
		Criteria cri = sessao.createCriteria(Usuario.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("senha", senha));
				
		return cri.list().size();
	}
	
	public Usuario carregarUsuario(final int ID){
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		String sql = "SELECT NOME, EMAIL, TELEFONE " +
				       "FROM USUARIO "+
		             "WHERE ID = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			Usuario usuario = new Usuario();
			usuario.setId(ID);
			usuario.setNome(res.getString("nome"));
			usuario.setEmail(res.getString("email"));
			usuario.setTelefone(res.getString("telefone"));
			return usuario;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
		
}
