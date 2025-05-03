package com.apptory.cinemark.stepdefinitions;

import com.apptory.cinemark.exceptions.ErrorDeAutenticacion;
import com.apptory.cinemark.interactions.PermiteAcceder;
import com.apptory.cinemark.questions.MuestraUsuarioAutenticado;
import com.apptory.cinemark.tasks.Autenticarse;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import static com.apptory.cinemark.exceptions.ErrorDeAutenticacion.INICIO_DE_SESION_FALLIDO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutenticacionStepDefinitions {

    @Dado("que {actor} quiere hacer uso del portal privado")
    public void accedeAlApp(Actor actor) {
        actor.attemptsTo(PermiteAcceder.alPortalPublico());
    }

    @Cuando("ingresa correctamente sus credenciales")
    public void ingresaCorrectamenteSusCredenciales() {
        theActorInTheSpotlight().attemptsTo(Autenticarse.conCredencialesValidas());
    }

    @Entonces("debe mostrar al usuario autenticado")
    public void debeMostrarAlUsuarioAutenticado() {
        theActorInTheSpotlight().should(seeThat(MuestraUsuarioAutenticado.enPortalPrivado())
                .orComplainWith(ErrorDeAutenticacion.class, INICIO_DE_SESION_FALLIDO));
    }
}
