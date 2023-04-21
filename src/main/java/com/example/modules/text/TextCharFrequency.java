package modules.text;

import modules.Module;

import java.io.File;

public class TextCharFrequency implements Module {
    @Override
    public boolean supports(String format) {
        return "txt".equals(format);
    }

    @Override
    public String description() {
        return "Вывод частоты вхождения каждого символа в текстовом файле.";
    }

    @Override
    public void process(File file) {
        // Реализуйте метод для подсчета частоты вхождения символов в файле
    }
}