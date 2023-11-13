package estado_lampadas;

public class EstadoLampJardim {
    public static boolean checked1 = false;
    public static boolean checked2 = false;   
    public static boolean checked3 = false;   
    public static boolean checked4 = false;

    public static boolean isCheckedJardim1() {
        return checked1;
    }

    public static void setCheckedJardim1(Boolean state1) {
        checked1 = state1;
    }

    public static boolean isCheckedJardim2() {
        return checked2;
    }

    public static void setCheckedJardim2(Boolean state2) {
        checked2 = state2;
    }

    public static boolean isCheckedJardim3() {
        return checked3;
    }

    public static void setCheckedJardim3(Boolean state3) {
        checked3 = state3;
    }

    public static boolean isCheckedJardim4() {
        return checked4;
    }

    public static void setCheckedJardim4(Boolean state4) {
        checked4 = state4;
    }

}
