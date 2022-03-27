package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public static String loadProperty(String property) {
        try {

            InputStream inputStream = new FileInputStream("src/test/data.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            //System.out.println(properties.getProperty("date"));
            return properties.getProperty(property);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
