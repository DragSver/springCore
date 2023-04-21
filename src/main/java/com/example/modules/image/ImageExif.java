package modules.image;

import modules.Module;

import javax.imageio.ImageIO;
import java.io.File;

public class ImageExif implements Module {
    @Override
    public boolean supports(String format) {
        return ImageIO.getImageReadersBySuffix(format).hasNext();
    }

    @Override
    public String description() {
        return "Вывод EXIF данных изображения.";
    }

    @Override
    public void process(File file) {
        // Реализуйте метод для чтения и вывода EXIF данных изображения
    }
}
