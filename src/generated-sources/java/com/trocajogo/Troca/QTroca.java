package com.trocajogo.Troca;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTroca is a Querydsl query type for Troca
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTroca extends EntityPathBase<Troca> {

    private static final long serialVersionUID = 1159322705L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTroca troca = new QTroca("troca");

    public final DateTimePath<java.util.Date> dataTroca = createDateTime("dataTroca", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idUsuarioOferta = createNumber("idUsuarioOferta", Integer.class);

    public final NumberPath<Integer> idUsuarioTroca = createNumber("idUsuarioTroca", Integer.class);

    public final com.trocajogo.Troca.ItemTroca.QItemTroca itemTroca;

    public final EnumPath<StatusTroca> statusTroca = createEnum("statusTroca", StatusTroca.class);

    public QTroca(String variable) {
        this(Troca.class, forVariable(variable), INITS);
    }

    public QTroca(Path<? extends Troca> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTroca(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTroca(PathMetadata metadata, PathInits inits) {
        this(Troca.class, metadata, inits);
    }

    public QTroca(Class<? extends Troca> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.itemTroca = inits.isInitialized("itemTroca") ? new com.trocajogo.Troca.ItemTroca.QItemTroca(forProperty("itemTroca"), inits.get("itemTroca")) : null;
    }

}

