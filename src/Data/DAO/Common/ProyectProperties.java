package Data.DAO.Common;

import java.io.*;
import java.util.Properties;

public class ProyectProperties {

    private Properties config;
    private Properties sql;

    private FileInputStream configFI;
    private FileInputStream sqlFI;

    /**
     * Metodo que carga las propiedades las propiedades del proyecto desde archivos de configuracion.
     * Lee las propiedades de configuracion generales desde "config.properties" y las especificas de
     * SQL desde "sql.properties"
     * @throws RuntimeException Si ocurre algun error al cargar los ficheros de configuracion
     */
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

    /**
     * Metodo que cierra los archivos de configuracion
     * @throws RuntimeException Si ocurre algun error al intentar cerrar los archivos de configuracion
     */
    @Override
    protected void finalize(){
        try {
            configFI.close();
            sqlFI.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que obtiene la URL del servidor de la base de datos
     * @return La URL del servidor
     */
    public String getUrl(){
        return config.getProperty("servername");
    }

    /**
     * Metodo que obtiene el nombre de usuario de la base de datos
     * @return El nombre de usuario
     */
    public String getUsername(){
        return config.getProperty("name");
    }

    /**
     * Metodo que obtiene la contraseña asociada al usuario de la base de datos
     * @return La contraseña
     */
    public String getPassword(){
        return config.getProperty("password");
    }

    /**
     * Metodo que obtiene una sentencia SQL
     * @param name Nombre asociado a la sentencia SQL
     * @return La sentencia SQL correspondiente al nombre proporcionado
     * @throws RuntimeException Si no se encuentra la sentencia SQL para el nombre dado
     */
    public String getSentente(String name){
        String result =sql.getProperty(name);
        if(result == ""){
            throw new RuntimeException("No se encontro la sentencia SQl del archivo sql.properties");
        }
        return  result;
    }

}
