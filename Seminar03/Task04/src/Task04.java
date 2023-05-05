/* 
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчёта (сумму элементов, при условии, что подали на вход корректный массив)
 */
public class Task04 {
   public static void main(String[] args) {
      String[][] array = {
            { "2", "5", "7", "4" },
            { "14", "11", "12", "17" },
            { "21", "25", "ф27", "s23" }, // Присутствует строковой элемент
            // { "21", "25", "27", "23" }, // Лишняя строка
            { "12", "9", "24", "11" }
      };

      try {
         System.out.println(checkArraySize(array));
         if (checkArraySize(array)) {
            System.out.println(countArraysElemSum(array));
         }
      } catch (Exception e) {
         System.out.println(e.getLocalizedMessage());
      }
   }

   static boolean checkArraySize(String[][] arr) throws MyArraySizeException {
      if (arr.length != 4 || arr[0].length != 4) {
         throw new MyArraySizeException();
      }
      return true;
   }

   static int countArraysElemSum(String[][] arr) throws MyArrayDataException {
      int elemSum = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            try {
               elemSum += Integer.parseInt(arr[i][j].trim());
            } catch (NumberFormatException e) {
               throw new MyArrayDataException(
                     String.format("\nЭлемент %s в позиции [%d][%d] \nне преобразовывается в число", arr[i][j], i, j));
            } finally {
               System.out.print(arr[i][j] + "\t");
            }
         }
         System.out.println();
      }
      return elemSum;
   }

   static class MyArraySizeException extends RuntimeException {
      public MyArraySizeException() {
         super("Массив не соответствует требуемому размеру");
      }
   }

   static class MyArrayDataException extends NumberFormatException {
      public MyArrayDataException(String message) {
         super(message);
      }
   }
}
