import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в лабораторную работу №4!");
        System.out.println("Здесь можно проверить все задания на своих данных.");

        int choice;
        do {
            printMenu();
            choice = readInt("Выберите пункт: ");
            try {
                runChoice(choice);
            } catch (RuntimeException exception) {
                System.out.println("Не удалось выполнить операцию: " + exception.getMessage());
            }
            System.out.println();
        } while (choice != 0);

        System.out.println("Спасибо за проверку. До свидания!");
    }

    private static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("1 — Коробка: положить, прочитать и извлечь значение");
        System.out.println("2 — Сравнимое: сравнить длину введённой строки");
        System.out.println("3 — Найти максимум среди коробок с числами");
        System.out.println("4 — Преобразовать список (map)");
        System.out.println("5 — Отфильтровать список (filter)");
        System.out.println("6 — Свернуть список в одно значение (reduce)");
        System.out.println("7 — Собрать значения в новую коллекцию (collect)");
        System.out.println("0 — Выход");
    }

    private static void runChoice(int choice) {
        switch (choice) {
            case 1:
                demonstrateBox();
                break;
            case 2:
                demonstrateComparable();
                break;
            case 3:
                demonstrateMaxBox();
                break;
            case 4:
                demonstrateMap();
                break;
            case 5:
                demonstrateFilter();
                break;
            case 6:
                demonstrateReduce();
                break;
            case 7:
                demonstrateCollect();
                break;
            case 0:
                break;
            default:
                System.out.println("Такого пункта нет. Выберите число от 0 до 7.");
        }
    }

    private static void demonstrateBox() {
        int number = readInt("Введите целое число для коробки: ");
        Box<Integer> box = new Box<>();
        box.push(number);
        System.out.println("Читаем через get(), коробка остаётся заполненной: " + box.get());
        System.out.println("Коробка заполнена: " + box.isFull());
        System.out.println("Извлекаем через pop(): " + box.pop());
        System.out.println("Коробка заполнена после pop(): " + box.isFull());
    }

    private static void demonstrateComparable() {
        String text = readLine("Введите строку: ");
        Comparable<String> stringLength = value -> value.length();
        System.out.println("Длина строки «" + text + "»: " + stringLength.compare(text));
    }

    private static void demonstrateMaxBox() {
        List<Double> numbers = readDoubleList();
        List<Box<? extends Number>> boxes = new ArrayList<>();
        for (Double number : numbers) {
            Box<Double> box = new Box<>();
            box.push(number);
            boxes.add(box);
        }
        System.out.println("Максимальное значение: " + CollectionUtils.maxBox(boxes));
        System.out.println("При поиске максимума коробки только читаются и остаются заполненными: "
                + boxes.get(0).isFull());
    }

    private static void demonstrateMap() {
        System.out.println("1 — длины строк; 2 — модули целых чисел; 3 — максимумы массивов");
        int mode = readInt("Выберите преобразование: ");
        switch (mode) {
            case 1:
                System.out.println("Результат: " + CollectionUtils.map(readStringList(), String::length));
                break;
            case 2:
                System.out.println("Результат: " + CollectionUtils.map(readIntegerList(), Math::abs));
                break;
            case 3:
                List<int[]> arrays = readIntArrays();
                System.out.println("Результат: " + CollectionUtils.map(arrays, Main::maxInArray));
                break;
            default:
                System.out.println("Такого преобразования нет.");
        }
    }

    private static void demonstrateFilter() {
        System.out.println("1 — строки длиной не менее 3; 2 — положительные числа; 3 — массивы без положительных чисел");
        int mode = readInt("Выберите фильтр: ");
        switch (mode) {
            case 1:
                System.out.println("Результат: " + CollectionUtils.filter(readStringList(), value -> value.length() >= 3));
                break;
            case 2:
                System.out.println("Результат: " + CollectionUtils.filter(readIntegerList(), value -> value > 0));
                break;
            case 3:
                List<int[]> arrays = CollectionUtils.filter(readIntArrays(), Main::hasNoPositiveValues);
                System.out.println("Подходящих массивов: " + arrays.size());
                printArrays(arrays);
                break;
            default:
                System.out.println("Такого фильтра нет.");
        }
    }

    private static void demonstrateReduce() {
        System.out.println("1 — объединить строки; 2 — найти сумму чисел; 3 — посчитать элементы во вложенных списках");
        int mode = readInt("Выберите свёртку: ");
        switch (mode) {
            case 1:
                System.out.println("Результат: " + CollectionUtils.reduce(readStringList(), (a, b) -> a + b, ""));
                break;
            case 2:
                System.out.println("Сумма: " + CollectionUtils.reduce(readIntegerList(), Integer::sum, 0));
                break;
            case 3:
                List<List<Integer>> lists = readNestedIntegerLists();
                List<Integer> sizes = CollectionUtils.map(lists, List::size);
                System.out.println("Общее число элементов: " + CollectionUtils.reduce(sizes, Integer::sum, 0));
                break;
            default:
                System.out.println("Такой свёртки нет.");
        }
    }

    private static void demonstrateCollect() {
        System.out.println("1 — разделить числа по знаку; 2 — сгруппировать строки по длине; 3 — удалить повторы строк");
        int mode = readInt("Выберите способ сбора: ");
        switch (mode) {
            case 1:
                Map<Boolean, List<Integer>> bySign = CollectionUtils.collect(
                        readIntegerList(), HashMap::new,
                        (result, value) -> result.computeIfAbsent(value > 0, key -> new ArrayList<>()).add(value));
                System.out.println("Положительные: " + bySign.getOrDefault(true, new ArrayList<>()));
                System.out.println("Отрицательные и ноль: " + bySign.getOrDefault(false, new ArrayList<>()));
                break;
            case 2:
                Map<Integer, List<String>> byLength = CollectionUtils.collect(
                        readStringList(), HashMap::new,
                        (result, value) -> result.computeIfAbsent(value.length(), key -> new ArrayList<>()).add(value));
                System.out.println("Строки, сгруппированные по длине: " + byLength);
                break;
            case 3:
                Set<String> uniqueValues = CollectionUtils.collect(readStringList(), HashSet::new, Set::add);
                System.out.println("Уникальные строки: " + uniqueValues);
                break;
            default:
                System.out.println("Такого способа сбора нет.");
        }
    }

    private static List<String> readStringList() {
        int count = readNonNegativeInt("Сколько значений хотите ввести: ");
        List<String> values = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            values.add(readLine("Строка " + (index + 1) + ": "));
        }
        return values;
    }

    private static List<Integer> readIntegerList() {
        int count = readNonNegativeInt("Сколько чисел хотите ввести: ");
        List<Integer> values = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            values.add(readInt("Число " + (index + 1) + ": "));
        }
        return values;
    }

    private static List<Double> readDoubleList() {
        int count;
        do {
            count = readInt("Сколько чисел хотите поместить в коробки: ");
            if (count <= 0) {
                System.out.println("Нужно ввести хотя бы одно число.");
            }
        } while (count <= 0);

        List<Double> values = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            values.add(readDouble("Число " + (index + 1) + ": "));
        }
        return values;
    }

    private static List<int[]> readIntArrays() {
        int count = readNonNegativeInt("Сколько массивов хотите ввести: ");
        List<int[]> arrays = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            System.out.println("Массив " + (index + 1) + ":");
            List<Integer> values = readIntegerList();
            int[] array = new int[values.size()];
            for (int valueIndex = 0; valueIndex < values.size(); valueIndex++) {
                array[valueIndex] = values.get(valueIndex);
            }
            arrays.add(array);
        }
        return arrays;
    }

    private static List<List<Integer>> readNestedIntegerLists() {
        int count = readNonNegativeInt("Сколько вложенных списков хотите ввести: ");
        List<List<Integer>> lists = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            System.out.println("Вложенный список " + (index + 1) + ":");
            lists.add(readIntegerList());
        }
        return lists;
    }

    private static int maxInArray(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Нельзя найти максимум в пустом массиве");
        }
        int maximum = values[0];
        for (int value : values) {
            maximum = Math.max(maximum, value);
        }
        return maximum;
    }

    private static boolean hasNoPositiveValues(int[] values) {
        for (int value : values) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

    private static void printArrays(List<int[]> arrays) {
        for (int index = 0; index < arrays.size(); index++) {
            System.out.print("Массив " + (index + 1) + ": [");
            for (int valueIndex = 0; valueIndex < arrays.get(index).length; valueIndex++) {
                if (valueIndex > 0) {
                    System.out.print(", ");
                }
                System.out.print(arrays.get(index)[valueIndex]);
            }
            System.out.println("]");
        }
    }

    private static int readNonNegativeInt(String message) {
        int value;
        do {
            value = readInt(message);
            if (value < 0) {
                System.out.println("Введите неотрицательное число.");
            }
        } while (value < 0);
        return value;
    }

    private static int readInt(String message) {
        while (true) {
            String input = readLine(message);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Это не целое число. Повторите ввод.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            String input = readLine(message).replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println("Это не число. Повторите ввод.");
            }
        }
    }

    private static String readLine(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }
}
