package com.trocajogo.Jogo;

import static com.trocajogo.Jogo.QJogo.jogo;

import java.util.List;

import javax.inject.Inject;

import com.genericdata.AbstractRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;


public class JogoRepository extends AbstractRepository<Jogo, QJogo> {

	@Inject
	private JogoConverter jogoConverter;
	
	public JogoRepository() {
		super();
		jogoConverter = new JogoConverter();
	}
	
	@Override
	protected QJogo getEntityPath() {
		return jogo;
	}
	
	public Jogo findByIdThrowsException(int idJogo) {
		BooleanExpression predicate = jogo.id.eq(idJogo);
		return findOneThrowsException(predicate);
	}

	public List<JogoDTO> buscarJogos(String nomeJogo, int categoria, int idPlataforma){
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(jogo.nomejogo.toUpperCase().like("%" + nomeJogo.toUpperCase() + "%"));
		booleanBuilder.and(jogo.categoria.eq(categoria));
		
		List<Jogo> listaJogo = find(booleanBuilder.getValue());
		return jogoConverter.toRepresentation(listaJogo);	
	}
	
	
}
