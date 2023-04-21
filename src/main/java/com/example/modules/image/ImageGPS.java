package com.example.modules.image;

import com.example.modules.Module;
//import com.example.thumbnailator.main.java.net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ImageCustomFunction implements Module {
    @Override
    public boolean supports(String format) {
        return ImageIO.getImageReadersBySuffix(format).hasNext();
    }

    @Override
    public String description() {
        return "Описание вашей собственной функции.";
    }

    @Override
    public void process(File file) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем новые размеры изображения
        System.out.print("Введите новую ширину изображения: ");
        int newWidth = scanner.nextInt();
        System.out.print("Введите новую высоту изображения: ");
        int newHeight = scanner.nextInt();

        // Указывем путь для сохранения обработанного изображения
        File outputFile = new File("path/to/output/" + file.getName() + newWidth + "x" + newHeight + ".jpg");

        // Вызываем функцию для изменения размера изображения
        resize(file, outputFile, newWidth, newHeight);

        scanner.close();
    }

    public static void resize(File inputFile, File outputFile, int newWidth, int newHeight) {
//        try {
//            // Изменяем размер изображения
//            Thumbnails.of(inputFile).size(newWidth, newHeight).toFile(outputFile);
//
//            System.out.format("Изображение %s было успешно изменено до %dx%d пикселей.%n",
//                    outputFile.getName(), newWidth, newHeight);
//
//        } catch (IOException e) {
//            System.err.format("Произошла ошибка при изменении размера изображения %s.%n", inputFile.getName());
//            e.printStackTrace();
//        }
    }
}