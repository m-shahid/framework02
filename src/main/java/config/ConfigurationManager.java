package config;

import com.google.gson.reflect.TypeToken;
import config.pojo.*;
import helper.Deserialize;
import helper.DriverException;
import logger.Logger;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class ConfigurationManager {

    private static AppConfig appConfig;
    private static IConfiguration configuration;
    private static List<Client> clientList;

    private ConfigurationManager(){

    }

    public static AppConfig getAppConfig(){
        if(appConfig == null){
            Logger.debug("Deserializing app configuration.");
            String appConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\appConfig.json";
            appConfig = Deserialize.fromJson(appConfigJsonPath, AppConfig.class);
        }
        return appConfig;
    }

    public static List<Client> getClientList(){
        if(clientList == null){
            Logger.debug("Getting client configuration.");
            String clientConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\clientConfig.json";
            Type clientListType = new TypeToken<LinkedList<Client>>(){}.getType();
            clientList = Deserialize.fromJson(clientConfigJsonPath, clientListType);
        }
        return clientList;
    }

    public static Client getClient(){
        String programId = getAppConfig().getProgramId();
        List<Client> clients = getClientList();
        for(Client client : clients){
            for(Program program : client.getPrograms()){
                if(program.getId().equalsIgnoreCase(programId)){
                    return client;
                }
            }
        }
        throw new DriverException("Client configuration not found");
    }

    public static Program getProgram(){
        String programId = getAppConfig().getProgramId();
        List<Client> clients = getClientList();
        for(Client client : clients){
            for(Program program : client.getPrograms()){
                if(program.getId().equalsIgnoreCase(programId)){
                    return program;
                }
            }
        }
        throw new DriverException("Program configuration not found");
    }

    public static IConfiguration getConfiguration(){

        if(configuration != null)
            return configuration;

        String target = getAppConfig().getTarget();

        switch (target){
            case "local" :
                Logger.debug("Deserializing local configuration.");
                String localConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\local.json";
                configuration = Deserialize.fromJson(localConfigJsonPath, LocalConfig.class);
                break;

            case "remote":
                Logger.debug("Deserializing remote configuration.");
                String remoteConfigJsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\remote.json";
                configuration = Deserialize.fromJson(remoteConfigJsonPath, RemoteConfig.class);
                break;
        }

        return configuration;

    }
}
