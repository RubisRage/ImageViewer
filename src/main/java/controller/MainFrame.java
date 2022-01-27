package controller;

import view.persistence.ImageLoader;
import view.ui.ImageDisplay;
import view.ui.SwingImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final ImageLoader imageLoader;

    public MainFrame(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;

        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().add(imageDisplay());
        getContentPane().add(toolBar(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());

        return panel;
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());

        return button;
    }

    private ActionListener nextImage() {
        return (e) -> {
            imageDisplay.show(imageDisplay.current().next());
        };
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());

        return button;
    }

    private ActionListener prevImage() {
        return (e) -> {
            imageDisplay.show(imageDisplay.current().prev());
        };
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        imageDisplay = sid;

        return sid;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
