package com.example.modules.mp3;

import com.example.modules.Module;

import com.mpatric.mp3agic.ID3v2;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;

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
            MP3File mp3file = (MP3File) AudioFileIO.read(file);
            if (mp3file != null && mp3file.hasID3v2Tag()) {
                ID3v2 tag = (ID3v2) mp3file.getID3v2Tag();
                System.out.println("Название: " + tag.getTitle());
                System.out.println("Артист: " + tag.getArtist());
                System.out.println("Альбом: " + tag.getAlbum());
                System.out.println("Год: " + tag.getYear());
                System.out.println("Жанр: " + tag.getGenreDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
