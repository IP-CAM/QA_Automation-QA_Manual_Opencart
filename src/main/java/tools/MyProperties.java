package tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class MyProperties {

    //private static final String PROPERTIES_PATH = "src/test.properties";
    private static final  String PROPERTIES_PATH= "src/main/java/tools/data.properties";
    private static String BROWSER_NAME;


    public static String getBrowserName() {
        return BROWSER_NAME;
    }

    public MyProperties()  {
        Properties prop = new Properties();
        try{
        prop.load(new FileInputStream(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.BROWSER_NAME = prop.getProperty("browserName");
        }

}

