package org.qamation.amazon;

import org.qamation.utils.ResourceUtils;

public class Config {

    public static Config getConfig(String path) {
        if (config == null) config = new Config(path);
        return config;
    }

    public static Config getConfig() {
        if (config == null) config = new Config();
        return config;
    }

    private static Config config=null;

    private String amazonUser;
    private String amazonUserPassword;
    private String rootPath;

    private Config(String rootPath) {
        this.rootPath = rootPath;
        ResourceUtils.loadProperties(this.rootPath);
        readProperties();
    }

    public Config () {
        this(System.getProperty("user.dir"));
    }

    private void readProperties() {
        amazonUser = System.getProperty("AMAZON.USER.NAME");
        amazonUserPassword = System.getProperty("AMAZON.USER.PASSWORD");
    }

    public String getAmazonUser() {
        return amazonUser;
    }

    public String getAmazonUserPassword() {
        return amazonUserPassword;
    }

    public String getRootPath() {
        return rootPath;
    }
}
