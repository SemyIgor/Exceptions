/* 
 * 2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */
public class Task02 {
   public static void main(String[] args) {
      // Задание 2
      try {
         int[] intArray = { 5, 4, 7, 1, 3, 9, 0, 7, 2, 6 }; // В коде не был инициирован массив
         int d = 0;
         double catchedRes1 = intArray[8] / d;
         System.out.println("catchedRes1 = " + catchedRes1);
      } catch (ArithmeticException e) {
         System.out.println("Catching exception: " + e);
      }

   }
}

// Найдена одна ошибка (не инициирован массив)
// и (это не ошибка, поэтому ничего не менял), но я бы выделил этот код в
// отдельный метод, а переменную d и элемент массива intArray передавал бы
// как параметр.
// Если бы стоял вопрос повышения надёжности кода, то проверял бы индекс
// элемента массива на его соответствие длине массива с обработкой возможной
// ошибки.
