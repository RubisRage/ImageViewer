package model;

import java.io.InputStream;

public interface Image {

    String name();
    InputStream stream();
    Image next();
    Image prev();
}
