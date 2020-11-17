package monitoreo.modelos;

import java.io.IOException;
import java.text.DateFormat;

public class RegistroLog {

    private static RegistroLog registro;
    private final String DEFAULT = DateFormat.getDateInstance().format(System.currentTimeMillis()) + " - ";


    public static synchronized RegistroLog getInstance() {
        if (registro == null) {
            registro = new RegistroLog();
        }
        return registro;
    }

    public void log(String mensaje) {
        log(Level.INFO, mensaje);
    }

    public void log(Level level, String msg) {
        try {
            FileLog.getInstance().write("[" + level.name() + "]" + DEFAULT + msg + "\n");
            System.out.print(level.getAnsiColor() + "[" + level.name() + "]" + DEFAULT + msg + "\n");
        } catch (IOException e) {
            System.out.print(Level.ERROR.getAnsiColor() + "[" + Level.ERROR + "]" + DEFAULT + " - " + msg + "\n");
        }
    }

    public enum Level {
        INFO("INFO", "\u001B[32m"),
        ERROR("ERROR", "\u001B[31m"),
        DEBUG("DEBUG", "\u001B[33m");

        private final String level;
        private final String ansiColor;

        Level(String level, String ansiColor) {
            this.level = level;
            this.ansiColor = ansiColor;
        }

        public String getLevel() {
            return level;
        }

        public String getAnsiColor() {
            return ansiColor;
        }
    }

}
