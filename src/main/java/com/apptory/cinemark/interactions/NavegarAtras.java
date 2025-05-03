package com.apptory.cinemark.interactions;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class NavegarAtras implements Interaction {

    public static NavegarAtras ahora() {
        return new NavegarAtras();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();
        if (webDriver instanceof AppiumDriver) {
            webDriver.navigate().back();
        } else {
            throw new IllegalStateException("El WebDriver no es una instancia de AppiumDriver");
        }
    }
}
