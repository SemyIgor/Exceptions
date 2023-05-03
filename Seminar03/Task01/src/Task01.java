/* 
 * Создайте метод doSomeThing(), который может быть источником одного из типов checked exceptions (тело самого метода прописывать не обязательно). Вызовите этот метод из main и обработайте в нём исключение, которое вызвал метод doSomething().
 */

import java.io.IOException;

public class Task01 {
   public static void main(String[] args) {
      try {
         doSomething();
      } catch (IOException e) {
         System.out.println("Catch " + e.getClass().getSimpleName());
      }
   }

   static void doSomething() throws IOException {
      throw new IOException("Исключение ввода / вывода");
   }
}
