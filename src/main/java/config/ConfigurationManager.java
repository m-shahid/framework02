package config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import helper.ElementException;
import logger.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConfigurationManager {

    private static AppConfig appConfig;
    private static IConfiguration configuration;

    private ConfigurationManager(){

    }

    private static JsonReader getConfigurationJson(String filePath){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            return new JsonReader(bufferedReader);
        } catch (FileNotFoundException e) {
            throw new ElementException(e.getMessage());
        }
    }

    public static AppConfig getAppConfig(){
        if(appConfig == null){
            Logger.debug("Deserializing app configuration.");
            String appConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\appConfig.json";
            appConfig = new Gson().fromJson(getConfigurationJson(appConfigJsonPath), AppConfig.class);
        }
        return appConfig;
    }

    public static IConfiguration getConfiguration(){

        if(configuration != null)
            return configuration;

        String target = getAppConfig().getTarget();

        switch (target){
            case "local" :
                Logger.debug("Deserializing local configuration.");
                String localConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\local.json";
                configuration = new Gson().fromJson(getConfigurationJson(localConfigJsonPath), LocalConfig.class);
                break;

            case "remote":
                Logger.debug("Deserializing remote configuration.");
                String remoteConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\remote.json";
                configuration = new Gson().fromJson(getConfigurationJson(remoteConfigJsonPath), RemoteConfig.class);
                break;
        }

        return configuration;

    }
}
