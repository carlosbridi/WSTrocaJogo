package com.trocajogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.banco.conexao;
import com.trocajogo.model.ItensJogoTroca;

public class TrocaItensCRUD {

	public int obterProximoId(){
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		String sql = "SELECT COALESCE(MAX(iditemtroca)+1,1) NEXTID "+
					   "FROM ITEMTROCA "; 
		try{
			ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			if(res.next()){
				return res.getInt("nextID");
			}else{
				return 1;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return 1;
			
		}
		
	}
	
	public int inserirItemTroca(int idTroca, ItensJogoTroca itensJogoTroca){
		Connection conn = conexao.conectar();
		PreparedStatement ps;
	
		
		String sql = "INSERT INTO ITEMTROCA (iditemtroca, idtroca, idusuariooferta, idusuariotroca, idjogooferta, idjogotroca, "+			
											"nomeusuariotroca, nomeusuariooferta, plataformaoferta, plataformatroca) "+
				                    "VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, this.obterProximoId());
			ps.setInt(2, idTroca);
			ps.setInt(3, itensJogoTroca.getIdUsuarioOferta());
			ps.setInt(4, itensJogoTroca.getIdUsuarioTroca());
			ps.setInt(5, itensJogoTroca.getJogoOferta().getId());
			ps.setInt(6, itensJogoTroca.getJogoTroca().getId());
			ps.setString(7, itensJogoTroca.getNomeUsuarioTroca());
			ps.setString(8, itensJogoTroca.getNomeUsuarioOferta());
			ps.setInt(9, itensJogoTroca.getJogoOferta().getPlataforma().getId());
			ps.setInt(10, itensJogoTroca.getJogoTroca().getPlataforma().getId());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
