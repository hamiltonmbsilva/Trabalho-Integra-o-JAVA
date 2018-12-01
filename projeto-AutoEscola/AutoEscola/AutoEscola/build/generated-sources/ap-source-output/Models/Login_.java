package Models;

import Models.Aluno;
import Models.Pessoa;
import Models.Professor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T15:30:20")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> senha;
    public static volatile ListAttribute<Login, Aluno> alunoList;
    public static volatile SingularAttribute<Login, Integer> id;
    public static volatile SingularAttribute<Login, String> login;
    public static volatile ListAttribute<Login, Professor> professorList;
    public static volatile ListAttribute<Login, Pessoa> pessoaList;

}