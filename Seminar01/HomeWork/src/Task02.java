/* 
 * Посмотрите на код и подумайте, сколько разных типов исключений вы тут сможете получить?
 */
public class Task02 {
   public static void main(String[] args) {
      // Массив для демонстрации исключения NumberFormatException:
      String[][] array04 = { { "2.1", "4", "6", "1", "8" }, { "7", "3", "1", "2", "5" } };
      // Массив для демонстрации исключения ArrayIndexOutOfBoundsException:
      // String[][] array04 = { { "2", "4", "6", "1" }, { "7", "3", "2", "5" } };
      System.out.println(sum2d(array04));
   }

   /*
    * Задача 2
    * В приведенном коде возможны следующие исключения:
    * 1. NumberFormatException (Парсинг строки в целое, если это невозможно)
    * 2. ArrayIndexOutOfBoundsException (Передача функции массива с числом
    * элементов в строке менее 5)
    */
   public static int sum2d(String[][] arr) {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < 5; j++) {
            int val = Integer.parseInt(arr[i][j]);
            sum += val;
         }
      }
      return sum;
   }
}
