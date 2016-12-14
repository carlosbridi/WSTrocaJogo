package com.trocajogo.Jogo.JogoPlataforma;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJogoPlataforma is a Querydsl query type for JogoPlataforma
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJogoPlataforma extends EntityPathBase<JogoPlataforma> {

    private static final long serialVersionUID = 1663060684L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJogoPlataforma jogoPlataforma = new QJogoPlataforma("jogoPlataforma");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final com.trocajogo.Jogo.QJogo jogo;

    public final com.trocajogo.Plataforma.QPlataforma plataforma;

    public QJogoPlataforma(String variable) {
        this(JogoPlataforma.class, forVariable(variable), INITS);
    }

    public QJogoPlataforma(Path<? extends JogoPlataforma> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJogoPlataforma(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJogoPlataforma(PathMetadata metadata, PathInits inits) {
        this(JogoPlataforma.class, metadata, inits);
    }

    public QJogoPlataforma(Class<? extends JogoPlataforma> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jogo = inits.isInitialized("jogo") ? new com.trocajogo.Jogo.QJogo(forProperty("jogo")) : null;
        this.plataforma = inits.isInitialized("plataforma") ? new com.trocajogo.Plataforma.QPlataforma(forProperty("plataforma")) : null;
    }

}

