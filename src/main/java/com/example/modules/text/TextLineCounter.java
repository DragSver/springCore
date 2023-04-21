package modules.text;

import modules.Module;

import java.io.File;

public class TextLineCounter implements Module {
    @Override
    public boolean supports(String format) {
        return "txt".equals(format);
    }

    @Override
    public String description() {
        return "Подсчет и вывод количества строк в текстовом файле.";
    }

    @Override
    public void process(File file) {
        // Реализуйте метод для подсчета строк в файле
    }
}
