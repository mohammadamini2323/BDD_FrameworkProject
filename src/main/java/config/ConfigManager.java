package config;

import enums.Environments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
  static final Logger logger= LogManager.getLogger(ConfigManager.class);
   final static Properties properties=new Properties();
   static{ loadProperties();}


  private static void loadProperties()  {
       try {
           FileInputStream configPropertiesFIS=new FileInputStream("src/main/resources/config/config.properties");
           properties.load(configPropertiesFIS);
           configPropertiesFIS.close();
           Environments env = Environments.valueOf(properties.getProperty("env").toUpperCase());
           FileInputStream envFIS= new FileInputStream("src/main/resources/config/"+env.name().toLowerCase()+"-configuration.properties");
           properties.load(envFIS);
           logger.info("properties loaded for environment"+env);
           envFIS.close();


       }catch (IOException e) {
           logger.error(" was not able to load configuration properties " + e);
           throw new RuntimeException("failed to load configuration");
       }

   }
   public static String getProperty(String KEY){
       return properties.getProperty(KEY);

   }
    public static String getProperty(String KEY,String defaultValue){
        return properties.getProperty(KEY,defaultValue);

    }


}
