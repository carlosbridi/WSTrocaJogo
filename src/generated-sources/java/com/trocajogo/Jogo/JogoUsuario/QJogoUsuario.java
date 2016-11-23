package com.trocajogo.Jogo.JogoUsuario;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJogoUsuario is a Querydsl query type for JogoUsuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJogoUsuario extends EntityPathBase<JogoUsuario> {

    private static final long serialVersionUID = -13621006L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJogoUsuario jogoUsuario = new QJogoUsuario("jogoUsuario");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> idUsuario = createNumber("idUsuario", Integer.class);

    public final BooleanPath interesse = createBoolean("interesse");

    public final com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma jogoPlataforma;

    public QJogoUsuario(String variable) {
        this(JogoUsuario.class, forVariable(variable), INITS);
    }

    public QJogoUsuario(Path<? extends JogoUsuario> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJogoUsuario(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJogoUsuario(PathMetadata metadata, PathInits inits) {
        this(JogoUsuario.class, metadata, inits);
    }

    public QJogoUsuario(Class<? extends JogoUsuario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jogoPlataforma = inits.isInitialized("jogoPlataforma") ? new com.trocajogo.Jogo.JogoPlataforma.QJogoPlataforma(forProperty("jogoPlataforma"), inits.get("jogoPlataforma")) : null;
    }

}

