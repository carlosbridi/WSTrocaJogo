package com.trocajogo.Usuario;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsuario is a Querydsl query type for Usuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsuario extends EntityPathBase<Usuario> {

    private static final long serialVersionUID = -312392881L;

    public static final QUsuario usuario = new QUsuario("usuario");

    public final StringPath bairro = createString("bairro");

    public final StringPath cep = createString("cep");

    public final StringPath cidade = createString("cidade");

    public final StringPath complemento = createString("complemento");

    public final StringPath email = createString("email");

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath logradouro = createString("logradouro");

    public final StringPath nome = createString("nome");

    public final StringPath nomeUsuario = createString("nomeUsuario");

    public final StringPath numero = createString("numero");

    public final StringPath senha = createString("senha");

    public final StringPath telefone = createString("telefone");

    public QUsuario(String variable) {
        super(Usuario.class, forVariable(variable));
    }

    public QUsuario(Path<? extends Usuario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsuario(PathMetadata metadata) {
        super(Usuario.class, metadata);
    }

    public com.querydsl.core.types.Predicate equalsEmailCadastrado(Usuario usuario) {
        return Usuario.equalsEmailCadastrado(this, usuario);
    }

    public com.querydsl.core.types.Predicate equalsNomeUsuarioCadastrado(Usuario usuario) {
        return Usuario.equalsNomeUsuarioCadastrado(this, usuario);
    }

    public com.querydsl.core.types.Predicate loginUsuario(String emailUsuario, String senhaUsuario) {
        return Usuario.loginUsuario(this, emailUsuario, senhaUsuario);
    }

}

