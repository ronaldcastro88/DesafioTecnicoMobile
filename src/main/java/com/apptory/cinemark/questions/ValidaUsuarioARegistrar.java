package com.apptory.cinemark.questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.apptory.cinemark.userinterfaces.RegistroPage.MENSAJE_VALIDACION_REGISTRO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ValidaUsuarioARegistrar implements Question<Boolean> {
    private final String mensaje;

    public ValidaUsuarioARegistrar(String mensaje) {
        this.mensaje = mensaje;
    }

    public static ValidaUsuarioARegistrar enPortalPrivado(String mensaje) {
        return new ValidaUsuarioARegistrar(mensaje);
    }

    @Override
    @Step("Valida que el usuario a registrar no exista en la app")
    public Boolean answeredBy(Actor actor){
        actor.attemptsTo(WaitUntil.the(MENSAJE_VALIDACION_REGISTRO, isPresent()).forNoMoreThan(5).seconds(),
                Ensure.that(MENSAJE_VALIDACION_REGISTRO).attribute("contentDescription").isEqualTo(mensaje));
        return true;
    }
}
