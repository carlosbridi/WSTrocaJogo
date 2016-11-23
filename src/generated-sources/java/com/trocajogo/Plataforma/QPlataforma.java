package com.trocajogo.Plataforma;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlataforma is a Querydsl query type for Plataforma
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlataforma extends EntityPathBase<Plataforma> {

    private static final long serialVersionUID = 1843768367L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlataforma plataforma = new QPlataforma("plataforma");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.trocajogo.Jogo.QJogo jogo;

    public final com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma jogoPlataforma;

    public QPlataforma(String variable) {
        this(Plataforma.class, forVariable(variable), INITS);
    }

    public QPlataforma(Path<? extends Plataforma> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlataforma(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlataforma(PathMetadata metadata, PathInits inits) {
        this(Plataforma.class, metadata, inits);
    }

    public QPlataforma(Class<? extends Plataforma> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jogo = inits.isInitialized("jogo") ? new com.trocajogo.Jogo.QJogo(forProperty("jogo")) : null;
        this.jogoPlataforma = inits.isInitialized("jogoPlataforma") ? new com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma(forProperty("jogoPlataforma"), inits.get("jogoPlataforma")) : null;
    }

}

