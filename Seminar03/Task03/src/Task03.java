
/* 
 * 1. Создайте класс исключения, который будет выбрасываться при делении на 0. Исключение должно отображать понятное для пользователя сообщение об ошибке.
 * 2. Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа. Исключение должно отображать понятное для пользователя сообщения об ошибке.
 * 3. Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл. Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ArithmeticException;

public class Task03 {
   public static void main(String[] args) throws Exception {
      // Пример работы прерывания "OnZeroDivision"
      // onZeroDivExample(10, 0); // Для демонстрации снять комментарий

      // Пример работы прерывания "NullArrayElement"
      // Integer[] intArray = { 2, 7, 4, null, 8, 0 };
      // nullArrayElemExample(intArray); // Для демонстрации снять комментарий

      // Пример работы прерывания "IOException"
      noSuchFileExample("fileToRead.txt");
   }

   static void noSuchFileExample(String path) throws FileNotFoundException, IOException {
      int c;
      try (FileReader charRed = new FileReader(path)) {
         if (charRed.ready()) {
            c = charRed.read();
            System.out.print((char) c);
            System.out.println();
            System.out.println((char) (charRed.read()));
         }
      } catch (FileNotFoundException e) {
         throw new NoSuchFile("Нет такого файла в этом исключении");
      }
   }

   static void nullArrayElemExample(Integer[] arr) {
      try {
         int sum = 0;
         for (int item : arr) {
            System.out.println(item);
            sum += item;
         }
         System.out.println("Сумма элементов массива = " + sum);
      } catch (NullPointerException ex) {
         throw new NullArrayElement("В массиве найден нулевой элемент !");
      }
   }

   static void onZeroDivExample(int a, int b) {
      try {
         int c = a / b;
         System.out.print(String.format("%d / %d = %d", a, b, c));
      } catch (ArithmeticException e) {
         throw new OnZeroDivision("На ноль делить нельзя!\n" + e.fillInStackTrace());
      }
   }

   static class OnZeroDivision extends ArithmeticException {
      public OnZeroDivision(String message) {
         super(message);
      }
   }

   static class NullArrayElement extends NullPointerException {
      public NullArrayElement(String message) {
         super(message);
      }
   }

   static class NoSuchFile extends IOException {
      public NoSuchFile(String message) {
         super(message);
      }
   }
}
