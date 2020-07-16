package com.student.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    //here volatile used due to avoid multithreading issues
    private static volatile PropertyReader propInstance;

    private PropertyReader(){

    }

    // here synchronized due to avoid multithreading issues
    public static synchronized PropertyReader getInstance(){
        if(propInstance==null) {
            propInstance = new PropertyReader();
            return propInstance;
        }
        return propInstance;
    }

    /**
     * Read property value from property file
     * @param PropertyName
     * @return
     */

    public String getProperty(String PropertyName){
        Properties prop=new Properties();
        try {
            InputStream inputStream=getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(inputStream);
            if(prop.getProperty(PropertyName)!=null){
                return prop.getProperty(PropertyName);
            }

        }catch (Exception e){
            System.out.println("Property not found");
        }
        return null;

    }
}
