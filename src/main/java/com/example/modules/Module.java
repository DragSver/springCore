package modules;

import java.io.File;

public interface Module {
    boolean supports(String format);
    String description();
    void process(File file);
}
