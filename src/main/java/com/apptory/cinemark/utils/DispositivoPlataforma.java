package com.apptory.cinemark.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DispositivoPlataforma {
    private static AppiumDriver driver;

    private DispositivoPlataforma() {
    }

    public static void enviarDriver(AppiumDriver driver) {
        DispositivoPlataforma.driver = driver;
    }

    public static String obtenerNombrePlataforma() {
        if (driver instanceof AndroidDriver) {
            return "android";
        } else if (driver instanceof IOSDriver) {
            return "ios";
        } else {
            return "unknown";
        }
    }
}
