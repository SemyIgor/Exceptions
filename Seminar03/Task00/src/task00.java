
/*
 * Перепишите следующий код, используя ресурсный try
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class task00 {
   public static void main(String[] args) {
      Path pathRead = Paths.get("fileToRead.txt");
      Path pathWrite = Paths.get("fileToWrite.txt");

      try {
         // Вызов функции, которая сама обрабатывает исключение
         rwLine(pathRead, pathWrite);
         System.out.println("Первый отработал"); // Выводится в консоль

         // Вызов функции, пробрасывающей исключение в точку вызова, которое
         // обрабатывается здесь чуть ниже
         rwLine2(pathRead, pathWrite);
         System.out.println("Второй отработал"); // Не выводится в консоль
      } catch (NullPointerException e) {
         e.printStackTrace();
         System.out.println("Ну нет такого объекта");
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Ошибка ввода/вывода");
      }
   }

   public static void rwLine(Path pathRead, Path pathWrite) throws IOException {
      /*
       * Этот закомментированный код перехватывает IOException самостоятельно,
       * но выполняет поставленную задачу: try-with-resources
       */

      // Следующие далее строки с newBufferedReader требуют импорт библиотеки
      // java.nio.file.Path, которая не устанавливается автоматически
      try (BufferedReader in = Files.newBufferedReader(pathRead);
            BufferedWriter out = Files.newBufferedWriter(pathWrite);) {
         out.write(in.readLine());
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Ошибка чтения/записи файла " +
               e.getClass().getSimpleName());
      }
   }

   public static void rwLine2(Path pathRead, Path pathWrite) throws IOException {
      // Этот код передаёт возникшее исключение в вызывающую функцию
      BufferedReader in = Files.newBufferedReader(pathRead);
      BufferedWriter out = Files.newBufferedWriter(pathWrite);
      out.write(in.readLine());
   }
}
