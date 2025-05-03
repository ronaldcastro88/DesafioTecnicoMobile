package com.apptory.cinemark.questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.apptory.cinemark.userinterfaces.NavegacionPage.CAMPO_NOMBRE_USUARIO;
import static com.apptory.cinemark.userinterfaces.NavegacionPage.ICONO_AUTENTICADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class MuestraUsuarioAutenticado implements Question<Boolean> {

    public static MuestraUsuarioAutenticado enPortalPrivado() {
        return new MuestraUsuarioAutenticado();
    }

    @Override
    @Step("Sincronizar elementos validados en la autenticación")
    public Boolean answeredBy(Actor actor){
        actor.attemptsTo(Click.on(ICONO_AUTENTICADO),
                WaitUntil.the(CAMPO_NOMBRE_USUARIO, isPresent()).forNoMoreThan(3).seconds());
        return true;
    }
}
