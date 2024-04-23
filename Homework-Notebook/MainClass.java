import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass {
    public static Map<Integer, Integer> ramMap; // ОЗУ
    public static Map<Integer, Integer> hddMap; // объём ЖД
    public static Map<Integer, String> osMap;   // ОС
    public static Map<Integer, String> colorMap;    // Цвет
    public static Map<Integer, Double> screenMap;   // Диаметр экрана
    public static Map<Integer, String> manufacterMap;   // Производитель
    public static Map<String, String> ModelMap;         // Модель
    public static Map<Integer, String> filter;      // Фильтр
    public static Map<Integer, Notebook> notebooks; // Список ноутбуков
    public static Map<Integer, String> parameterMap;    // Параметры для поиска
    public static Map<Integer, Notebook> resultMap;       // Результат поиска



    public static void main(String[] args) {
        // Значения для выбора из списка при фильтрации поиска
        // ОЗУ
        ramMap = new HashMap<>();
        ramMap.put(1, 4);
        ramMap.put(2, 8);
        ramMap.put(3, 16);
        ramMap.put(4, 32);
        // Объём ЖД
        hddMap = new HashMap<>();
        hddMap.put(1, 256);
        hddMap.put(2, 512);
        hddMap.put(3, 1024);
        hddMap.put(4, 2048);
        // Операционная система
        osMap = new HashMap<>();
        osMap.put(1, "Без ОС");
        osMap.put(2, "Dos");
        osMap.put(3, "Windoes");
        osMap.put(4, "Linux");
        // Цвет
        colorMap = new HashMap<>();
        colorMap.put(1, "Чёрный");
        colorMap.put(2, "Белый");
        colorMap.put(3, "Серый");
        colorMap.put(4, "Синий");
        colorMap.put(5, "Красный");
        // Диагональ экрана
        screenMap = new HashMap<>();
        screenMap.put(1, 12.0);
        screenMap.put(2, 14.5);
        screenMap.put(3, 15.0);
        screenMap.put(4, 17.0);
        // Производитель
        manufacterMap = new HashMap<>();
        manufacterMap.put(1, "ASUS");
        manufacterMap.put(2, "ASER");
        manufacterMap.put(3, "LENOVO");
        manufacterMap.put(4, "DEXP");
        // Модели
        ModelMap = new HashMap<>();
        // Модели ASUS
        ModelMap.putIfAbsent("as1827", "ASUS");
        ModelMap.putIfAbsent("as1417", "ASUS");
        ModelMap.putIfAbsent("as2518", "ASUS");
        // Модели ASER
        ModelMap.putIfAbsent("ar243", "ASER");
        ModelMap.putIfAbsent("ar118", "ASER");
        ModelMap.putIfAbsent("ar553", "ASER");
        // Модели LENOVO
        ModelMap.putIfAbsent("l5646", "LENOVO");
        ModelMap.putIfAbsent("l2426", "LENOVO");
        ModelMap.putIfAbsent("l5614", "LENOVO");
        // Модели DEXP
        ModelMap.putIfAbsent("d145", "DEXP");
        ModelMap.putIfAbsent("d314", "DEXP");
        ModelMap.putIfAbsent("d777", "DEXP");
        // HashMap для фильтрации
        filter = new HashMap<>();
        filter.put(0, "Показать все");
        filter.put(1, "ОЗУ");
        filter.put(2, "Объём ЖД");
        filter.put(3, "Операционная система");
        filter.put(4, "Диагональ экрана");
        filter.put(5, "Модель");
        filter.put(6, "Применить параметры");

        notebooks = createNotebookList();   // Создание списка ноутбуков
        parameterMap = new HashMap<>();     // Список параметров
        resultMap = new HashMap<>();        // Результат поиска
        //parameterMap.put(1, "4");
        //printNotebooks();
        selectSearchParameters();
        //printAllNotebooks();
    }

    // Создание списка ноутбуков
    public static Map<Integer, Notebook> createNotebookList() {
        Map<Integer, Notebook> lst = new HashMap<>();
        //notebooks = new HashMap<>();
        Notebook notebook1 = new Notebook(4, 512, "Windows", "Чёрный", 
        14.5, "ASUS", "as1827");
        lst.put(1, notebook1);
        Notebook notebook2 = new Notebook(8, 512, "Windows", "Чёрный", 
        15.0, "ASUS", "as1417");
        lst.put(2, notebook2);
        Notebook notebook3 = new Notebook(32, 1024, "Windows", "Серый", 
        17.0, "ASUS", "as2518");
        lst.put(3, notebook3);

        Notebook notebook4 = new Notebook(8, 512, "Без ОС", "Серый", 
        14.5, "ACER", "ar243");
        lst.put(4, notebook4);
        Notebook notebook5 = new Notebook(16, 512, "Windows", "Чёрный", 
        15.0, "ACER", "ar118");
        lst.put(5, notebook5);
        Notebook notebook6 = new Notebook(32, 2048, "Windows", "Белый", 
        15.0, "ACER", "ar553");
        lst.put(6, notebook6);

        Notebook notebook7 = new Notebook(8, 256, "Dos", "Чёрный", 
        15.0, "LENOVO", "l5646");
        lst.put(7, notebook7);
        Notebook notebook8 = new Notebook(8, 512, "Dos", "Чёрный", 
        17.0, "LENOVO", "l2426");
        lst.put(8, notebook8);
        Notebook notebook9 = new Notebook(16, 512, "Windows", "Серый", 
        15.0, "LENOVO", "l5614");
        lst.put(9, notebook9);

        Notebook notebook10 = new Notebook(4, 256, "Без ОС", "Серый", 
        15.0, "DEXP", "d145");
        lst.put(10, notebook10);
        Notebook notebook11 = new Notebook(4, 256, "Без ОС", "Серый", 
        17.0, "DEXP", "d314");
        lst.put(11, notebook11);
        Notebook notebook12 = new Notebook(8, 512, "Linux", "Чёрный", 
        15.0, "DEXP", "d777");
        lst.put(12, notebook12);
        return lst;
    }


    // Выбрать параметры для поиска
    public static void selectSearchParameters() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        boolean isSetParameters = true;
       while (isSetParameters) {
         System.out.println("Выберите параметры для поиска:");
         for (Integer elem : filter.keySet()) {
             System.out.printf("%d - %s\n", elem, filter.get(elem));
         }
         //Scanner scanner = new Scanner(System.in, "ibm866");
         int paramNumber = Integer.parseInt(scanner.nextLine());
         //scanner.close();
         switch (paramNumber) {
             case 0:
                 printAllNotebooks();
                 isSetParameters = false;
                 break;
             case 1:
                 //parameterMap.put(1, Integer.toString(selectRAM(scanner)));
                 selectRAM();
                 //scanner.reset();
                 //selectSearchParameters();
                 //printNotebooks();;
                 break;
            case 6:
                setResult();
                printNotebooks();
                isSetParameters = false;
                break;
         
             default:
                 break;
         }
       }
       scanner.close();
    }

    // Вывод на экран полного списка ноутбуков
    public static void printAllNotebooks() {
        for (Integer note : notebooks.keySet()) {
            System.out.printf("%d - %s\n", note, notebooks.get(note).toString());
        }
    }

    // Вывод на экран списка ноутбуков
    public static void printNotebooks() {
        for (Integer note : resultMap.keySet()) {
            System.out.printf("%d - %s\n", note, resultMap.get(note).toString());
        }
    }

    public static void setResult() {
        for (Integer note : notebooks.keySet()) {
            int i = 0;
            if (notebooks.get(note).isInclude(parameterMap)) {
                i++;
                resultMap.put(i, notebooks.get(note));
            }
        }
    }

    // Выбор ОЗУ
    public static void selectRAM() {
        System.out.println("Выберите минимальный объём ОЗУ:");
        System.out.println("\n0 - Назад");
        for (Integer num : ramMap.keySet()) {
            System.out.printf("%d - %d ГБ\n", num, ramMap.get(num));
        }
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param = Integer.parseInt(scanner.nextLine());
        if (param == 0) {
            return;
        }
        parameterMap.put(1, Integer.toString(ramMap.get(param)));

    }
}
