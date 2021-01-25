package session8.utilities;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase que implementa el patrón Singleton para establecer la conexion con BBDD
 * @author mbella
 */
public class ConnectDB {

    private static OracleConnection instance;

    private ConnectDB(){} 

     public static Connection getInstance() throws SQLException{
         if (instance==null){
             OracleDataSource ods = new OracleDataSource();
             ods.setURL(ORACLEDEMOConnection.DB_URL);
             ods.setUser(ORACLEDEMOConnection.DB_USER);
             ods.setPassword(ORACLEDEMOConnection.DB_PASSWORD);
             //Disable FAN which is not used, so we don't need to wait for timeout
             Properties prop = ods.getConnectionProperties();
             prop.put("oracle.jdbc.fanEnabled","false");
             ods.setConnectionProperties(prop);
             instance = (OracleConnection) ods.getConnection();
         }
     return instance;}
     
     public static void closeConnection() throws SQLException{
         if (instance!=null){
             instance.close();
             System.out.println("Database Closed");
         }
     }
}
