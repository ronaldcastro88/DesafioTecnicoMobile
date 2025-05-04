# language: es
Característica: Como usuario que frecuenta las salas de cine
  Deseo registrarme en la app móvil de Cinemark
  Para obtener descuentos y evitarme filas de manera presencial

  @IntentoRegistroUsuarioExistente @Regresion
  Escenario: Intento de registro de un usuario que ya existe en el sistema
    Dado que Ronald quiere hacer uso del portal privado
    Cuando realiza el proceso de registro
    Entonces debe mostrar el mensaje "Documento en uso por otro usuario"
