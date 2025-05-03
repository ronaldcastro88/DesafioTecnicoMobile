package com.apptory.cinemark.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.apptory.cinemark.userinterfaces.NavegacionPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Autenticarse implements Task {

    public static Autenticarse conCredencialesValidas() {
        return instrumented(Autenticarse.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BOTON_MENU_PRINCIPAL), Click.on(ICONO_PERFIL),
                WaitUntil.the(BOTON_INICIAR_SESION, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CAMPO_CORREO_ELECTRONICO, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(CAMPO_CORREO_ELECTRONICO),
                Enter.theValue(System.getenv("CORREO_CINEMARK")).into(CAMPO_CORREO_ELECTRONICO),
                Click.on(CAMPO_CONTRASENA),
                Enter.theValue(System.getenv("CONTRASENA_CINEMARK")).into(CAMPO_CONTRASENA),
                Click.on(BOTON_INICIAR_SESION));
    }
}
