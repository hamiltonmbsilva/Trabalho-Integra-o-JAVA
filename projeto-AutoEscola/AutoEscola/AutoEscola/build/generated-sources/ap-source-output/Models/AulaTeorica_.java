package Models;

import Models.Aluno;
import Models.Professor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T12:37:57")
@StaticMetamodel(AulaTeorica.class)
public class AulaTeorica_ { 

    public static volatile ListAttribute<AulaTeorica, Aluno> alunoList;
    public static volatile SingularAttribute<AulaTeorica, String> tema;
    public static volatile SingularAttribute<AulaTeorica, Date> dataAula;
    public static volatile SingularAttribute<AulaTeorica, Integer> id;
    public static volatile SingularAttribute<AulaTeorica, Professor> professorId;

}