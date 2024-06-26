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
    public static Map<String, String> modelMap;         // Модель
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
        manufacterMap.put(2, "ACER");
        manufacterMap.put(3, "LENOVO");
        manufacterMap.put(4, "DEXP");
        // Модели
        modelMap = new HashMap<>();
        // Модели ASUS
        modelMap.putIfAbsent("as1827", "ASUS");
        modelMap.putIfAbsent("as1417", "ASUS");
        modelMap.putIfAbsent("as2518", "ASUS");
        // Модели ASER
        modelMap.putIfAbsent("ar243", "ACER");
        modelMap.putIfAbsent("ar118", "ACER");
        modelMap.putIfAbsent("ar553", "ACER");
        // Модели LENOVO
        modelMap.putIfAbsent("l5646", "LENOVO");
        modelMap.putIfAbsent("l2426", "LENOVO");
        modelMap.putIfAbsent("l5614", "LENOVO");
        // Модели DEXP
        modelMap.putIfAbsent("d145", "DEXP");
        modelMap.putIfAbsent("d314", "DEXP");
        modelMap.putIfAbsent("d777", "DEXP");
        // HashMap для фильтрации
        filter = new HashMap<>();
        filter.put(0, "Показать все");
        filter.put(1, "ОЗУ");
        filter.put(2, "Объём ЖД");
        filter.put(3, "Операционная система");
        filter.put(4, "Цвет");
        filter.put(5, "Диагональ экрана");
        filter.put(6, "Модель");
        filter.put(7, "Применить параметры");
        filter.put(8, "Завершить программу");

        notebooks = createNotebookList();   // Создание списка ноутбуков
        parameterMap = new HashMap<>();     // Список параметров
        resultMap = new HashMap<>();        // Результат поиска
        selectSearchParameters();           // Применить параметры фильтра
        //printAllParameters();           // Вывод всех параметров выбранного ноутбука
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
        System.out.println();
        Scanner scanner = new Scanner(System.in, "ibm866");
       while (true) {    // Цикл для примения нескольких фильтров
         System.out.println("Введите цифру, соответствующую выбранному параметру:");
         // Перечень параметров
         for (Integer elem : filter.keySet()) {
             System.out.printf("%d - %s\n", elem, filter.get(elem));
         }
         int paramNumber = Integer.parseInt(scanner.nextLine());
         switch (paramNumber) {
             case 0:
                 printAllNotebooks();   // Вывод списка всех созданных ноутбуков
                 printAllParameters(paramNumber);           // Вывод всех параметров выбранного ноутбука
                 break;
             case 1:
                 selectRAM();   // Фильтрация по параметру ОЗУ
                 break;
            case 2:
                selectHDD();    // Фильтрация по объёму ЖД
                break;
            case 3:
                selectOS(); // Фильрация по ОС
                break;
            case 4:
                selectColor();  // Фильтрация по цвету
                break;
            case 5:
                selectScreenDiag(); // Фильтрация по диагонали экрана
                break;
            case 6:
                selectManufacter();     // Фильтрация по производителю и модели
                break;
            case 7:
                setResult();        // Применение результатов в новом HashMap
                printNotebooks();   // Вывод отфильтрованного перечня ноутбуков
                break;
            case 8:
                return;         // Завершение программы
         
             default:
                 break;
         }
       }
    }

    // Вывод на экран полного списка ноутбуков
    public static void printAllNotebooks() {
        System.out.println();
        System.out.println("Список всех ноутбуков");
        for (Integer note : notebooks.keySet()) {
            System.out.printf("%d - %s\n", note, notebooks.get(note).toString());
        }
    }

    // Вывод на экран списка ноутбуков
    public static void printNotebooks() {
        System.out.println();
        if (!resultMap.isEmpty()) {
            System.out.println("Список ноутбуков по выбранным параметрам:");
            for (Integer note : resultMap.keySet()) {
                System.out.printf("%d - %s\n", note, resultMap.get(note).toString());
            }
            printAllParameters(7);           // Вывод всех параметров выбранного ноутбука
        } else {
            System.out.println("По выбранным параметрам ноутбуков не найдено\n");
        }
    }

    // Добавление ноутбуков, соответствующих фильтру, в новый HashMap
    public static void setResult() {
        resultMap.clear();
        Integer i = 0;
        for (Integer note : notebooks.keySet()) {
            if (notebooks.get(note).isInclude(parameterMap)) {
                resultMap.put(++i, notebooks.get(note));
            }
        }
    }

    // Выбор ОЗУ
    public static void selectRAM() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param;
        do {
            System.out.println();
            System.out.println("Введите цифру, соответствующую минимальному объёму ОЗУ:");
            System.out.println("\n0 - Назад");
            for (Integer num : ramMap.keySet()) {
                System.out.printf("%d - %d ГБ\n", num, ramMap.get(num));
            }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                return;
            }
        } while (param > ramMap.size());
        parameterMap.put(1, Integer.toString(ramMap.get(param)));
    }

    // Выбор Объёма жёсткого диска
    public static void selectHDD() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param;
        do {
            System.out.println();
            System.out.println("Введите цифру, соответствующую минимальному объёму ЖД:");
            System.out.println("\n0 - Назад");
            for (Integer num : hddMap.keySet()) {
                System.out.printf("%d - %d ГБ\n", num, hddMap.get(num));
            }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                return;
            }
            parameterMap.put(2, Integer.toString(hddMap.get(param)));
        } while (param > hddMap.size());
    }

    // Выбор ОС
    public static void selectOS() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param;
        do {
            System.out.println();
            System.out.println("Введите цифру, соответствующую операционной системе:");
            System.out.println("\n0 - Назад");
            for (Integer num : osMap.keySet()) {
                System.out.printf("%d - %s\n", num, osMap.get(num));
             }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                 return;
            }
        } while (param > osMap.size());
        parameterMap.put(3, osMap.get(param));
    }

    // Выбор цвета
    public static void selectColor() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param;
        do {
            System.out.println();
            System.out.println("Введите цифру, соответствующую цвету:");
            System.out.println("\n0 - Назад");
            for (Integer num : colorMap.keySet()) {
                System.out.printf("%d - %s\n", num, colorMap.get(num));
            }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                return;
            }
        } while (param > colorMap.size());
        parameterMap.put(4, colorMap.get(param));
    }

    // Выбор диагонали экрана
    public static void selectScreenDiag() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param;
        do {
            System.out.println();
            System.out.println("Введите цифру, соответствующую минимальной диагонали экрана:");
            System.out.println("\n0 - Назад");
            for (Integer num : screenMap.keySet()) {
                System.out.printf("%d - %f \"\n", num, screenMap.get(num));
            }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                return;
            }
        } while (param > screenMap.size());
        parameterMap.put(5, Double.toString(screenMap.get(param)));
    }

    // Выбор Производителя
    public static void selectManufacter() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        int param;
        do {
            System.out.println();
            System.out.println("Введите цифру, соответствующую производителю:");
            System.out.println("\n0 - Назад");
            for (Integer num : manufacterMap.keySet()) {
                System.out.printf("%d - %s\n", num, manufacterMap.get(num));
            }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                return;
            }
        } while (param > manufacterMap.size());
        parameterMap.put(6, manufacterMap.get(param));
        selectModel();
    }

    // Выбор модели
    public static void selectModel() {
        Scanner scanner = new Scanner(System.in, "ibm866");
        System.out.println();
        Map<Integer, String> newMap = new HashMap<>();
        int i = 0;
        int param;
        do {
            System.out.println("Введите цифру, соответствующую модели:");
            System.out.println("\n0 - Назад");
            for (String model : modelMap.keySet()) {
                if (modelMap.get(model).equals(parameterMap.get(6))) {
                    newMap.put(++i, model);
                    System.out.printf("%d - %s\n", i, model);
                }
            }
            param = Integer.parseInt(scanner.nextLine());
            if (param == 0) {
                return;
            }
        } while (param > modelMap.size());
        parameterMap.put(7, newMap.get(param));
    }

    // Вывод полного списка параметров выбранного ноутбука
    public static void printAllParameters(int paramNumber) {
        Scanner scanner = new Scanner(System.in, "ibm866");
        if (paramNumber == 7) {
            while (true) {
                System.out.println();
                System.out.println("Введите номер ноутбука из указанного списка для просмотра параметров:");
                System.out.println("0 - Назад");
                for (Integer note : resultMap.keySet()) {
                    System.out.printf("%d - %s\n", note, resultMap.get(note).toString());
                }
                int number = Integer.parseInt(scanner.nextLine());
                if (number == 0) {
                    return;
                }
                resultMap.get(number).printInfo();
            }
        } else if (paramNumber == 0) {
            while (true) {
                System.out.println();
                System.out.println("Введите номер ноутбука из указанного списка для просмотра параметров:");
                System.out.println("0 - Назад");
                for (Integer note : notebooks.keySet()) {
                    System.out.printf("%d - %s\n", note, notebooks.get(note).toString());
                }
                int number = Integer.parseInt(scanner.nextLine());
                if (number == 0) {
                    return;
                }
                notebooks.get(number).printInfo();
            }
        }
        
    }
}
