package com.AirplaneCoordinates.Core.List;

import java.util.ArrayList;

public final class CustomArrayList<T> extends ArrayList<T> {
    public final CustomArrayList<T> insert(final T item) {
        super.add(item);
        return this;
    }
}
