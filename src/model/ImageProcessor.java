package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessor {
    public static BufferedImage process(BufferedImage image, String effect) {
        switch (effect) {
            case "Grayscale":
                return applyGrayscale(image);
            case "Invert":
                return applyInvert(image);
            case "Blur":
                return applyBlur(image);
            default:
                return image;
        }
    }

    private static BufferedImage applyGrayscale(BufferedImage img) {
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color c = new Color(img.getRGB(x, y));
                int gray = (int)(0.3 * c.getRed() + 0.59 * c.getGreen() + 0.11 * c.getBlue());
                Color gColor = new Color(gray, gray, gray);
                result.setRGB(x, y, gColor.getRGB());
            }
        }
        return result;
    }

    private static BufferedImage applyInvert(BufferedImage img) {
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color c = new Color(img.getRGB(x, y));
                Color inv = new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
                result.setRGB(x, y, inv.getRGB());
            }
        }
        return result;
    }

    private static BufferedImage applyBlur(BufferedImage img) {
        BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        int radius = 1;
        for (int y = radius; y < img.getHeight() - radius; y++) {
            for (int x = radius; x < img.getWidth() - radius; x++) {
                int r = 0, g = 0, b = 0;
                for (int dy = -radius; dy <= radius; dy++) {
                    for (int dx = -radius; dx <= radius; dx++) {
                        Color c = new Color(img.getRGB(x + dx, y + dy));
                        r += c.getRed();
                        g += c.getGreen();
                        b += c.getBlue();
                    }
                }
                int num = (2 * radius + 1) * (2 * radius + 1);
                Color avg = new Color(r / num, g / num, b / num);
                result.setRGB(x, y, avg.getRGB());
            }
        }
        return result;
    }
}