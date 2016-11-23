package com.trocajogo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItensJogoTroca is a Querydsl query type for ItensJogoTroca
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItensJogoTroca extends EntityPathBase<ItensJogoTroca> {

    private static final long serialVersionUID = 1165220551L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItensJogoTroca itensJogoTroca = new QItensJogoTroca("itensJogoTroca");

    public final NumberPath<Integer> iditemtroca = createNumber("iditemtroca", Integer.class);

    public final NumberPath<Integer> idUsuarioOferta = createNumber("idUsuarioOferta", Integer.class);

    public final NumberPath<Integer> idUsuarioTroca = createNumber("idUsuarioTroca", Integer.class);

    public final com.trocajogo.Jogo.QJogo jogoOferta;

    public final com.trocajogo.Jogo.QJogo jogoTroca;

    public final StringPath nomeUsuarioOferta = createString("nomeUsuarioOferta");

    public final StringPath nomeUsuarioTroca = createString("nomeUsuarioTroca");

    public final com.trocajogo.Plataforma.QPlataforma plataformaOferta;

    public final com.trocajogo.Plataforma.QPlataforma plataformaTroca;

    public final QTroca troca;

    public QItensJogoTroca(String variable) {
        this(ItensJogoTroca.class, forVariable(variable), INITS);
    }

    public QItensJogoTroca(Path<? extends ItensJogoTroca> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItensJogoTroca(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItensJogoTroca(PathMetadata metadata, PathInits inits) {
        this(ItensJogoTroca.class, metadata, inits);
    }

    public QItensJogoTroca(Class<? extends ItensJogoTroca> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jogoOferta = inits.isInitialized("jogoOferta") ? new com.trocajogo.Jogo.QJogo(forProperty("jogoOferta")) : null;
        this.jogoTroca = inits.isInitialized("jogoTroca") ? new com.trocajogo.Jogo.QJogo(forProperty("jogoTroca")) : null;
        this.plataformaOferta = inits.isInitialized("plataformaOferta") ? new com.trocajogo.Plataforma.QPlataforma(forProperty("plataformaOferta"), inits.get("plataformaOferta")) : null;
        this.plataformaTroca = inits.isInitialized("plataformaTroca") ? new com.trocajogo.Plataforma.QPlataforma(forProperty("plataformaTroca"), inits.get("plataformaTroca")) : null;
        this.troca = inits.isInitialized("troca") ? new QTroca(forProperty("troca"), inits.get("troca")) : null;
    }

}

