package controller;

import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.ImageProcessor;
import util.FileUtils;

import java.awt.image.BufferedImage;

public class MainController {
    private final ImageView originalView;
    private final ImageView resultView;
    private final ComboBox<String> filterBox;
    private BufferedImage originalImage;
    private BufferedImage resultImage;

    public MainController(ImageView originalView, ImageView resultView, ComboBox<String> filterBox) {
        this.originalView = originalView;
        this.resultView = resultView;
        this.filterBox = filterBox;
    }

    public void loadImage() {
        originalImage = FileUtils.loadImageFromFile();
        if (originalImage != null) {
            Image fxImage = FileUtils.convertToFXImage(originalImage);
            originalView.setImage(fxImage);
            resultView.setImage(null);
        }
    }

    public void applyFilter() {
        if (originalImage != null) {
            String effect = filterBox.getValue();
            resultImage = model.ImageProcessor.process(originalImage, effect);
            Image fxResult = FileUtils.convertToFXImage(resultImage);
            resultView.setImage(fxResult);
        }
    }

    public void saveImage() {
        if (resultImage != null) {
            FileUtils.saveImageToFile(resultImage);
        }
    }
}