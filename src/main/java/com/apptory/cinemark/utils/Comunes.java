package com.apptory.cinemark.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Managed;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Comunes {
    @Managed(driver = "appium")
    public static final Logger LOGGER = LoggerFactory.getLogger(Comunes.class.getName());
    static final String MSG_ERROR = "Error: ";
    public static final AppiumDriver driver = ThucydidesWebDriverSupport.getProxiedDriver();

    private Comunes() {
    }

    public static void scroll(String command) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(command));
        } catch (Exception e) {
            LOGGER.error(MSG_ERROR, e);
        }
    }
}
