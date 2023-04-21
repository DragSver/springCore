package com.example.modules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import com.example.modules.Module;

import javax.imageio.ImageIO;
import java.io.File;


public class ImageGPS implements Module {
    @Override
    public boolean supports(String format) {
        return ImageIO.getImageReadersBySuffix(format).hasNext();
    }

    @Override
    public String description() {
        return "Вывод GPS данных изображения.";
    }

    @Override
    public void process(File file) {
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
            if (gpsDirectory != null) {
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_LATITUDE_REF) + ": " + gpsDirectory.getString(GpsDirectory.TAG_LATITUDE_REF));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_LONGITUDE_REF) + ": " + gpsDirectory.getString(GpsDirectory.TAG_LONGITUDE_REF));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_LATITUDE) + ": " + gpsDirectory.getString(GpsDirectory.TAG_LATITUDE));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_LONGITUDE) + ": " + gpsDirectory.getString(GpsDirectory.TAG_LONGITUDE));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_ALTITUDE_REF) + ": " + gpsDirectory.getString(GpsDirectory.TAG_ALTITUDE_REF));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_ALTITUDE) + ": " + gpsDirectory.getString(GpsDirectory.TAG_ALTITUDE));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_MAP_DATUM) + ": " + gpsDirectory.getString(GpsDirectory.TAG_MAP_DATUM));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_SPEED_REF) + ": " + gpsDirectory.getString(GpsDirectory.TAG_SPEED_REF));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_SPEED) + ": " + gpsDirectory.getString(GpsDirectory.TAG_SPEED));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_IMG_DIRECTION_REF) + ": " + gpsDirectory.getString(GpsDirectory.TAG_IMG_DIRECTION_REF));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_IMG_DIRECTION) + ": " + gpsDirectory.getString(GpsDirectory.TAG_IMG_DIRECTION));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_DATE_STAMP) + ": " + gpsDirectory.getString(GpsDirectory.TAG_DATE_STAMP));
                System.out.println(gpsDirectory.getTagName(GpsDirectory.TAG_TIME_STAMP) + ": " + gpsDirectory.getString(GpsDirectory.TAG_TIME_STAMP));
            } else {
                System.out.println("Нет данных.");
            }
        } catch (Exception e) {
            System.err.println("Error reading metadata: " + e.getMessage());
        }
    }
}