package com.example.modules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.example.modules.Module;

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
            try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            ExifIFD0Directory exifIFD0Directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
            if (exifIFD0Directory != null) {
                System.out.println("Camera make: " + exifIFD0Directory.getString(ExifIFD0Directory.TAG_MAKE));
                System.out.println("Camera model: " + exifIFD0Directory.getString(ExifIFD0Directory.TAG_MODEL));
            } else {
                System.out.println("Нет данных.");
            }
        } catch (Exception e) {
            System.err.println("Error reading metadata: " + e.getMessage());
        }
    }
}
