package estado_lampadas;

public class EstadoLampMaster {
    private static boolean checked1 = false;
    private static boolean checked2 = false;

    public static boolean isCheckedMaster1() {
        return checked1; 
    }

    public static void setCheckedMaster1(Boolean state1) {
        checked1 = state1;
    }

    public static boolean isCheckedMaster2() {
        return checked2;
    }

    public static void setCheckedMaster2(Boolean state2) {
        checked2 = state2;
    }
}
