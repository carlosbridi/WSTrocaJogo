package com.trocajogo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJogoUsuario is a Querydsl query type for JogoUsuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJogoUsuario extends EntityPathBase<JogoUsuario> {

    private static final long serialVersionUID = 664691965L;

    public static final QJogoUsuario jogoUsuario = new QJogoUsuario("jogoUsuario");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idJogo = createNumber("idJogo", Integer.class);

    public final NumberPath<Integer> idPlataforma = createNumber("idPlataforma", Integer.class);

    public final NumberPath<Integer> idUsuario = createNumber("idUsuario", Integer.class);

    public final BooleanPath interesse = createBoolean("interesse");

    public QJogoUsuario(String variable) {
        super(JogoUsuario.class, forVariable(variable));
    }

    public QJogoUsuario(Path<? extends JogoUsuario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJogoUsuario(PathMetadata metadata) {
        super(JogoUsuario.class, metadata);
    }

}

