/* 
 * 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class Task04 {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.print("Введите строку символов: ");
      String string = in.nextLine();
      in.close();
      if (string.trim().length() == 0) {
         System.out.println("Нельзя вводить пустые строки");
         throw new RuntimeException("Нельзя вводить пустые строки");
      }
   }
}
