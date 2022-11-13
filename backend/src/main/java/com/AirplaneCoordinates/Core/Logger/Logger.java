package com.AirplaneCoordinates.Core.Logger;

public interface Logger {
    public void log(final String message);
    public void logWithDate(final String message);
    public void separator();
    public void subSeparator();
}
