/* 
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: при выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, то есть ваше.
 */
public class Task04 {
   public static void main(String[] args) {
      int[] array01 = { 7, 2, 8, 10, 4, 1, 5 };
      int[] array02 = { 4, 7, 8, 0, 2, 11 }; // Массив короче и содержит 0

      printDoubleArray(divArrElements(array01, array02));
   }

   public static double[] divArrElements(int[] arr1, int[] arr2) {
      if (arr1.length != arr2.length) {
         throw new RuntimeException("Длины переданных массивов не равны");
      }
      double[] resaltArr = new double[arr2.length];
      for (int i = 0; i < arr2.length; i++) {
         if (arr2[i] == 0) {
            throw new RuntimeException("Деление на 0");
         }
         resaltArr[i] = 1.0 * arr1[i] / arr2[i];
      }
      return resaltArr;
   }

   static void printDoubleArray(double[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.printf("%.1f; ", arr[i]);
      }
      System.out.print('\n');
   }
}
