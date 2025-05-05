package com.apptory.cinemark.tasks;

import com.apptory.cinemark.utils.Comunes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.apptory.cinemark.userinterfaces.NavegacionPage.*;
import static com.apptory.cinemark.userinterfaces.RegistroPage.*;
import static com.apptory.cinemark.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciaFormulario implements Task {

    public static DiligenciaFormulario deRegistro() {
        return instrumented (DiligenciaFormulario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String correo = System.getenv("CORREO_CINEMARK");
        actor.attemptsTo(Click.on(BOTON_MENU_PRINCIPAL), Click.on(ICONO_PERFIL),
                WaitUntil.the(BOTON_INICIAR_SESION, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(BOTON_REGISTRARSE),
                Click.on(CAMPO_NOMBRE), Type.theValue(NOMBRE_USUARIO.obtenerValor()).into(CAMPO_NOMBRE),
                Click.on(CAMPO_PRIMER_APELLIDO),Type.theValue(APELLIDO_USUARIO.obtenerValor()).into(CAMPO_PRIMER_APELLIDO),
                Click.on(CAMPO_CORREO_ELECTRONICO_REGISTRO),
                Type.theValue(correo).into(CAMPO_CORREO_ELECTRONICO_REGISTRO),
                Click.on(CAMPO_CONFIRMACION_CORREO_ELECTRONICO),Type.theValue(correo).into(CAMPO_CONFIRMACION_CORREO_ELECTRONICO),
                Click.on(CAMPO_CELULAR),Type.theValue(CELULAR.obtenerValor()).into(CAMPO_CELULAR),
                Click.on(CAMPO_DIRECCION),Type.theValue(DIRECCION.obtenerValor()).into(CAMPO_DIRECCION),
                Click.on(CAMPO_GENERO), Click.on(GENERO_MASCULINO), Click.on(campoDinamico("10")),
                Click.on(BOTON_ACEPTAR), Click.on(CAMPO_NUMERO_DOCUMENTO),
                Type.theValue(NUMERO_DOCUMENTO.obtenerValor()).into(CAMPO_NUMERO_DOCUMENTO));
        Comunes.scroll(SCROLL_HACIA_DELANTE.obtenerValor());
        actor.attemptsTo(Click.on(campoDinamico("10")),
                Type.theValue("Test2025+").into(campoDinamico("10")),
                Click.on(campoDinamico("11")), Click.on(CAMPO_CONTINUAR));
    }
}
