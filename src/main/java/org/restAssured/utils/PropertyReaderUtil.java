package org.restAssured.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderUtil {
    static FileInputStream fileInputStream;
    static Properties properties;
    public PropertyReaderUtil(){

    }
    public static String readKey(String key){
        try {
            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/org/restAssured/resources/TestData.properties"));
            properties = new Properties();
            properties.load(fileInputStream);
            if(properties.getProperty(key)!=null){
                return properties.getProperty(key);
            }
            else{
                throw new Exception("Key is not available");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
