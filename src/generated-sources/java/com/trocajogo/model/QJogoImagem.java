package com.trocajogo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJogoImagem is a Querydsl query type for JogoImagem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJogoImagem extends EntityPathBase<JogoImagem> {

    private static final long serialVersionUID = 1057233603L;

    public static final QJogoImagem jogoImagem = new QJogoImagem("jogoImagem");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idJogo = createNumber("idJogo", Integer.class);

    public final StringPath imagemJogo = createString("imagemJogo");

    public QJogoImagem(String variable) {
        super(JogoImagem.class, forVariable(variable));
    }

    public QJogoImagem(Path<? extends JogoImagem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJogoImagem(PathMetadata metadata) {
        super(JogoImagem.class, metadata);
    }

}

