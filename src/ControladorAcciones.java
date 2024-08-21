import models.Enemigo;
import ui.Interfaz;

public class ControladorAcciones {
    private Juego juego;
    private Interfaz interfaz;

    public ControladorAcciones(Juego juego, Interfaz interfaz) {
        this.juego = juego;
        this.interfaz = interfaz;
    }

    public void procesarAccion(String opcion) {
        switch (opcion) {
            case "e":
                juego.explorarUbicacion();
                break;
            case "l":
                Enemigo enemigo = juego.getGestorCombate().getEnemigoEnUbicacionActual();
                if (enemigo != null) {
                    juego.luchar(enemigo);
                }
                break;
            case "v": {
                String resultadoMapa = juego.verMapa();
                interfaz.mostrarMensaje(resultadoMapa);
                break;
            }
            case "m": {
                String resultadoMovimiento = juego.moverJugador();
                interfaz.mostrarMensaje(resultadoMovimiento);
                break;
            }
            case "i": {
                interfaz.mostrarInventario();
                break;
            }
            case "r": {
                if (juego.recogerItem()) {
                    interfaz.mostrarMensaje("Item recogido con éxito.");
                } else {
                    interfaz.mostrarMensaje("No se pudo recoger el item.");
                }
                break;
            }
            case "d": {
                if (juego.dejarItem()) {
                    interfaz.mostrarMensaje("Item dejado con éxito.");
                } else {
                    interfaz.mostrarMensaje("No se pudo dejar el item.");
                }
                break;
            }
            case "u": {
                String resultadoUso = juego.usarItem();
                interfaz.mostrarMensaje(resultadoUso);
                break;
            }
            case "s": {
                String mensajeDespedida = "Gracias por jugar!";
                interfaz.mostrarMensaje(mensajeDespedida);
                System.exit(0);
                break;
            }
            default: {
                String mensajeError = "Opción no válida";
                interfaz.mostrarMensaje(mensajeError);
            }
        }
    }
}