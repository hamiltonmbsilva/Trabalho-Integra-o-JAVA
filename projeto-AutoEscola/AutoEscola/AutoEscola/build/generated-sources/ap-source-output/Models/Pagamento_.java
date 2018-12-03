package Models;

import Models.Aluno;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-03T08:49:49")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ { 

    public static volatile SingularAttribute<Pagamento, String> situacao;
    public static volatile SingularAttribute<Pagamento, Date> dataPagamento;
    public static volatile SingularAttribute<Pagamento, Aluno> alunoMatricula;
    public static volatile SingularAttribute<Pagamento, Double> valor;
    public static volatile SingularAttribute<Pagamento, Double> valorParcelas;
    public static volatile SingularAttribute<Pagamento, Boolean> avista;
    public static volatile SingularAttribute<Pagamento, Integer> id;
    public static volatile SingularAttribute<Pagamento, Integer> qtdAulaTeorica;
    public static volatile SingularAttribute<Pagamento, Integer> qtdAulaPratica;
    public static volatile SingularAttribute<Pagamento, Integer> numParcelas;

}