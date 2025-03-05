package com.example.orangehrms;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties_Handling {

    Properties properties = new Properties();

   @Test
    public void handling_properties(){

       try {

           FileReader fileReader = new FileReader("./src/test/resources/config.properties");
           properties.load(fileReader);

           String url = properties.getProperty("url");
           String username = properties.getProperty("username");
           String password = properties.getProperty("password");
           String browser = properties.getProperty("browser");

           System.out.println(url + "\t" + "\t" + username +"\t"+ password +"\t"+ browser);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
