package com.apptory.cinemark.stepdefinitions;

import com.apptory.cinemark.utils.DispositivoPlataforma;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.ParameterType;


import java.util.logging.Level;
import java.util.logging.Logger;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Hooks {

    @Managed(driver = "appium")
    public static AppiumDriver driver;
    EnvironmentVariables environmentVariables = WebDriverConfiguredEnvironment.getEnvironmentVariables();
    String bundleId = EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("environments.local.appium.appPackage");

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before(order = 1)
    public synchronized void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 2)
    public synchronized void abrirApp() {
        driver = getProxiedDriver();
        DispositivoPlataforma.enviarDriver(driver);
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(BrowseTheWeb.with(driver)));
        initializeDriver();
    }

    @After
    public void apagarDriver() {
        try {
            if (driver != null) {
                if (driver instanceof AndroidDriver) {
                    ((AndroidDriver) driver).terminateApp(bundleId);
                } else if (driver instanceof IOSDriver) {
                    ((IOSDriver) driver).terminateApp(bundleId);
                }
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "No se pudo cerrar el controlador. No se encontró AppiumDriver.", ex);
        }
    }

    public void initializeDriver() {
        try {
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).activateApp(bundleId);
            } else if (driver instanceof IOSDriver) {
                ((IOSDriver) driver).activateApp(bundleId);
            }
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.WARNING, () -> "Falló al inicializar el driver: " + e.getMessage());
        }
    }


    public static class DriverInitializationException extends Exception {
        public DriverInitializationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}