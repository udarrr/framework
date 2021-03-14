package com.epam.aqa.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle commonResources = ResourceBundle.getBundle(System.getProperty("environment"));
    private static ResourceBundle manualDataResources = ResourceBundle.getBundle(System.getProperty("manualdata"));

    public static String getCommonData(String key){
        return commonResources.getString(key);
    }

    public static String getManualData(String key){
        return manualDataResources.getString(key);
    }
}