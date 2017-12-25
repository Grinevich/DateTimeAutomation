package utilities;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sveta on 22.12.17.
 */
public class PropertiesLoader {

    public static String getProjectProperty(String name) {
        return getProperty(name, "/Project.properties");
    }

    public static String getProperty(String name, final String filePath) {
        Properties p = new Properties();
        try {
            p.load(PropertiesLoader.class.getResourceAsStream("/Project.properties"));
        } catch( IOException e) {
            System.out.println(e.getMessage());
        }

        return p.getProperty(name);
    }
}
