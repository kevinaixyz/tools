package com.prototype.nvmpublisher.reader;

import java.io.IOException;
import java.util.Properties;

public class NavConfig {
    private static Properties prop;
    private NavConfig(){
        prop = new Properties();
        try {
            prop.load(PortfolioFileReader.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static NavConfig getInstance(){
        return new NavConfig();
    }
    public static String get(String key){
        return prop.getProperty(key, null);
    }
}
