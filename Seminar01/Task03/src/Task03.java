/*
 * Реализуйте метод checkArray(Integer[] arr), принимающий 
 * в качестве аргумента целочисленный одномерный массив.
 * Метод должен пройтись по каждому элементу и проверить что он не равен null.
 * А теперь реализуйте следующую логику:
 * Если в какой-то ячейке встретился null, то необходимо “оповестить” 
 * об этом пользователя
 * Если null’ы встретились в нескольких ячейках, то идеально было бы все их "подсветить"
 */
public class Task03 {
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_RED = "\u001B[31m";

   public static void main(String[] args) {
      Integer[] array = { 2, 7, null, 12, 5, null, 9 };

      // System.out.println(checkArray(array));
      if (checkArray(array) == true) {
         System.out.println("В массиве есть null");
      } else {
         System.out.println("В массиве нет элемента null");
      }

      printArray(array);
   }

   static void printArray(Integer[] arr) {
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == null) {
            System.out.print(ANSI_RED + arr[i] + " " + ANSI_RESET);
         } else {
            System.out.print(arr[i] + " ");
         }
      }
   }

   static boolean checkArray(Integer[] arr) {
      boolean hasNull = false;
      for (int i = 0; i < arr.length; i++) {
         if (arr[i] == null) {
            hasNull = true;
         }
      }
      return hasNull;
   }
}
