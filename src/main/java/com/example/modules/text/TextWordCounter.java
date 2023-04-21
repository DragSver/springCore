package com.example.modules.text;

import com.example.modules.Module;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class TextCaesarsCipher implements Module {
    @Override
    public boolean supports(String format) {
        return "txt".equals(format);
    }

    @Override
    public String description() {
        return "Описание вашей собственной функции.";
    }

    @Override
    public void process(File file) {
        BufferedReader reader = null;
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(String word : words) {
                    if(wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}