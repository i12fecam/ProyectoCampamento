package Data.DAO.Common;

import java.io.*;
import java.util.Properties;

public class ProyectProperties {

    private Properties config;
    private Properties sql;

    private FileInputStream configFI;
    private FileInputStream sqlFI;
    public ProyectProperties(){

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();


        config = new Properties();
        sql = new Properties();

        try {
            configFI = new FileInputStream(rootPath + "config.properties");
            config.load(configFI);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            sqlFI = new FileInputStream(rootPath + "sql.properties");
            sql.load(sqlFI);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void finalize(){
        try {
            configFI.close();
            sqlFI.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getUrl(){
        return config.getProperty("servername");
    }

    public String getUsername(){
        return config.getProperty("name");
    }

    public String getPassword(){
        return config.getProperty("password");
    }

    public String getSentente(String name){
        String result =sql.getProperty(name);
        if(result == ""){
            throw new RuntimeException("No se encontro la sentencia SQl del archivo sql.properties");
        }
        return  result;
    }

}
