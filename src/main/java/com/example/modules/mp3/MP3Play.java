package com.example.modules.mp3;

import com.example.modules.Module;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MP3Play implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("mp3");
    }

    @Override
    public String description() {
        return "Воспроизводит MP3 файл. ";
    }

    @Override
    public void process(File file) {
        try {
            FileInputStream stream = new FileInputStream(file.getPath());
            Player player = new Player(stream);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }
}
