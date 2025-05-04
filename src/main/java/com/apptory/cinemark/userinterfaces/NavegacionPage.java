package com.apptory.cinemark.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class NavegacionPage {
    public static final Target BOTON_MENU_PRINCIPAL = Target.the("Botón del menú principal ubicado en el footer").located(new AppiumBy.ByAccessibilityId("Menu\n" +
            "Pestaña 5 de 5"));
    public static final Target LOGO_PRINCIPAL = Target.the("LOGO principal de la app que se muestra al cargar").located(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(4)"));
    public static final Target ICONO_PERFIL = Target.the("Icono que al seleccionado muestra la ventana de autenticación").located(new AppiumBy.ByAccessibilityId("Perfil"));
    public static final Target CAMPO_CORREO_ELECTRONICO = Target.the("Campo para ingresar el correo electrónico en el login").located(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
    public static final Target CAMPO_CONTRASENA = Target.the("Campo para ingresar la contraseña en el login").located(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
    public static final Target BOTON_INICIAR_SESION = Target.the("Botón para iniciar sesión en la app").located(new AppiumBy.ByAccessibilityId("INICIAR SESIÓN"));
    public static final Target ICONO_AUTENTICADO = Target.the("Icono que muestra las iniciales del usuario autenticado").located(new AppiumBy.ByAccessibilityId("RC"));
    public static final Target CAMPO_NOMBRE_USUARIO = Target.the("Campo que muestra el usuario autenticado").located(new AppiumBy.ByAccessibilityId("castroronald88@gmail.com"));

    private NavegacionPage() {
        throw new IllegalStateException("Clase de interfaz de usuario");
    }
}