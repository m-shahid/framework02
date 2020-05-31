package config.pojo;

import config.IConfiguration;

public class LocalConfig implements IConfiguration {
    private String browser;

    @Override
    public String getBrowser(){
        return browser;
    }

    @Override
    public String getGridUrl() {
        return null;
    }

    @Override
    public String getGridPort() {
        return null;
    }
}
