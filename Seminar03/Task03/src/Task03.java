
/* 
 * 1. Создайте класс исключения, который будет выбрасываться при делении на 0. Исключение должно отображать понятное для пользователя сообщение об ошибке.
 * 2. Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа. Исключение должно отображать понятное для пользователя сообщения об ошибке.
 * 3. Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл. Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
import java.io.IOException;
import java.lang.ArithmeticException;

public class Task03 {
   public static void main(String[] args) {
      // OnZeroDivision divNul = new OnZeroDivision("Деление на нуль");
      int a = 10;
      int b = 0;
      try {
         int c = a / b;
         System.out.print(String.format("%d / %d = %d", a, b, c));
      } catch (OnZeroDivision e) {
         System.out.println("Деление на нуль" + e.getLocalizedMessage());
      } finally {
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
