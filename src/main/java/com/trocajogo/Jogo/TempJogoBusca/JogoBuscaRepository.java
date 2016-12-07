package com.trocajogo.Jogo.TempJogoBusca;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuario;

public class JogoBuscaRepository {
	
	public ArrayList<TempJogoBuscaDTO> buscarJogosUsuario(int idUsuario, String nomeJogo, int categoria, int plataforma){
		
		ArrayList<TempJogoBuscaDTO> jogoUsuario = new ArrayList<TempJogoBuscaDTO>();
		
		Session sessao = HibernateUtil.getSession();
		Criteria cri = sessao.createCriteria(JogoUsuario.class);
		
		cri.add(Restrictions.eq("id", 34));
		
		if (cri.list().size() > 0){
			JogoUsuario jogo = (JogoUsuario) cri.list().get(0);
			
			TempJogoBuscaDTO tempJogoBuscaDTO = new TempJogoBuscaDTO();
			tempJogoBuscaDTO.idUsuarioTroca = jogo.getIdUsuario();
	//		tempJogoBuscaDTO.plataforma.add(jogo.getJogoPlataforma().getPlataforma());
			
			jogoUsuario.add(tempJogoBuscaDTO);
			
		}
		return jogoUsuario;
		
		
		
	}
}
