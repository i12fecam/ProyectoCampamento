package Data.DAO.Common;

import java.io.*;
import java.util.Properties;

public class ProyectProperties {

    private Properties config;
    private Properties sql;
    public ProyectProperties(){

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();


        config = new Properties();
        sql = new Properties();

        try {
            config.load(new FileInputStream(rootPath + "config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            sql.load(new FileInputStream(rootPath + "sql.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getUrl(){
        return config.getProperty("url");
    }

    public String getUsername(){
        return config.getProperty("username");
    }

    public String getPassword(){
        return config.getProperty("password");
    }

    public String getSentente(String name){
        return  sql.getProperty(name);
    }

}
