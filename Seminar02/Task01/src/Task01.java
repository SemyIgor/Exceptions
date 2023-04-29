/* 
 * 1. Запишите в файл следующие строки:
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * 
 * 2. Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив 
 * (либо HashMap, если студенты с ним знакомы). 
 * 
 * 3. В отдельном методе нужно будет пройти по структуре данных, 
 * если сохранено значение ?, заменить его на соответствующее число.
 * Если на каком-то месте встречается символ, отличный от числа или ?, 
 * бросить подходящее исключение.
 * 
 * 4. Записать в тот же файл данные с замененными символами ?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Task01 {
   public static void main(String[] args) {

      HashMap<String, String> namesAndLength = new HashMap<>();
      namesAndLength = readFileToMap(namesAndLength, "log.txt");
      System.out.println(namesAndLength);
      correctHashMap(namesAndLength);
      System.out.println(namesAndLength);
   }

   // Читает строки из файла и вызывает метод их добавления в HashMap
   static HashMap<String, String> readFileToMap(HashMap<String, String> namesAndLength, String pathnameString) {
      Scanner fileReader = null;
      try {
         File file = new File(pathnameString);
         fileReader = new Scanner(file);
         while (fileReader.hasNextLine()) {
            String nextName = fileReader.nextLine();
            stringAddToMap(namesAndLength, nextName);
         }
      } catch (FileNotFoundException e) {
         System.out.println("Файл не найден");
      } finally {
         fileReader.close();
      }
      return namesAndLength;
   }

   // Метод добавления строки в HashMap
   static HashMap<String, String> stringAddToMap(HashMap<String, String> namesAndLength, String s) {
      String[] tmpArray = s.strip().split("=");
      String name = tmpArray[0];
      String nameLength = tmpArray[1];
      namesAndLength.put(name, nameLength);
      return namesAndLength;
   }

   // Метод корректировки данных в HashMap
   static HashMap<String, String> correctHashMap(HashMap<String, String> namesAndLength) {
      for (HashMap.Entry<String, String> entry : namesAndLength.entrySet()) {
         String name = entry.getKey();
         String nameLength = entry.getValue();
         // Если "?"
         if (nameLength.equals("?")) {
            nameLength = ((Integer) name.length()).toString();
            /*
             * Возможен вариант:
             * nameLength = Integer.toString(name.length());
             */
            entry.setValue(nameLength);
         }
         // Если любое другое значение, кроме количества букв в имени, то
         if (!nameLength.equals(((Integer) name.length()).toString())) {
            throw new RuntimeException(String.format("Количество букв в имени %s определено неверно", name));
         }
      }
      return namesAndLength;
   }

   // Метод записи HashMap в файл (пока не реализован)
   static void mapToFile(HashMap<String, String> namesAndLength, String pathnameString) {

   }

}
