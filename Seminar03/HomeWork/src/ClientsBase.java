/* 
 * 1. Напишите приложение, которое будет запрашивать у пользователя следующие данные 
 * в произвольном порядке, разделенные пробелом:
 * Фамилия 
 * Имя 
 * Отчество 
 * дата рождения 
 * номер телефона 
 * пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

* 2. Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

* 3. Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

* 4. Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.

*5. При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
 */

/*
 * 1. Вводим строку с данными через пробел
 * 2. Преобразуем строку в массив строк
 * 3. Определяем количество введённых данных (длина массива строк должна равняться 6) (exception)
 * 4. Распарсить данные, обработать на предмет ошибок (exception)
 * 5. Создать/открыть файл с названием, равным фамилии с добавлением данных (если однофамильцы)(exception)
 * 6. Записать данные в одну строку <><><>...<> (exception)
 * 7. Закрыть соединение с файлом (exception)
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientsBase {
   public static void main(String[] args) {

      String str;
      // ArrayList<String> dataBase = new ArrayList<>();
      do {
         // str = "asd rt 12.05.1962 1234567890 m"; // Данных меньше, чем должно
         // str = "asd me no rt 12.05.1962 1234567890 m"; // Данных больше, чем должно
         // str = "asd we rt 12.05.1962 1234567890 m"; // Правильный ввод данных
         // str = "фыва на rt 12.05.1962 1234567890 m"; // Правильный ввод данных
         str = getString(); // Ввод пользователем

         if (!str.equals("Q") && !str.equals("q")) {
            String[] datesArray = str.split(" ");
            try {
               if (checkDatesNumber(datesArray)) {
                  System.out.println("Обработка данных");
                  strArrayToFile(datesArray, datesArray[0] + ".txt");
               }

            } catch (RuntimeException e) {
               System.out.println(e.getStackTrace().toString());
            }
         }
         // str = "q"; // Автоматический выход из цикла
      } while (!str.equals("Q") && !str.equals("q"));
   }

   // Ввод строки с данными
   static String getString() {
      System.out.println("Введите данные через пробел:");
      System.out.println(
            "Фамилия Имя Отчество Дата_рождения(dd.mm.yyyy) Телефон(только цифры) Пол(m/f):\nДля выхода введите q или Q");
      Scanner in = new Scanner(System.in, "utf-8");
      String string = in.nextLine();
      return string;
   }

   // Метод записи строки в файл
   static void stringToFile(String str, String pathnameString) {
      try (FileWriter writer = new FileWriter(pathnameString, true)) {
         writer.write(str.toString() + "\n");
         writer.flush();
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }

   // Метод записи массива строк в файл
   static void strArrayToFile(String[] str, String pathnameString) {
      try (FileWriter writer = new FileWriter(pathnameString, true)) {
         for (String strItem : str) {
            writer.write("<" + strItem + "> ");
         }
         writer.write("\n");
         writer.flush();
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }

   // Проверка количества введённых данных
   static boolean checkDatesNumber(String[] strArray) throws RuntimeException {
      int arrLength = strArray.length;
      if (arrLength == 6) {
         return true;
      } else if (arrLength < 6) {
         throw new RuntimeException("Введено недостаточное количество данных. Повторите ввод\n");
         // return -1;
      } else {
         throw new RuntimeException("Введено чрезмерное количество данных. Повторите ввод\n");
         // return 1;
      }
   }

   // Печать строкового массива
   static void printArray(String[] str) {
      for (String string : str) {
         System.out.println(string + " -> " + string.length());
      }
   }
}
