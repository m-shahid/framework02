package config.pojo;

public class AppConfig {
    private String target;
    private String applicationBaseUrl;
    private boolean onlyFailedTestScreenshot;
    private String uiEnvironment;
    private String nextgenEnvironment;
    private String programId;

    public String getTarget(){
        return target;
    }

    public String getApplicationBaseUrl(){
        return applicationBaseUrl;
    }

    public Boolean getOnlyFailedTestScreenshot(){
        return onlyFailedTestScreenshot;
    }

    public String getUiEnvironment(){
        return uiEnvironment;
    }

    public String getNextgenEnvironment(){
        return nextgenEnvironment;
    }

    public String getProgramId(){
        return programId;
    }
}
