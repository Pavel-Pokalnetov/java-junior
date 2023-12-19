package task2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools {
    public static void saveToFile(String string, String filename) throws IOException {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(string);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static String readFromFile(String filename) throws IOException {
        String xmlStudent;
        try {
            xmlStudent = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
            return xmlStudent;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
