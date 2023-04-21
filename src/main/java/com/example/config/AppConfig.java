package com.example.config;

import com.example.modules.directory.DirectoryFileData;
import com.example.modules.directory.DirectoryFileSize;
import com.example.modules.directory.DirectoryListing;
import com.example.modules.image.ImageGPS;
import com.example.modules.image.ImageExif;
import com.example.modules.image.ImageSize;
import com.example.modules.mp3.MP3Duration;
import com.example.modules.mp3.MP3Metadata;
import com.example.modules.mp3.MP3Play;
import com.example.modules.text.TextCharFrequency;
import com.example.modules.text.TextWordCounter;
import com.example.modules.text.TextLineCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TextLineCounter textLineCounter() {
        return new TextLineCounter();
    }

    @Bean
    public TextCharFrequency textCharFrequency() {
        return new TextCharFrequency();
    }

    @Bean
    public TextWordCounter textWordCounter() {
        return new TextWordCounter();
    }

    @Bean
    public ImageSize imageSize() {
        return new ImageSize();
    }

    @Bean
    public ImageExif imageExif() {
        return new ImageExif();
    }

    @Bean
    public ImageGPS imageGPS() {
        return new ImageGPS();
    }

    @Bean
    public MP3Metadata mp3Metadata() {
        return new MP3Metadata();
    }

    @Bean
    public MP3Play mp3Play() { return new MP3Play(); }

    @Bean
    public MP3Duration mp3Duration() { return new MP3Duration(); }

    @Bean
    public DirectoryListing directoryListing() {
        return new DirectoryListing();
    }

    @Bean
    public DirectoryFileData directoryFileData() { return new DirectoryFileData(); }

    @Bean
    public DirectoryFileSize directoryFileSize() { return new DirectoryFileSize(); }
}
