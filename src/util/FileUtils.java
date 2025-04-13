package util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static BufferedImage loadImageFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть изображение");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            try {
                return ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void saveImageToFile(BufferedImage image) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить изображение");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PNG files", "*.png")
        );
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try {
                ImageIO.write(image, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Image convertToFXImage(BufferedImage bufferedImage) {
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }
}