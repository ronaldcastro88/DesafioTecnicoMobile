# language: es
Característica: Como usuario de la app de Cinemark deseo autenticarme para usar el portal privado

  @AutenticacionExitosaCine
  Escenario: Autenticación exitosa
    Dado que Ronald quiere hacer uso del portal privado
    Cuando ingresa correctamente sus credenciales
    Entonces debe mostrar al usuario autenticado
