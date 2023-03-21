package config;


@org.aeonbits.owner.Config.Sources({"classpath:${env}.properties"})

public interface Config extends org.aeonbits.owner.Config {

    @Key("browser")
    String getBrowser();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remote")
    String getRemote();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("appUrl")
    String getAppUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuildName();

    @Key("name")
    String getTestName();

    @Key("baseApiUrl")
    String getBaseApiUrl();

    @Key("baseApiPath")
    String getBaseApiPath();

    @Key("emailApi")
    String getEmailApi();

    @Key("passwordApi")
    String getPasswordApi();
}
