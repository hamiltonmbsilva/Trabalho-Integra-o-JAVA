package Models;

import Models.Login;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T12:37:57")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> cidade;
    public static volatile SingularAttribute<Pessoa, String> estado;
    public static volatile SingularAttribute<Pessoa, String> tipoPessoa;
    public static volatile SingularAttribute<Pessoa, Login> loginId;
    public static volatile SingularAttribute<Pessoa, String> numero;
    public static volatile SingularAttribute<Pessoa, String> logradouro;
    public static volatile SingularAttribute<Pessoa, String> bairro;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Integer> id;
    public static volatile SingularAttribute<Pessoa, Date> dataNascimento;

}