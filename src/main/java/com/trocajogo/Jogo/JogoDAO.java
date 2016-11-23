package com.trocajogo.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.banco.conexao;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaCRUD;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuario;
import com.trocajogo.Jogo.TempJogoBusca.TempJogoBuscaDTO;
import com.trocajogo.Plataforma.PlataformaCRUD;

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
	
	public ArrayList<TempJogoBuscaDTO> buscarJogosUsuario(int idUsuario, String nomeJogo, int categoria, int plataforma){
		
		ArrayList<TempJogoBuscaDTO> jogoUsuario = new ArrayList<TempJogoBuscaDTO>();
		
		Session sessao = HibernateUtil.getSession();
		Criteria cri = sessao.createCriteria(JogoUsuario.class);
		
		cri.add(Restrictions.eq("id", 34));
		
		if (cri.list().size() > 0){
			JogoUsuario jogo = (JogoUsuario) cri.list().get(0);
			
			TempJogoBuscaDTO tempJogoBuscaDTO = new TempJogoBuscaDTO();
			tempJogoBuscaDTO.idUsuarioTroca = jogo.getIdUsuario();
			tempJogoBuscaDTO.jogo = jogo.getJogoPlataforma().getJogoPlataforma();
			tempJogoBuscaDTO.plataforma.add(jogo.getJogoPlataforma().getPlataforma());
			
			jogoUsuario.add(tempJogoBuscaDTO);
			
		}
		return jogoUsuario;
		
		
		
	}
	
}

