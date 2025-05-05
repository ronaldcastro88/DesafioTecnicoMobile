package com.apptory.cinemark.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {

    public static final Target BOTON_REGISTRARSE = Target.the("Botón registrarse que aparece en la ventana de autenticación").located(new AppiumBy.ByAccessibilityId("Registrarse"));
    public static final Target CAMPO_NOMBRE = Target.the("Campo para ingresar el nombre").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
    public static final Target CAMPO_PRIMER_APELLIDO = Target.the("Campo para ingresar el apellido paterno").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
    public static final Target CAMPO_CORREO_ELECTRONICO_REGISTRO = Target.the("Campo para ingresar el correo electrónico").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[3]"));
    public static final Target CAMPO_CONFIRMACION_CORREO_ELECTRONICO = Target.the("Campo para confirmar el correo electrónico").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[4]"));

    public static final Target CAMPO_CELULAR = Target.the("Campo para ingresar el celular").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[5]"));
    public static final Target CAMPO_DIRECCION = Target.the("Campo para ingresar la dirección").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[6]"));
    public static final Target CAMPO_NUMERO_DOCUMENTO = Target.the("Campo para ingresar el número de documento").located(By.xpath("//android.widget.ScrollView/android.widget.EditText[7]"));

    public static final Target CAMPO_GENERO = Target.the("Campo para seleccionar el género").located(new AppiumBy.ByAccessibilityId("Género (opcional)"));
    public static final Target GENERO_MASCULINO = Target.the("Campo para seleccionar el género masculino").located(new AppiumBy.ByAccessibilityId("Masculino"));
    public static final Target BOTON_ACEPTAR = Target.the("Campo para seleccionar el género masculino").located(new AppiumBy.ByAccessibilityId("ACEPTAR"));
    public static Target campoDinamico(String valor) {
        String xpath = String.format("//*[contains(@index, '%s')]", valor);
        return Target.the(String.format("Campo para ingresar %s", valor)).located(By.xpath(xpath));
    }
    public static final Target MENSAJE_VALIDACION_REGISTRO = Target.the("Mensaje que se muestra cuando el usuario ya existe en la app").located(new AppiumBy.ByAccessibilityId("Documento en uso por otro usuario"));
    public static final Target CAMPO_CONTINUAR = Target.the("Campo para ingresar la contraseña").located(new AppiumBy.ByAccessibilityId("CONTINUAR"));

    private RegistroPage() {
        throw new IllegalStateException("Clase de interfaz de usuario");
    }
}
