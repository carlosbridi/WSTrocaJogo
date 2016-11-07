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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJogo jogo = new QJogo("jogo");

    public final NumberPath<Integer> ano = createNumber("ano", Integer.class);

    public final NumberPath<Integer> categoria = createNumber("categoria", Integer.class);

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath imagem = createString("imagem");

    public final StringPath nomejogo = createString("nomejogo");

    public final com.trocajogo.model.Plataforma.QPlataforma plataforma;

    public QJogo(String variable) {
        this(Jogo.class, forVariable(variable), INITS);
    }

    public QJogo(Path<? extends Jogo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJogo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJogo(PathMetadata metadata, PathInits inits) {
        this(Jogo.class, metadata, inits);
    }

    public QJogo(Class<? extends Jogo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.plataforma = inits.isInitialized("plataforma") ? new com.trocajogo.model.Plataforma.QPlataforma(forProperty("plataforma"), inits.get("plataforma")) : null;
    }

}

