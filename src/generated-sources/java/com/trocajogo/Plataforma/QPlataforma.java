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

    public static final QPlataforma plataforma = new QPlataforma("plataforma");

    public final StringPath descricao = createString("descricao");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma, com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma> jogoPlataforma = this.<com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma, com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma>createList("jogoPlataforma", com.trocajogo.Jogo.JogoPlataforma.JogoPlataforma.class, com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma.class, PathInits.DIRECT2);

    public QPlataforma(String variable) {
        super(Plataforma.class, forVariable(variable));
    }

    public QPlataforma(Path<? extends Plataforma> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlataforma(PathMetadata metadata) {
        super(Plataforma.class, metadata);
    }

}

