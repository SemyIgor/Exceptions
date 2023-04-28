/* 
 * Олег Голенищев: 
 * Запишите в файл следующие строки:
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * 
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив 
 * (либо HashMap, если студенты с ним знакомы). 
 * 
 * В отдельном методе нужно будет пройти по структуре данных, 
 * если сохранено значение ?, заменить его на соответствующее число.
 * Если на каком-то месте встречается символ, отличный от числа или ?, 
 * бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task01 {
   public static void main(String[] args) {
      readFileScan("log.txt");
   }

   // Распечатываем строки из файла
   static void readFileScan(String pathnameString) {
      Scanner fileReader = null; // Создаём вне блока try, иначе он не будет виден в блоке finally
      try {
         File file = new File(pathnameString);
         fileReader = new Scanner(file);
         while (fileReader.hasNextLine()) {
            String nextName = fileReader.nextLine();
            nextName.strip();
            // nextName.split(nextName, 0);

            System.out.println(nextName);
         }
      } catch (FileNotFoundException e) {
         System.out.println("Файл не найден");
         // e.printStackTrace();
      } finally {
         fileReader.close();
      }
   }
}
