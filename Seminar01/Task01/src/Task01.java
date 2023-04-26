public class Task01 {
   public static void main(String[] args) {
      int[] arr01 = { 2, 7, 3, 5, 4 };
      // int[] arr01 = null;
      int hountedNum = 7;
      int minLength = 5;

      int result = arrayLength(arr01, hountedNum, minLength);

      if (result == -1) {
         System.out.println("Длина массива меньше требуемой");
      } else if (result == -2) {
         System.out.println("Элемент не найден");
      } else if (result == -3) {
         System.out.println("Нулевой массив");
      } else {
         System.out.println("Индекс найденного элемента: " + result);
         System.out.println("Найденный элемент: " + arr01[result]);
      }
   }

   /*
    * Метод принимает в качестве аргумента целочисленный массив и некоторое
    * значение.
    * Ищет в массиве заданное значение и возвращает его индекс.
    * 1. если длина массива меньше некоторого заданного минимума, метод возвращает
    * -1, в качестве кода ошибки.
    * 2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
    * 3. если вместо массива пришел null, метод вернет -3
    */
   static int arrayLength(int[] arr, int hountedNum, int minLength) {
      if (arr == null) {
         return -3;
      } else if (arr.length < minLength) {
         return -1;
      } else if (arr.length == 0) {
         return -3;
      }
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == hountedNum) {
            return i;
         }
      }
      return -2;
   }
}
