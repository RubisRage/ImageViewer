package controller;

import model.Image;
import view.persistence.FileImageLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("/home/rubisrage/Mis Cosas/Imagenes/Wallpaper/");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame(imageLoader);
        mainFrame.getImageDisplay().show(image);
    }
}
