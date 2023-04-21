package com.example.modules.image;

import com.example.modules.Module;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSize implements Module {
    @Override
    public boolean supports(String format) {
        return ImageIO.getImageReadersBySuffix(format).hasNext();
    }

    @Override
    public String description() {
        return "Вывод размера изображения.";
    }

    @Override
    public void process(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println("Ширина: " + width + " Высота: " + height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
