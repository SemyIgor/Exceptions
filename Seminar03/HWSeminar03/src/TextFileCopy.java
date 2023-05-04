import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileCopy {
   public static void main(String[] args) throws Exception {
      String reader = "fileToRead.txt";
      String writer = "fileToWrite.txt";
      copyFile(reader, writer);
   }

   static void copyFile(String reader, String writer) throws IOException {
      try (FileReader read = new FileReader(reader);
            FileWriter write = new FileWriter(writer, false)) {
         while (read.ready()) {
            write.write(read.read());
         }
      } catch (IOException e) {
         throw new IOException(e.getMessage());
      }
   }
}
