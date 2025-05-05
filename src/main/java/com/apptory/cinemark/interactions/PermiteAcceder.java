package com.apptory.cinemark.interactions;

import com.apptory.cinemark.utils.Comunes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.apptory.cinemark.userinterfaces.NavegacionPage.LOGO_PRINCIPAL;
import static com.apptory.cinemark.userinterfaces.NavegacionPage.BOTON_MENU_PRINCIPAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PermiteAcceder implements Interaction {

    public static PermiteAcceder alPortalPublico() {
        return instrumented(PermiteAcceder.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LOGO_PRINCIPAL, isNotVisible()).forNoMoreThan(30).seconds());
        AppiumDriver driver = Comunes.driver;
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.TAB));

        driver.navigate().back();
        actor.attemptsTo(WaitUntil.the(BOTON_MENU_PRINCIPAL, isVisible()).forNoMoreThan(10).seconds());
    }
}