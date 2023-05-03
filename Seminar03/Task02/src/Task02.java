/* 
 * Создайте класс Счётчик, у которого есть метод add(), увеличивающий
 * значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
 * такого типа можно было работать в блоке try-with-resources. Подумайте, что
 * должно происходить при закрытии этого ресурса? Напишите метод для
 * проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого ресурса, 
 * должен выброситься IOException.
 */

public class Task02 {
   public static void main(String[] args) throws Exception {

      try (Counter cou = new Counter(3);) {
         for (int i = 0; i < 7; i++) {
            if (i == 2) {
               cou.close();
            } else {
               System.out.println(i + ", " + cou.getCount());
               cou.add();
            }
         }
      }
   }

   static class Counter implements AutoCloseable {
      private int count;
      private boolean opend;

      Counter(int count) {
         this.count = count;
         this.opend = true;
      }

      void add() throws RuntimeException {
         if (opend) {
            count++;
         } else {
            throw new RuntimeException("Счётчик закрыт");
         }
      }

      public int getCount() {
         return count;
      }

      @Override
      public void close() throws Exception {
         opend = false;
      }

   }
}
