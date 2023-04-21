package com.example.modules.mp3;

import com.example.modules.Module;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;

import java.io.File;

public class MP3Duration implements Module {
    @Override
    public boolean supports(String format) {
        return format.equalsIgnoreCase("mp3");
    }

    @Override
    public String description() {
        return "Выводит продолжительность MP3 файла.";
    }

    @Override
    public void process(File file) {
        int durationInMilliseconds = 0;

        try {
            Bitstream bitstream = new Bitstream(new java.io.FileInputStream(file));
            Header header = bitstream.readFrame();

            while (header != null) {
                durationInMilliseconds += header.ms_per_frame();
                bitstream.closeFrame();
                header = bitstream.readFrame();
            }

            bitstream.close();

            int durationInSeconds = durationInMilliseconds / 1000;

            System.out.println("Продолжительность файла в секундах: " + durationInSeconds);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
