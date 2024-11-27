import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        // 1 задание
        // Ввод количества строк
        System.out.print("Введите количество строк: ");
        int n = in.nextInt();
        in.nextLine(); //очищение буфера

        String[] a = new String[n]; // Создание массива строк

        // Заполнение массива элементами
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }
        // 2 задание
        // создание массивов специальных символов
        char [] Symbols2 = {'`', '~', '!', '@', '№', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '{', '[', '}', ']', '|', ':', ';', '<', ',', '.', '>', '?', '/', ' '};
        String [] Symbols = {"`", "~", "!", "@", "№", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "{", "[", "}", "]", "|", ":", ";", "'", "<", ",", ".", ">", "?", "/"};
        // 2 задание
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                String[] arr1 = a[i].split(" "); // разбиение массива на слова по пробелам
                int counter1 = 0; // счётчик слов
                int count1 = 0; // счётчик правильности выполнения условия на спец символы
                for (int k = 0; k < arr1.length; k++) {
                    if (!arr1[k].isEmpty()) {
                        for (int l = 0; l < Symbols2.length; l++) {
                            if (arr1[k].charAt(arr1[k].length() - 1) != Symbols2[l]) // проверка на то, не является ли слово спецсимволом
                                count1++;
                            if (count1 == Symbols2.length) // если слово не спецсимвол - прибавляем к счётчику 1
                                counter1++;
                        }
                    }
                }
                String[] arr2 = a[i + 1].split(" ");
                int counter2 = 0; // счётчик слов
                int count2 = 0; // счётчик правильности выполнения условия на спец символы
                for (int k = 0; k < arr2.length; k++) {
                    if (!arr2[k].isEmpty()) {
                        for (int m = 0; m < Symbols2.length; m++) {
                            if (arr2[k].charAt(arr2[k].length() - 1) != Symbols2[m]) // проверка на то, не является ли слово спецсимволом
                                count2 += 1;
                            if (count2 == Symbols2.length) // если слово не спецсимвол - прибавляем к счётчику 1
                                counter2 += 1;
                        }
                    }
                }
                // если число слов разное - сортируем список
                if (counter1 > counter2) {
                    String z = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = z;
                } else if (counter1 == counter2) {
                    char[] bukva = {'у', 'е', 'ы', 'а', 'о', 'я', 'и', 'э', 'ю', 'ё', 'e', 'u', 'i', 'o', 'a', 'y'}; // список гласных букв
                    int bcounter1 = 0; // счётчики гласных букв
                    int bcounter2 = 0;
                    for (int k = 0; k < a[i].length(); k++) {
                        for (int h = 0; h < bukva.length; h++) {
                            if (bukva[h] == a[i].charAt(k)) { // проверяем на гласность буквы слова
                                bcounter1 += 1;
                            }
                        }
                    }
                    for (int k = 0; k < a[i + 1].length(); k++) {
                        for (int h = 0; h < bukva.length; h++) {
                            if (bukva[h] == a[i + 1].charAt(k)) { // проверка на гласность букв слова
                                bcounter2 += 1;
                            }
                        }
                    }
                    // если число гласных букв разное - сортируем
                    if (bcounter1 > bcounter2) {
                        String z = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = z;
                        // если мы не отсортировали по предыдущим двум признакам - сортируем по длине
                    } else if (bcounter1 == counter2) {
                        if (a[i].length() > a[i + 1].length()) {
                            String z = a[i];
                            a[i] = a[i + 1];
                            a[i + 1] = z;
                        }
                    }
                }
            }
        }
        // вывод отсортированного массива
        for (int i = 0; i < a.length; i++){
            out.println(a[i]);
        }
        out.println("Частые буквы:");
        // 3 задание
        char[] alphabet = new char[59]; // создание массива алфавита латиницы и кириллицы
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i); // заполнение массива латиницей
        }
        for (int i = 0; i < 32; i++) {
            alphabet[26 + i] = (char) ('а' + i); // заполнение массива кириллицей
        }
        alphabet[58] = 'ё'; // добавление буквы ё
        int [] alphabet_count = new int[59]; // создаем пустой массив с индексами букв
        for(int i = 0; i < a.length; i++){
            String s = a[i];
            for(int j = 0; j < s.length(); j++){
                char bukva = s.charAt(j);
                for(int k = 0; k < alphabet.length; k++){ // если символ является буквой из списка на его номер в массиве alphebet_count увеличивается число
                    if(alphabet[k] == bukva){
                        alphabet_count[k] += 1;
                    }
                }
            }
        }
        int max = alphabet_count[0];
        for(int i = 1; i < alphabet_count.length; i++){ // находим номер максимальной буквы
            if(alphabet_count[i] > max){
                max = alphabet_count[i];
            }
        }
        for(int i = 0; i<alphabet_count.length; i++){ // вывод максимальной буквы
            if(alphabet_count[i] == max){
                out.print(alphabet[i] + " ");
            }
        }
        out.println();
        // 4 задание
        int count_p = 0;
        out.println("Палиндромы:"); // Заголовок для вывода палиндромов
        for (int i = 0; i < n; i++) {
            String line = a[i];
            int left = 0;
            int right = line.length() - 1;
            boolean isPalindrome = true; // Флаг для определения палиндрома
            while (left <= right) {
                if (line.charAt(left) != line.charAt(right)) {
                    isPalindrome = false; // Если символы не равны, это не палиндром
                    break; // Выходим из цикла при первом несовпадении
                }
                left++;
                right--;
            }
            if (isPalindrome) { // Если строка палиндром
                out.println(line);// Выводим палиндром
                count_p++;
            }
        }
        if (count_p == 0)
            out.println("нет");
        // задание 5

        String NewLine = "";
        boolean WithSymbol = false;

// Проверяем, заканчивается ли строка на специальный символ
        for (int i = 0; i < a.length; i++) {
            String line  = a[i];
            WithSymbol = false; // Сбрасываем флаг для каждой новой строки
            for (int j = 0; j < Symbols.length; j++) {
                if (line.length() > 0 && line.charAt(line.length() - 1) == Symbols[j].charAt(0)) {
                    WithSymbol = true; // Устанавливаем флаг, если нашли совпадение
                    break;
                }
            }

            // Если строка заканчивается на специальный символ, добавляем её без запятой
            if (WithSymbol) {
                NewLine += line;
            } else {
                // Если не окончена специальным символом, добавляем запятую
                NewLine += line + ",";
            }
        }

// Для подсчета количества слов, игнорируя специальные символы
        int CountWords = 0;
        boolean inWord = false; // Флаг для отслеживания нахождения внутри "слова"
        for (int i = 0; i < NewLine.length(); i++) {
            char currentChar = NewLine.charAt(i);
            boolean isSymbol = false;

            // Проверяем, является ли текущий символ специальным
            for (int h = 0; h < Symbols2.length; h++) {
                if (currentChar == Symbols2[h]) {
                    isSymbol = true; // Найден специальный символ
                    break;
                }
            }

            // Если символ не специальный, проверяем, находимся ли мы внутри слова
            if (!isSymbol) {
                if (!inWord) {
                    CountWords++; // Если мы не были внутри слова, значит, находим новое слово
                    inWord = true; // Устанавливаем флаг, что находимся внутри слова
                }
            } else {
                // Если текущий символ — специальный, сбрасываем флаг
                inWord = false;
            }
        }

// Удаление последней запятой, если она есть
        if (NewLine.endsWith(",")) {
            NewLine = NewLine.substring(0, NewLine.length() - 1);
        }

        out.println("соединенная строка: " + NewLine);
        out.println("количество слов в строке: " + CountWords);

    }
}
