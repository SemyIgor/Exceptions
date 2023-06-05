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

/* НАЧАЛЬНЫЙ ПЛАН: */
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

public class ClientsBase {
   public static void main(String[] args) {

      String str; // Строка, вводимая пользователем
      String outString; // Строка, формируемая проверками
      int waitingDatasLength = 6;
      String pathToFile = "";
      do {
         /* ЗДЕСЬ МОЖНО КОПИРОВАТЬ СТРОКИ ДЛЯ ТЕСТИРОВАНИЯ */
         /*
          * // str = "asd rt 12.05.1962 1234567890 m"; // Данных меньше, чем должно
          * // str = "asd me no rt 12.05.1962 1234567890 m"; // Данных больше, чем должно
          * // str = "Henry S Ford 29.02.1962 1234567890 m"; // Ошибка даты (не високос)
          * // str = "Henry J Ford 29.21.1962 1234567890 m"; // Ошибка месяца
          * // str = "Mary J Sam 29.21.1962ц 1234567890 m"; // Ошибка года
          * // str = "Henry J Ford 12.05.1962 1234567890 db"; // Половая ошибка
          * // str = "Henry J Ford 12.05.1962 1234567890 m"; // Правильный ввод данных
          * // str = "Henry G Ford 12.05.1962 1234567890 m"; // Однофамилец
          */
         str = getString(); // Ввод пользователем
         outString = "";

         if (!str.equals("Q") && !str.equals("q") && !str.equals("й")) {
            // Уберём лишние пробелы и преобразуем строку в массив строк.
            String[] datasArray = str.replaceAll("\\s+", " ").split(" ");
            try {
               if (checkDatesNumber(datasArray, waitingDatasLength)) {
                  // ========= Обработка данных ===========================
                  if (isDatasCorrect(datasArray)) {
                     for (String wordString : datasArray) {
                        outString = outString + wordString + " ";
                     }
                     System.out.println("Итоговая строка: " + outString + "\n");
                  }
                  // Запись данных в файл
                  strArrayToFile(datasArray, pathToFile + datasArray[0] + ".txt");
               }
            } catch (RuntimeException e) {
               System.out.println(e.getLocalizedMessage());
               // e.printStackTrace(); // Здесь можно глянуть StackTrace
            }
         }
      } while (!str.equals("Q") && !str.equals("q") && !str.equals("й"));
   }

   // Приём введённой строки с данными
   static String getString() {
      System.out.println("Введите данные через пробел:");
      System.out.println(
            "Фамилия Имя Отчество Дата_рождения(dd.mm.yyyy) Телефон(только цифры) Пол(m/f):\nДля выхода введите q или Q");
      // Scanner in = new Scanner(System.in, "utf-8");
      // String string = in.nextLine();
      String string = System.console().readLine();
      return string;
   }

   // Проверка корректности введённых данных
   static boolean isDatasCorrect(String[] datasArray) throws RuntimeException {
      try {
         if (isLetters(datasArray[0]) &&
               isLetters(datasArray[1]) &&
               isLetters(datasArray[2]) &&
               isDate(datasArray[3]) &&
               isDigits(datasArray[4]) &&
               isSex(datasArray[5])) {
            return true;
         }
      } catch (RuntimeException e) {
         throw new RuntimeException(e.getLocalizedMessage());
      }
      return true;
   }

   // Проверка количества введённых данных
   static boolean checkDatesNumber(String[] strArray, int waitingDatasLength) throws RuntimeException {
      int arrLength = strArray.length;
      if (arrLength == waitingDatasLength) {
         return true;
      } else if (arrLength < waitingDatasLength) {
         throw new RuntimeException("Введено недостаточное количество данных. Повторите ввод\n");
         // return -1;
      } else {
         throw new RuntimeException("Введено чрезмерное количество данных. Повторите ввод\n");
         // return 1;
      }
   }

   // Проверка даты рождения на валидность
   static boolean isDate(String birthDate) throws RuntimeException {
      try {
         String[] dateArray = birthDate.split("\\."); // Экранируем точку
         if (!isDateForm(dateArray)) {
            throw new RuntimeException();
         } else if (!isYear(dateArray[2])) {
            throw new RuntimeException();
         } else if (!isMonth(dateArray[1])) {
            throw new RuntimeException();
         } else if (!isDay(dateArray)) {
            throw new RuntimeException();
         } else {
            return true;
         }
      } catch (RuntimeException e) {
         throw new RuntimeException(e.getLocalizedMessage());
      }
      // return true;
   }

   // Первичная проверка общего формата даты (без проброса исключения)
   static boolean isDateForm(String[] dateArray) {
      if (dateArray.length == 3) {
         return true;
      } else {
         throw new RuntimeException("Ошибка формата ввода даты\n");
      }
   }

   // Проверка ввода года рождения
   static boolean isYear(String yearString) throws RuntimeException {
      if (yearString.chars().allMatch(Character::isDigit)) {
         int yearNumber = Integer.parseInt(yearString);
         if (yearNumber >= 0 && yearNumber <= 9999) {
            return true;
         }
      }
      throw new RuntimeException("Неверно введен год рождения. Повторите ввод\n");
   }

   // Проверка ввода месяца рождения
   static boolean isMonth(String monthString) throws RuntimeException {
      if (monthString.chars().allMatch(Character::isDigit)) {
         int monthNumber = Integer.parseInt(monthString);
         if (monthNumber > 0 && monthNumber <= 12) {
            return true;
         }
      }
      throw new RuntimeException("Неверно введен месяц рождения. Повторите ввод\n");
   }

   // Високосный ли год?
   static int isLeapYear(int yearNumber) {
      if ((yearNumber % 400 == 0) || (yearNumber % 4 == 0 && yearNumber % 100 != 0)) {
         return 1;
      } else {
         return 0;
      }
   }

   // Проверка ввода дня рождения
   static boolean isDay(String[] dateArray) throws RuntimeException {
      int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      int yearNumber = Integer.parseInt(dateArray[2]);
      int monthNumber = Integer.parseInt(dateArray[1]);

      // Берём из массива, если февраль, то + 1 (високос) или + 0 (не високос)
      int maxDay = (monthNumber != 2) ? maxDays[monthNumber - 1] : maxDays[monthNumber - 1] + isLeapYear(yearNumber);

      if (dateArray[0].chars().allMatch(Character::isDigit)) {
         int dayNumber = Integer.parseInt(dateArray[0]);
         if (dayNumber > 0 && dayNumber <= maxDay) {
            return true;
         }
      }
      throw new RuntimeException("Неверно введен день рождения. Повторите ввод\n");
   }

   // Проверка ФИО на то, что в составе элемента массива только буквы
   static boolean isLetters(String fio) throws RuntimeException {
      // boolean onlyLatinAlphabet = string.matches("^[a-zA-Z0-9]+$");
      if (fio.chars().allMatch(Character::isLetter)) {
         return true;
      } else {
         throw new RuntimeException("В ФИО должны быть только буквы. Повторите ввод\n");
      }
   }

   // Проверка номера телефона на то, что в нём только цифры
   static boolean isDigits(String phoneNumber) throws RuntimeException {
      if (phoneNumber.chars().allMatch(Character::isDigit)) {
         return true;
      } else {
         throw new RuntimeException("В номере телефона должны быть только цифры. Повторите ввод\n");
      }
   }

   // Проверка правильности введения половой принадлежности
   static boolean isSex(String sex) throws RuntimeException {
      if (sex.equals("m") || sex.equals("f")) {
         return true;
      } else {
         throw new RuntimeException("Неверно введен пол. Повторите ввод\n");
      }
   }

   // Метод записи массива данных в файл (без проброса исключения)
   static void strArrayToFile(String[] str, String pathnameString) {
      try (FileWriter writer = new FileWriter(pathnameString, true)) {
         for (String strItem : str) {
            writer.write("<" + strItem + "> ");
         }
         writer.write("\n");
         writer.flush();
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   // Печать строкового массива
   static void printArray(String[] str) {
      for (String string : str) {
         System.out.println(string + " -> " + string.length());
      }
   }

   // Метод записи строки в файл (не используется)
   static void stringToFile(String str, String pathnameString) {
      try (FileWriter writer = new FileWriter(pathnameString, true)) {
         writer.write(str.toString() + "\n");
         writer.flush();
      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }
}
