package com.order.processing.system.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Version {
    private final static String APPLICATION_PROPERTIES = "application.properties";
    private final static String VERSION_PROPERTY = "version";
    private final static String APP_NAME_PROPERTY = "app.name";

    private final String version;
    private final String name;
    public Version(){
        Properties prop = new Properties();
        String version = "unknown";
        String name = "unknown";
        try (InputStream input = Version.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {
            if (input == null) {
                System.out.printf("Sorry, unable to find %d%n", APPLICATION_PROPERTIES);
            } else {
                // Load the properties file
                prop.load(input);

                name = prop.getProperty(APP_NAME_PROPERTY);
                version = prop.getProperty(VERSION_PROPERTY);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            this.name = name;
            this.version = version;
        }
    }

    public String getName() {
        return name;
    }
    public String getVersion() {
        return version;
    }
}
