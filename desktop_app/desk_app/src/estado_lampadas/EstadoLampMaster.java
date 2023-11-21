package estado_lampadas;

public class EstadoLampMaster {
    private static boolean checked = false;

    public static boolean isCheckedMaster() {
        return checked; 
    }

    public static void setCheckedMaster(Boolean state) {
        checked = state;
    }
}
