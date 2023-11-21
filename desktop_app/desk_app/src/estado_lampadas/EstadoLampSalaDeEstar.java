package estado_lampadas;

public class EstadoLampSalaDeEstar {
    public static boolean checked = false;

    public static boolean isCheckedSalaDeEstar() {
        return checked;
    }

    public static void setCheckedSalaDeEstar(Boolean state) {
        checked = state;
    }
}
