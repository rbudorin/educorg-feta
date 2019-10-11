package org.studwork.utils;

import java.io.*;
import java.util.Properties;

public class Environment {

    private static Properties properties;

    public static String get(String key) {
        if (properties == null) {
            loadProperties();
        }

        String propertyValue = null;

        try {
            propertyValue = new String(properties.getProperty(key).getBytes("ISO8859-1"));
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
        }

        return propertyValue;
    }

    private static void loadProperties() {
        properties = new Properties();

        try {
            String remoteEnvironment = String.format("env/%s.properties", System.getProperty("test.environment"));
            ClassLoader classLoader =  Environment.class.getClassLoader();
            InputStream resourceStream = classLoader.getResourceAsStream(remoteEnvironment);
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}