/* 
 * 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
 * и возвращает введенное значение. Ввод текста вместо числа не должен приводить к падению приложения, 
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Task01 {
   public static void main(String[] args) {

      boolean entered = false;
      while (!entered) {
         Scanner in = new Scanner(System.in);
         try {
            System.out.print("Input a float number: ");
            float fl = in.nextFloat();
            System.out.printf("Your number: %f \n", fl);
            entered = true;
         } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
         } finally {
            System.out.println(entered);
            in.close();
         }
      }
   }

   static float takeFloatNumber() {
      float a = 1.0F;
      return a;
   }
}
