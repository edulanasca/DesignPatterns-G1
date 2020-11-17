package monitoreo.modelos;

import java.io.IOException;
import java.nio.file.*;

public class FileLog {

  private static FileLog fileLog;
  public static final String FILE_DIR = "src/log.txt";

  private FileLog() {
  }

  public static synchronized FileLog getInstance() {
    if (fileLog == null) {
      fileLog = new FileLog();
    }
    return fileLog;
  }

  public void write(String msg) throws IOException {
    Path path = Paths.get(FILE_DIR);
    try {
      Files.write(path, msg.getBytes(), StandardOpenOption.CREATE_NEW);
    } catch (FileAlreadyExistsException ex) {
      Files.write(path, msg.getBytes(), StandardOpenOption.APPEND);
    }
  }

}
