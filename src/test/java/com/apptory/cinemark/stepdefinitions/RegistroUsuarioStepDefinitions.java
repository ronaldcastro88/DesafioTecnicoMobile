package com.apptory.cinemark.stepdefinitions;

import com.apptory.cinemark.exceptions.ErrorDeRegistro;
import com.apptory.cinemark.questions.ValidaUsuarioARegistrar;
import com.apptory.cinemark.tasks.DiligenciaFormulario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static com.apptory.cinemark.exceptions.ErrorDeRegistro.VALIDACION_USUARIO_REGISTRADO_FALLIDA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroUsuarioStepDefinitions {

    @Cuando("realiza el proceso de registro")
    public void intentaRegistrarse() {
        theActorInTheSpotlight().attemptsTo(DiligenciaFormulario.deRegistro());
    }

    @Entonces("debe mostrar el mensaje {string}")
    public void muestraMensajeValidacion(String mensaje) {
        theActorInTheSpotlight().should(seeThat(ValidaUsuarioARegistrar.enPortalPrivado(mensaje))
                .orComplainWith(ErrorDeRegistro.class, VALIDACION_USUARIO_REGISTRADO_FALLIDA));
    }
}
