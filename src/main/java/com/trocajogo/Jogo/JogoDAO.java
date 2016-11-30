package com.trocajogo.Jogo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.banco.HibernateUtil;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma;
import com.trocajogo.Jogo.JogoPlataforma.JogoPlataformaDTO;
import com.trocajogo.Jogo.JogoUsuario.JogoUsuario;
import com.trocajogo.Jogo.TempJogoBusca.TempJogoBuscaDTO;

public class JogoDAO {
	
	@Inject
	private JogoRepository jogoRepository;
	
	public JogoDAO() {
		super();
		jogoRepository = new JogoRepository();
	}
	
	
	public Jogo buscarDadosJogo(int idJogo){
		return jogoRepository.findByIdThrowsException(idJogo);
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

