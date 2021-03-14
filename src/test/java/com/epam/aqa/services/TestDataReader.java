package com.epam.aqa.services;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle commonResources = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getCommonData(String key){
        return commonResources.getString(key);
    }
}