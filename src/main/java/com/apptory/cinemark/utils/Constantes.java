package com.apptory.cinemark.utils;

public enum Constantes {

    SCROLL_HACIA_DELANTE("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward()"),
    NOMBRE_USUARIO("Ronald test APP"),
    APELLIDO_USUARIO("Castro"),
    CELULAR("3012542282"),
    DIRECCION("Calle 11"),
    NUMERO_DOCUMENTO("1128416801");
    private final String valor;

    Constantes(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }
}
