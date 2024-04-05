package utez.edu.mx.foodster.utils;

public class EventoEstados {

    public static final int EN_PROCESO = 1;
    public static final int FINALIZADO = 2;

    public static final int CANCELADO = 3;


    public static String getEstado(int estado) {
        switch (estado) {
            case EN_PROCESO:
                return "En proceso";
            case FINALIZADO:
                return "Finalizado";
            case CANCELADO:
                return "Cancelado";
            default:
                return "Desconocido";
        }
    }

    private EventoEstados() {
        throw new UnsupportedOperationException("Esta clase no se puede instanciar");
    }
}
