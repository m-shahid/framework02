package config.pojo;


import java.util.List;

public class Client {
    private String name;
    private String defaultSite;
    private String defaultCulture;
    private List<Program> programs;

    public String getName(){
        return name;
    }

    public String getDefaultSite(){
        return defaultSite;
    }

    public String getDefaultCulture(){
        return defaultCulture;
    }

    public List<Program> getPrograms(){
        return programs;
    }
}
