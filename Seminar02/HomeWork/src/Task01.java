/* 
 * 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
 * и возвращает введенное значение. Ввод текста вместо числа не должен приводить к падению приложения, 
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Task01 {
   public static void main(String[] args) {
      System.out.println(takeFloatNumber());
   }

   static float takeFloatNumber() {
      Scanner in = new Scanner(System.in);
      boolean entered = false;
      float num;

      do {
         System.out.print("Input a float number: \n");
         while (!in.hasNextFloat()) {
            System.out.println("Ошибка ввода. Попробуйте ещё раз!");
            in.next(); // Важно !
         }
         num = in.nextFloat();
         entered = true;
      } while (!entered);
      in.close();
      return num;
   }
}
