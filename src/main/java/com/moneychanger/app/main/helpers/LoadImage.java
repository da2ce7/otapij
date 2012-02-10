package com.moneychanger.app.main.helpers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LoadImage {

    private Icon _passwordImage;

    public LoadImage(String path) {
        ImageIcon _passwordIcon = createImageIcon(path, "Password Icon");
        _passwordImage = new ImageIcon(getScaledImage(_passwordIcon.getImage(), 256, 256));
    }

    public Icon getIcon()
    {
        return _passwordImage;
    }

    /**
     * Creates an ImageIcon if the path is valid.
     *
     * @param String - resource path
     * @param String - description of the file
     */
    private ImageIcon createImageIcon(String path,
            String description) {
   //     java.net.URL imgURL = getClass().getResource(path);
        if (path != null) {
            return new ImageIcon(path, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     *
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
}
