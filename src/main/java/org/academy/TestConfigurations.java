package org.academy;

import java.util.Base64;

public class TestConfigurations {

    private static String read(String value) {
        return PropertyReader.get().readValue(value);
    }

    public static String getUrl() {
        return read("main_url");
    }

    public static String getApiUrl() {
        return read("api_url");
    }

    public static String getBrowser() {
        return read("browser");
    }

    public static String getNameText() {
        return read("nameText");
    }

    public static String getPhone() {
        return read("phone");
    }

    public static String getPassword() {
        return new String(Base64.getDecoder().decode(read("pass")));
    }

    public static String getLogin() {
        return new String(Base64.getDecoder().decode(read("login")));
    }

    public static String getCourierPassword() {
        return new String(Base64.getDecoder().decode(read("courierPass")));
    }

    public static String getCourierLogin() {
        return new String(Base64.getDecoder().decode(read("courierLogin")));
    }

    public static String getPageUrl(String name) {
        return read("main_url") + read(name);
    }

}
