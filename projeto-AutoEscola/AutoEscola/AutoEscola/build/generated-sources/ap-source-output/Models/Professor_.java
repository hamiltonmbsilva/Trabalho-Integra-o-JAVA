package Models;

import Models.AulaPratica;
import Models.AulaTeorica;
import Models.Login;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T15:30:20")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, Login> loginId;
    public static volatile ListAttribute<Professor, AulaPratica> aulaPraticaList;
    public static volatile SingularAttribute<Professor, String> nome;
    public static volatile SingularAttribute<Professor, Integer> id;
    public static volatile SingularAttribute<Professor, String> email;
    public static volatile ListAttribute<Professor, AulaTeorica> aulaTeoricaList;

}