package com.trocajogo.Troca;

public class TrocaConcluida {

	public int idTroca;
	public Troca troca;
	
	public TrocaConcluida(int idTroca){
		this.idTroca = idTroca;
		TrocaCRUD trocaCRUD = new TrocaCRUD();
		
		troca = trocaCRUD.obterTroca(idTroca);
	}
	
	
	public int efetuarTroca(){
//		Connection conn = conexao.conectar();
//		PreparedStatement cmd;
//		String sql = "DELETE FROM JOGOUSUARIO WHERE IDUSUARIO = ? AND IDPLATAFORMA = ?";
//		try {
//			cmd = conn.prepareStatement(sql);
//			
//			cmd.setInt(1, troca.getItemTroca().getIdUsuarioTroca());
//			cmd.setInt(2, troca.getItemTroca().getJogoPlataformaTroca().getPlataforma().getId());
//			
//			cmd.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0;
//		}
//		
//		try {
//			cmd = conn.prepareStatement(sql);
//			
//
//			cmd.setInt(1, troca.getItemTroca().getIdUsuarioOferta());
//			cmd.setInt(2, troca.getItemTroca().getJogoPlataformaOferta().getPlataforma().getId());
//			
//			cmd.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0;
//		}
//		
//		JogoUsuarioCRUD jogoUsuarioCRUD = new JogoUsuarioCRUD();
		//jogoUsuarioCRUD.adicionarJogoUsuario(new JogoUsuario(troca.getJogoTroca().getIdUsuarioTroca(), troca.getJogoTroca().getJogoOfertaPlataforma().getId(), troca.getJogoTroca().getJogoOfertaPlataforma().getPlataforma().getId()));
		//jogoUsuarioCRUD.adicionarJogoUsuario(new JogoUsuario(troca.getJogoTroca().getIdUsuarioOferta(), troca.getJogoTroca().getJogoTrocaPlataforma().getId(), troca.getJogoTroca().getJogoTrocaPlataforma().getPlataforma().getId()));
		
		return 1;
				
	}
	
	
}
