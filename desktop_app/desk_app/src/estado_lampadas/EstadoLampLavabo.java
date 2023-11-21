package estado_lampadas;

public class EstadoLampLavabo {
    public static boolean checked = false;

    public static boolean isCheckedLavabo() {
        return checked;
    }

    public static void setCheckedLavabo(Boolean state) {
        checked = state;
    } 
}
