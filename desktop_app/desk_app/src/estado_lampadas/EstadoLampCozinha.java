package estado_lampadas;

public class EstadoLampCozinha {
    public static boolean checked = false;

    public static boolean isCheckedCozinha() {
        return checked;
    }

    public static void setCheckedCozinha(Boolean state) {
        checked = state;
    } 
}
