/* 
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
public class Task03 {
   public static void main(String[] args) {
      int[] array01 = { 7, 2, 8, 10, 4, 1, 5 };
      int[] array02 = { 4, 7, 8, 0, 2, 11 };

      printIntArray(subArrElements(array01, array02));
   }

   public static int[] subArrElements(int[] arr1, int[] arr2) {
      if (arr1.length != arr2.length) {
         throw new RuntimeException("Длины переданных массивов не равны");
      }
      int[] resaltArr = new int[arr2.length];
      for (int i = 0; i < arr2.length; i++) {
         resaltArr[i] = arr1[i] - arr2[i];
      }
      return resaltArr;
   }

   static void printIntArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.print('\n');
   }
}
