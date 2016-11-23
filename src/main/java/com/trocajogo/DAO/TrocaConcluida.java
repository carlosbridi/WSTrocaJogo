package com.trocajogo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.banco.*;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuarioCRUD;
import com.trocajogo.model.*;

public class TrocaConcluida {

	public int idTroca;
	public Troca troca;
	
	public TrocaConcluida(int idTroca){
		this.idTroca = idTroca;
		TrocaDAO trocaDAO = new TrocaDAO();
		
		troca = trocaDAO.obterTroca(idTroca);
	}
	
	
	public int efetuarTroca(){
		Connection conn = conexao.conectar();
		PreparedStatement cmd;
		String sql = "DELETE FROM JOGOUSUARIO WHERE IDUSUARIO = ? AND IDPLATAFORMA = ?";
		try {
			cmd = conn.prepareStatement(sql);
			
			cmd.setInt(1, troca.getJogoTroca().getIdUsuarioTroca());
			cmd.setInt(2, troca.getJogoTroca().getJogoTrocaPlataforma().getPlataforma().getId());
			
			cmd.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		try {
			cmd = conn.prepareStatement(sql);
			
			cmd.setInt(1, troca.getJogoTroca().getIdUsuarioOferta());
			
			//cmd.setInt(2, troca.getJogoTroca().getJogoOferta().getPlataforma().g );
			
			cmd.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		JogoUsuarioCRUD jogoUsuarioCRUD = new JogoUsuarioCRUD();
		//jogoUsuarioCRUD.adicionarJogoUsuario(new JogoUsuario(troca.getJogoTroca().getIdUsuarioTroca(), troca.getJogoTroca().getJogoOfertaPlataforma().getId(), troca.getJogoTroca().getJogoOfertaPlataforma().getPlataforma().getId()));
		//jogoUsuarioCRUD.adicionarJogoUsuario(new JogoUsuario(troca.getJogoTroca().getIdUsuarioOferta(), troca.getJogoTroca().getJogoTrocaPlataforma().getId(), troca.getJogoTroca().getJogoTrocaPlataforma().getPlataforma().getId()));
		
		return 1;
				
	}
	
	
}
