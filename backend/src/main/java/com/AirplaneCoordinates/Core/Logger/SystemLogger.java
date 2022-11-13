package com.AirplaneCoordinates.Core.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class SystemLogger implements Logger {
    public final void log(final String message) {
        System.out.println(message);
    }

    public final void logWithDate(final String message) {
        final var now = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        System.out.println(now + " - " + message);
    }

    public final void separator() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public final void subSeparator() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - -");
    }
}
