package com.tomslabs.exercises.chapter9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Exercise6 {
    public static void main(String[] args) throws IOException {
        URL image = Exercise6.class.getResource("/img/sample.bmp");
        BufferedImage bufferedImage = ImageIO.read(image);
        BufferedImage oriImage = ImageIO.read(image);

        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                Color oriColor = new Color(bufferedImage.getRGB(x, y));
                bufferedImage.setRGB(x, y, new Color(255 - oriColor.getRed(), 255 - oriColor.getGreen(), 255 - oriColor.getBlue()).getRGB());
            }
        }

        JFrame frame = new JFrame("Inversed image");
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(oriImage, 0, 0, oriImage.getWidth(), oriImage.getHeight(), null);
                g.drawImage(bufferedImage, 0, 0 + oriImage.getHeight(), bufferedImage.getWidth(), bufferedImage.getHeight(), null);
            }
        };
        panel.setPreferredSize(new Dimension(oriImage.getWidth(), oriImage.getHeight() * 2));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
