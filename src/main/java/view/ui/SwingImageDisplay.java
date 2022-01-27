package view.ui;

import model.Image;
import view.persistence.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay{
    private Image currentImage;

    public BufferedImage imageOf(Image image){
        try {
            return ImageIO.read(image.stream());
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void paint(Graphics g){
        if(currentImage != null){
            g.drawImage(imageOf(currentImage), 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image image) {
        if(image != null){
            currentImage = image;
            repaint();
        }
    }
}
