package view.ui;

import model.Image;

public interface ImageDisplay {
    Image current();
    void show(Image image);
}
