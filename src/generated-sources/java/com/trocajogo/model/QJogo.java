package com.trocajogo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJogo is a Querydsl query type for Jogo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJogo extends EntityPathBase<Jogo> {

    private static final long serialVersionUID = 1199695089L;

    public static final QJogo jogo = new QJogo("jogo");

    public final NumberPath<Integer> ano = createNumber("ano", Integer.class);

    public final NumberPath<Integer> categoria = createNumber("categoria", Integer.class);

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath imagem = createString("imagem");

    public final StringPath nomejogo = createString("nomejogo");

    public final ListPath<com.trocajogo.model.JogoPlataforma.JogoPlataforma, com.trocajogo.model.JogoPlataforma.QJogoPlataforma> plataforma = this.<com.trocajogo.model.JogoPlataforma.JogoPlataforma, com.trocajogo.model.JogoPlataforma.QJogoPlataforma>createList("plataforma", com.trocajogo.model.JogoPlataforma.JogoPlataforma.class, com.trocajogo.model.JogoPlataforma.QJogoPlataforma.class, PathInits.DIRECT2);

    public QJogo(String variable) {
        super(Jogo.class, forVariable(variable));
    }

    public QJogo(Path<? extends Jogo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJogo(PathMetadata metadata) {
        super(Jogo.class, metadata);
    }

}

