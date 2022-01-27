package controller;

import model.Image;
import view.persistence.FileImageLoader;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JOptionPane.showMessageDialog(null, "Please select a folder to load images from",
                "Welcome!", JOptionPane.INFORMATION_MESSAGE);

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            FileImageLoader imageLoader = new FileImageLoader(file);
            Image image = imageLoader.load();
            MainFrame mainFrame = new MainFrame(imageLoader);
            mainFrame.getImageDisplay().show(image);
        }
    }
}
