package ru.gb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {
  public static void main(String[] args) {
    File directory = new File("./backup");
    directory.mkdir();

    File[] files = new File(".").listFiles();

    for (File file: files) {
      if (file.isFile()) {
        try {
          Files.copy(file.toPath(), new File(directory.getAbsolutePath() + "/" + file.getName()).toPath(),
                  StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }

    System.out.println("Резервная копия создана в папке" + directory.getAbsolutePath());
  }
}