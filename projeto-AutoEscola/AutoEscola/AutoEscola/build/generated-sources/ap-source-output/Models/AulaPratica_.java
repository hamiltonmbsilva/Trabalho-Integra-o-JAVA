package Models;

import Models.Aluno;
import Models.Professor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T12:37:57")
@StaticMetamodel(AulaPratica.class)
public class AulaPratica_ { 

    public static volatile SingularAttribute<AulaPratica, String> veiculo;
    public static volatile SingularAttribute<AulaPratica, String> tema;
    public static volatile SingularAttribute<AulaPratica, Aluno> alunoMatricula;
    public static volatile SingularAttribute<AulaPratica, Date> dataAula;
    public static volatile SingularAttribute<AulaPratica, Integer> id;
    public static volatile SingularAttribute<AulaPratica, Professor> professorId;

}