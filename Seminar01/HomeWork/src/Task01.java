/* 
 * 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
 */
public class Task01 {
   public static void main(String[] args) {
      // 1. ArithmeticException
      System.out.println(remnant(8, 0)); // Деление на 0

      // 2. ArrayIndexOutOfBoundsException
      // int[] array02 = { 4, 7, 8, 1, 2, 11, 9 };
      // printArray(array02); // Печать несуществующего элемента

      // 3. NegativeArraySizeException
      // int arrSize = -5;
      // createArray(arrSize); // Создание массива с отрицательной длиной
   }

   // 1. ArithmeticException
   // Вычисление остатка от деления
   static int remnant(int dividend, int divider) {
      return dividend % divider;
   }

   // 2. ArrayIndexOutOfBoundsException
   // Печать массива в цикле
   static void printArray(int[] arr) {
      for (int i = 0; i <= arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.print('\n');
   }

   // 3. NegativeArraySizeException
   static int createArray(int arrSize) {
      int[] newArr = new int[arrSize];
      return newArr.length;
   }
}
