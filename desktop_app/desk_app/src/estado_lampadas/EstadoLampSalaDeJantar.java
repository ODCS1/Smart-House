package estado_lampadas;

public class EstadoLampSalaDeJantar {
    public static boolean checked = false;

    public static boolean isCheckedSalaDeJantar() {
        return checked;
    }

    public static void setCheckedSalaDeJantar(Boolean state) {
        checked = state;
    }
}
