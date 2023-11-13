package estado_lampadas;

public class EstadoLampBanheiro {
    public static boolean checked = false;

    public static boolean isCheckedBanheiro() {
        return checked;
    }

    public static void setCheckedBanheiro(Boolean state) {
        checked = state;
    } 
}
