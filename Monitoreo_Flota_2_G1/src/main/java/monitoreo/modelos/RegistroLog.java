package monitoreo.modelos;

import java.text.DateFormat;

public class RegistroLog {

    public static RegistroLog registro;

    public static synchronized RegistroLog getInstance() {

        if (registro == null) {
            registro = new RegistroLog();
        }
        return registro;
    }

    public void log(String mensaje) {

        System.out.println(DateFormat.getDateInstance().format(System.currentTimeMillis()) + " - " + mensaje);
    }
}
