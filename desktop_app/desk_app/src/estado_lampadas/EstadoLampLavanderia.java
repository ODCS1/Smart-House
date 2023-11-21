package estado_lampadas;

public class EstadoLampLavanderia {
    public static boolean checked = false;

    public static boolean isCheckedLavanderia() {
        return checked;
    }

    public static void setCheckedLavanderia(Boolean state) {
        checked = state;
    } 
}
