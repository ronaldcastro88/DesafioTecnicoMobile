package com.apptory.cinemark.utils;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Managed;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Comunes {
    @Managed(driver = "appium")
    public static final Logger LOGGER = LoggerFactory.getLogger(Comunes.class.getName());
    static final String MSG_ERROR = "Error: ";
    public static final AppiumDriver driver = ThucydidesWebDriverSupport.getProxiedDriver();

    private Comunes() {
    }

    public static void ejecutaScript(String script, Map<String, Object> params) {
        ((JavascriptExecutor) driver).executeScript(script, params);
    }

    /*public static void scroll(String command, AndroidDriver driver) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(SCROLL_ADELANTE.obtenerValor()));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(command)));

        } catch (Exception e) {
            LOGGER.error(MSG_ERROR, e);
        }
    }*/

    public static void ultimoElemento() {
        WebElement contenedor = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"));
        int iniciaX = contenedor.getLocation().getX();
        int iniciaY = contenedor.getLocation().getY();
        int ancho = contenedor.getSize().getWidth();
        int alto = contenedor.getSize().getHeight();
        int numeroHijos = 2;
        int pasoY = alto / numeroHijos;
        int clickY = iniciaY + (int)(pasoY * 1.75);
        LOGGER.info("EL CLICK EN EL EJE Y FUE {} ",clickY);
        int clickX = iniciaX + (ancho / 2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), clickX, clickY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(500)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        for (int i = 0; i < 3; i++) {
            try {
                driver.perform(Collections.singletonList(tap));
                LOGGER.info("Se hizo clic en el penúltimo elemento hijo por coordenadas.");
                break;
            } catch (Exception e) {
                LOGGER.warn("El click falló, reintentando...");
                esperaImplicita(3000L);
            }
        }
    }

    /*public static void buscaFecha(String mesActual, Actor actor, String dia, String mesNacimiento){
        int contador;
        if (mesActual.equals(mesNacimiento)) {
            actor.attemptsTo(Click.on(variableComunLabel(dia)), Click.on(ANO_CALENDARIO_LABEL));
            return;
        }
        switch (mesActual) {
            case "ene" -> contador = obtenerDiferenciaEntreMeses("ene", mesNacimiento);
            case "feb" -> contador = obtenerDiferenciaEntreMeses("feb", mesNacimiento);
            case "mar" -> contador = obtenerDiferenciaEntreMeses("mar", mesNacimiento);
            case "abr" -> contador = obtenerDiferenciaEntreMeses("abr", mesNacimiento);
            case "may" -> contador = obtenerDiferenciaEntreMeses("may", mesNacimiento);
            case "jun" -> contador = obtenerDiferenciaEntreMeses("jun", mesNacimiento);
            case "jul" -> contador = obtenerDiferenciaEntreMeses("jul", mesNacimiento);
            case "ago" -> contador = obtenerDiferenciaEntreMeses("ago", mesNacimiento);
            case "sep" -> contador = obtenerDiferenciaEntreMeses("sep", mesNacimiento);
            case "oct" -> contador = obtenerDiferenciaEntreMeses("oct", mesNacimiento);
            case "nov" -> contador = obtenerDiferenciaEntreMeses("nov", mesNacimiento);
            case "dic" -> contador = obtenerDiferenciaEntreMeses("dic", mesNacimiento);
            default -> throw new IllegalArgumentException("Mes no válido: " + mesActual);
        }
        for (int i = 1; i <=Math.abs(contador); i++) {
            actor.attemptsTo(Click.on(ATRAS_BOTON));
        }
        actor.attemptsTo(Click.on(variableComunLabel(dia)), Click.on(ANO_CALENDARIO_LABEL));
    }*/

    private static int obtenerDiferenciaEntreMeses(String mesActual, String mesDestino) {
        List<String> meses = List.of("ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic");
        int indiceMesActual = meses.indexOf(mesActual);
        int indiceMesDestino = meses.indexOf(mesDestino);
        return indiceMesDestino - indiceMesActual;
    }

    public static void esperaImplicita(Long segundos){
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error(MSG_ERROR, e);
        }
    }
}
