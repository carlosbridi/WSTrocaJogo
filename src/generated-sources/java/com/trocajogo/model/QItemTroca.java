package com.trocajogo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemTroca is a Querydsl query type for ItemTroca
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemTroca extends EntityPathBase<ItemTroca> {

    private static final long serialVersionUID = -133363464L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemTroca itemTroca = new QItemTroca("itemTroca");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idUsuarioOferta = createNumber("idUsuarioOferta", Integer.class);

    public final NumberPath<Integer> idUsuarioTroca = createNumber("idUsuarioTroca", Integer.class);

    public final com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma jogoPlataformaOferta;

    public final com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma jogoPlataformaTroca;

    public final QTroca troca;

    public QItemTroca(String variable) {
        this(ItemTroca.class, forVariable(variable), INITS);
    }

    public QItemTroca(Path<? extends ItemTroca> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemTroca(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemTroca(PathMetadata metadata, PathInits inits) {
        this(ItemTroca.class, metadata, inits);
    }

    public QItemTroca(Class<? extends ItemTroca> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jogoPlataformaOferta = inits.isInitialized("jogoPlataformaOferta") ? new com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma(forProperty("jogoPlataformaOferta"), inits.get("jogoPlataformaOferta")) : null;
        this.jogoPlataformaTroca = inits.isInitialized("jogoPlataformaTroca") ? new com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma(forProperty("jogoPlataformaTroca"), inits.get("jogoPlataformaTroca")) : null;
        this.troca = inits.isInitialized("troca") ? new QTroca(forProperty("troca"), inits.get("troca")) : null;
    }

}

