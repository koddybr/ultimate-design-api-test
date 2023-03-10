package com.koddy.util;

import java.io.InputStream;
import java.util.Properties;

public class Enviroment {
    private static Enviroment enviroment = null;
    private String host;
    private String username;
    private String password;

    private Enviroment(){
        Properties properties = new Properties();
        String fileName = "ultimate.design.dev";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if(inputStream != null){
            try{
                properties.load(inputStream);
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        host = properties.getProperty("host");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }

    public static Enviroment getInstance(){
        if(enviroment == null) {
            enviroment = new Enviroment();
        }
        return enviroment;
    }

    public String getHost(){
        return host;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }
}
