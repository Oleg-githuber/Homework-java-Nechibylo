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
        return "Модель: " + manufacterName + " - " + model;
    }

    // Вывод на экран полной информации о ноутбуке
    public void printInfo() {
        System.out.println("Ноутбук:");
        System.out.printf("Производитель: %S\n", manufacterName);
        System.out.printf("Модель: %S\n", model);
        System.out.printf("ОЗУ: %d\n ГБ", ram);
        System.out.printf("Объём жёсткого диска: %d\n ГБ", hdd);
        System.out.printf("Операционная система: %S\n", os);
        System.out.printf("Цвет: %S\n", color);
        System.out.printf("Диагональ экрана: %S\n \"", color);
    }

    // Создание Хеш-кода по параметрам ноутбука
    @Override
    public int hashCode() {
        return Objects.hash(ram, hdd, os, color, sceenDiag, manufacterName, model);
    }
}
