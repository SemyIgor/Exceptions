/*
 * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
 * Необходимо посчитать и вернуть сумму элементов этого массива.
 * При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами (кол-во строк = кол-ву  
 * столбцов), и в каждой ячейке может лежать только значение 0 или 1.
 * Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */
public class Task02 {
   public static void main(String[] args) {

      short[][] array = {
            { 1, 3, 0, 1, 0 }, { 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 0, 1, 1, 0, 0 }/* , { 0, 0, 1, 1, 0 } */
      };

      if (array.length != array[0].length) {
         throw new RuntimeException("Массив не является квадратным");
      }

      print2DArray(array);

      System.out.println("Сумма элементов массива: " + arraySum(array));
      System.out.println(array.length + ", " + array[0].length);
   }

   static void print2DArray(short[][] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
            if (arr[i][j] != 0 && arr[i][j] != 1) {
               throw new RuntimeException("Число не равно 0 или 1");
            }
            // Интересный альтернативный вариант:
            // System.out.print(array[i][j] - 32 + ' ' + " ");
            // Суть: если после элемента массива следует char (' '), то и элементы массива
            // выводятся в виде ASCII - кода
            // Если за ним следует String (" "), то и элемент воспринимается как стринг.
         }
         System.out.print("\n");
      }
   }

   static short arraySum(short[][] arr) {
      short sum = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            sum += arr[i][j];
         }
         System.out.print("\n");
      }
      return sum;
   }

}
