package config;

public class AppConfig {
    private String target;
    private String applicationBaseUrl;
    private boolean onlyFailedTestScreenshot;

    public String getTarget(){
        return target;
    }

    public String getApplicationBaseUrl(){
        return applicationBaseUrl;
    }

    public Boolean getOnlyFailedTestScreenshot(){
        return onlyFailedTestScreenshot;
    }
}
