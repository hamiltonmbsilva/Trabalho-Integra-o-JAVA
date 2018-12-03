package Helper;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

public class DbUnitHelper {
    
    private Connection conexao;
    private DatabaseConnection conexaoDBUnit;
    private String xmlFolder;
    
    public DbUnitHelper() {
        this.xmlFolder = "test/DbUnitXml/";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/auto_escola", "root", "root");
            conexaoDBUnit = new DatabaseConnection(conexao);
            DatabaseConfig config = conexaoDBUnit.getConfig();
            config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
        } catch (Exception e) {
            throw new RuntimeException("Erro inicializando DBUnit", e);
        }
    }
    
    public void importar(String file) {
        try {
            deleteDataBase();

            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            IDataSet dataSet = builder.build(new FileInputStream(xmlFolder + file));
            DatabaseOperation.INSERT.execute(conexaoDBUnit, dataSet);

        } catch (Exception e) {
            throw new RuntimeException("Erro Import DbUnit", e);
        }
    }
    
    public void backupDataBase() {
        String file = xmlFolder + "BancoTeste.xml";
        try {
//            IDataSet dataSet = conexaoDBUnit.createDataSet();
            new FileOutputStream(file, false).close();
            
            ITableFilter filter = new DatabaseSequenceFilter(conexaoDBUnit);
            IDataSet dataSet = new FilteredDataSet(filter, conexaoDBUnit.createDataSet());

            FlatXmlDataSet.write(dataSet, new FileOutputStream(file));
        } catch (Exception e) {
            throw new RuntimeException("Erro executando DbUnit", e);
        }
    }
    
    public void RestoreDataBase() {
        String file = xmlFolder + "BancoTeste.xml";
        try {
            deleteDataBase();

            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            IDataSet dataSet = builder.build(new FileInputStream(file));
            DatabaseOperation.INSERT.execute(conexaoDBUnit,dataSet);
        } catch (Exception e) {
            throw new RuntimeException("Erro executando DbUnit", e);
        }
    }
    
    private void deleteDataBase() throws SQLException, DatabaseUnitException, DataSetException {
        String[] tables = {"aluno"};
        IDataSet ids = conexaoDBUnit.createDataSet(tables);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids);
        String[] tables1 = {"login"};
        ids = conexaoDBUnit.createDataSet(tables1);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids);
    }
    
    public void close() {
        try {
            conexaoDBUnit.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
