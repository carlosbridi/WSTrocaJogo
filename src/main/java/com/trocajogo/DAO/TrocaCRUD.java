package com.trocajogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.banco.conexao;
import com.trocajogo.model.StatusTroca;
import com.trocajogo.model.Troca;

public class TrocaCRUD {
	
	
	public int obterProximoId(){
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		String sql = "SELECT COALESCE(MAX(IDTROCA)+1,1) NEXTID "+
					   "FROM TROCA "; 
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
	
	public int inserirTroca(Troca troca){
		int resultado = 0;
		Connection conn = conexao.conectar();
		PreparedStatement ps;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final String stringDate= dateFormat.format(troca.getDataTroca());
		final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
        
        String sql = "INSERT INTO TROCA (IDTROCA, DATATROCA, STATUS) VALUES (?, to_date(?, 'yyyy-MM-dd'), ?)";
       
        troca.setId(this.obterProximoId());
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, troca.getId());
			ps.setDate(2, sqlDate);
			ps.setString(3, troca.getStatusTroca().toString());
			resultado = ps.executeUpdate();
			
			if (resultado > 0){
				TrocaItensCRUD trocaItensCrud = new TrocaItensCRUD();
				resultado = trocaItensCrud.inserirItemTroca(troca.getId(), troca.getJogoTroca());
			}else{
				resultado = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resultado = 0;
		}
		
		return resultado;
		
	}
	
	public int atualizarStatusTroca(int idTroca, StatusTroca status){
		
		if (status.toString().equals(StatusTroca.TROCA_CONCLUIDA.toString())){
			TrocaConcluida trocaConcluida = new TrocaConcluida(idTroca);
			trocaConcluida.efetuarTroca();
		}
		
		Connection conn = conexao.conectar();
		PreparedStatement cmd;
		String sql = "UPDATE TROCA SET STATUS = ? WHERE IDTROCA = ? ";
		try {
			cmd = conn.prepareStatement(sql);
			
			cmd.setString(1, status.toString());
			cmd.setInt(2, idTroca);
			
			int resultado =  cmd.executeUpdate();
			
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
}

