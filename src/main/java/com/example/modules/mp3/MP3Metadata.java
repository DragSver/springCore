package com.example.modules.mp3;

import com.example.modules.Module;

import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.IOException;

public class MP3Metadata implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("mp3");
    }

    @Override
    public String description() {
        return "Вывод метаданных mp3 файла.";
    }

    @Override
    public void process(File file) {
        try {
            Mp3File mp3file = new Mp3File(file.getPath());

            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                System.out.println("Track: " + id3v1Tag.getTrack());
                System.out.println("Artist: " + id3v1Tag.getArtist());
                System.out.println("Title: " + id3v1Tag.getTitle());
                System.out.println("Album: " + id3v1Tag.getAlbum());
                System.out.println("Year: " + id3v1Tag.getYear());
                System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
                System.out.println("Comment: " + id3v1Tag.getComment());
            } else {
                System.out.println("Нет данных.");
            }
        } catch (IOException | UnsupportedTagException | InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }
}
