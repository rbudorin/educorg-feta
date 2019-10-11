package org.studwork.utils;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static ResourceBundle resourceBundle;

    public static String t(String key) {
        if (resourceBundle == null) {
            Locale locale = new Locale(Environment.get("language"), Environment.get("country"));
            resourceBundle = ResourceBundle.getBundle("i18n.text", locale);
        }

        byte[] textBytes;
        String text = "";

        try {
            textBytes = resourceBundle.getString(key).getBytes("ISO-8859-1");
            text = new String(textBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return text;
    }
}