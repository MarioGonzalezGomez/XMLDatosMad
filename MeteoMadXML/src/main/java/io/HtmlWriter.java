package io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class HtmlWriter {

    public void generarHtml(List<String> texto) throws IOException {
        String nombreDoc = texto.get(0).toLowerCase() + ".html";
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "resources" + File.separator + "informes" + File.separator + nombreDoc);
        Files.write(path, texto, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }
}
