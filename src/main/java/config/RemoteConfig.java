package config;

public class RemoteConfig implements IConfiguration {

    private String browser;
    private String gridUrl;
    private String gridPort;

    @Override
    public String getBrowser() {
        return browser;
    }

    @Override
    public String getGridUrl() {
        return gridUrl;
    }

    @Override
    public String getGridPort() {
        return gridPort;
    }
}
