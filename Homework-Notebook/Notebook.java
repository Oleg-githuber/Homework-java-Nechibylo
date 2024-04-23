import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Notebook {
    private int ram;    // Объём ОЗУ
    private int hdd;    // Объём ЖД
    private String os;  // Операционная система
    private String color;   // Цвет
    private double sceenDiag;   // Диагональ экрана
    private String manufacterName;   // Название производителя
    private String model;       // Наименование модели

    // Конструктор
    public Notebook(int ram, int hdd, String os, String color, double sceenDiag, String manufacterName, String model) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this. color = color;
        this.sceenDiag = sceenDiag;
        this.manufacterName = manufacterName;
        this.model = model;
    }

    // Геттеры
    public int getRAM() {
        return ram;
    }
    public int getHDD() {
        return hdd;
    }
    public String getOS() {
        return os;
    }
    public String getColor() {
        return color;
    }
    public double getScreenDiag() {
        return sceenDiag;
    }
    public String getManufacter() {
        return manufacterName;
    }
    public String getModel() {
        return model;
    }

    // Вывод краткой информации о ноутбуке
    @Override
    public String toString() {
        return manufacterName + " - " + model;
    }

    // Вывод на экран полной информации о ноутбуке
    public void printInfo() {
        System.out.println();
        System.out.println("Ноутбук:");
        System.out.printf("Производитель: %S\n", manufacterName);
        System.out.printf("Модель: %S\n", model);
        System.out.printf("ОЗУ: %d ГБ\n", ram);
        System.out.printf("Объём жёсткого диска: %d ГБ\n", hdd);
        System.out.printf("Операционная система: %S\n", os);
        System.out.printf("Цвет: %S\n", color);
        System.out.printf("Диагональ экрана: %.1f \"\n", sceenDiag);
    }

    // Создание Хеш-кода по параметрам ноутбука
    @Override
    public int hashCode() {
        return Objects.hash(ram, hdd, os, color, sceenDiag, manufacterName, model);
    }

    public Map<Integer, String> createParamMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, Integer.toString(ram));
        map.put(2, Integer.toString(hdd));
        map.put(3, os);
        map.put(4, color);
        map.put(5, Double.toString(sceenDiag));
        map.put(6, manufacterName);
        map.put(7, model);
        return map;
    }

    
    public boolean isInclude(Map<Integer, String> obj) {
        boolean isEqual = true;
        Map<Integer, String> map = createParamMap();
        for (Integer param : obj.keySet()) {
            if ((obj.get(param) != null) && (param !=1) && (param !=2) && (param !=5) && !(obj.get(param).equals(map.get(param)))) {
                isEqual = false;
            }
        }
        // if ((obj.get(3) != null) && (obj.get(3).equals(os)) && 
        // (obj.get(4) != null) && (obj.get(4).equals(color)) && 
        // (obj.get(6) != null) && (obj.get(6).equals(manufacterName)) && 
        // (obj.get(7) != null) && (obj.get(7).equals(model) && 
        // (obj.get(1) != null) && (Integer.parseInt(obj.get(1)) <= ram) && 
        // (obj.get(2) != null) && (Integer.parseInt(obj.get(2)) <= hdd) && 
        // (obj.get(5) != null) && (Double.parseDouble(obj.get(5)) <= sceenDiag)) {
        //     return true;
        // }
        if ((obj.get(1) != null) && (Integer.parseInt(obj.get(1)) > ram)) {
            isEqual = false;
        }
        if ((obj.get(2) != null) && (Integer.parseInt(obj.get(2)) > hdd)) {
            isEqual = false;
        }
        if ((obj.get(5) != null) && (Double.parseDouble(obj.get(5)) > sceenDiag)) {
            isEqual = false;
        }
        return isEqual;
    }
}
