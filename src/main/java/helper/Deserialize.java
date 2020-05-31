package helper;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import config.pojo.AppConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class Deserialize {

    private static Gson gson;

    private Deserialize(){

    }

    private static Gson getGson(){
        if(gson == null){
            gson = new Gson();
        }
        return gson;
    }

    public static <T> T fromJson(String jsonFilePath, Type typeOfT){
        return getGson().fromJson(getConfigurationJson(jsonFilePath), typeOfT);
    }

    private static JsonReader getConfigurationJson(String filePath){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            return new JsonReader(bufferedReader);
        } catch (FileNotFoundException e) {
            throw new DriverException(e.getMessage());
        }
    }
}
