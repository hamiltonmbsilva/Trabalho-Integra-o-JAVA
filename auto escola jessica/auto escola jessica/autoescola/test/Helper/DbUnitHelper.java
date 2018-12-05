/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/**
 *
 * @author Yuri
 */
public class DbUnitHelper {

    private final Connection conexao; 
    private final DatabaseConnection conexaoDBUnit;
    private String xmlFolder;

    public DbUnitHelper() {
        this.xmlFolder = "test/DbUnitXml/";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfc?zeroDateTimeBehavior=convertToNull", "root", "!@#$1234");
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
        String file = xmlFolder + "BkpBanco.xml";
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
        String file = xmlFolder + "BkpBanco.xml";
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
        String[] tables = {"agenda"};
        IDataSet ids = conexaoDBUnit.createDataSet(tables);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids);
        
        String[] tables1 = {"contrato_has_tipo_aula"};
        IDataSet ids1 = conexaoDBUnit.createDataSet(tables1);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids1);
        
        String[] tables2 = {"aula"};
        IDataSet ids2 = conexaoDBUnit.createDataSet(tables2);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids2);
        
        String[] tables3 = {"recebimento"};
        IDataSet ids3 = conexaoDBUnit.createDataSet(tables3);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids3);
        
        String[] tables4 = {"tipo_aula"};
        IDataSet ids4 = conexaoDBUnit.createDataSet(tables4);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids4);
        
        String[] tables5 = {"veiculo"};
        IDataSet ids5= conexaoDBUnit.createDataSet(tables5);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids5);
        
        String[] tables6 = {"tipo_veiculo"};
        IDataSet ids6= conexaoDBUnit.createDataSet(tables6);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids6);
        
        String[] tables7 = {"contrato"};
        IDataSet ids7= conexaoDBUnit.createDataSet(tables7);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids7);
        
        String[] tables8 = {"matricula"};
        IDataSet ids8= conexaoDBUnit.createDataSet(tables8);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids8);
        
        String[] tables9 = {"pessoa"};
        IDataSet ids9= conexaoDBUnit.createDataSet(tables9);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids9);
        
        String[] tables10 = {"plano_pagamento"};
        IDataSet ids10 = conexaoDBUnit.createDataSet(tables10);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids10);
        
        String[] tables11 = {"tipo_pessoa"};
        IDataSet ids11= conexaoDBUnit.createDataSet(tables11);
        DatabaseOperation.DELETE.execute(conexaoDBUnit, ids11);
        
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
