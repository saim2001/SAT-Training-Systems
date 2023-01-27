package Utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {
    public static String getConfigValue(String configKey) {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("Config.properties");

        } catch (Exception e) {
            e.getMessage();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        }
        catch (Exception e){
            e.getMessage();
        }
         return prop.getProperty(configKey);

    }
}
