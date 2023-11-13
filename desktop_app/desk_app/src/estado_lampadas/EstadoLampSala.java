package estado_lampadas;
public class EstadoLampSala {
    private static boolean checked = false;

    public static boolean isCheckedSala() {
        return checked;
    }

    public static void setCheckedSala(Boolean state) {
        checked = state;
    }
}
