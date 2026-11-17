package com.bubnov.main;

import com.bubnov.communication.Name;
import com.bubnov.communication.PhoneBook;
import com.bubnov.math.Point;
import com.bubnov.millitary.Pistol;
import com.bubnov.millitary.SMG;
import com.bubnov.millitary.Sniper;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PhoneBook PHONE_BOOK = new PhoneBook();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в лабораторную работу №3!");
        System.out.println("Выберите действие и введите свои данные.");

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
        System.out.println("1 — Возвести число в степень");
        System.out.println("2 — Создать и вывести имя");
        System.out.println("3 — Сравнить две точки");
        System.out.println("4 — Проверить работу пистолета");
        System.out.println("5 — Проверить работу автомата");
        System.out.println("6 — Проверить работу стрелка");
        System.out.println("7 — Телефонная книга");
        System.out.println("0 — Выход");
    }

    private static void runChoice(int choice) {
        switch (choice) {
            case 1:
                demonstratePower();
                break;
            case 2:
                demonstrateName();
                break;
            case 3:
                demonstratePoints();
                break;
            case 4:
                demonstratePistol();
                break;
            case 5:
                demonstrateSmg();
                break;
            case 6:
                demonstrateSniper();
                break;
            case 7:
                phoneBookMenu();
                break;
            case 0:
                break;
            default:
                System.out.println("Такого пункта нет. Выберите число от 0 до 7.");
        }
    }

    private static void demonstratePower() {
        int base = readInt("Введите основание степени: ");
        int exponent = readInt("Введите показатель степени: ");
        System.out.println("Результат: " + Math.pow(base, exponent));
    }

    private static void demonstrateName() {
        String firstName = readOptionalLine("Введите имя (можно оставить пустым): ");
        String lastName = readOptionalLine("Введите фамилию (можно оставить пустым): ");
        String patronymic = readOptionalLine("Введите отчество (можно оставить пустым): ");
        System.out.println("Полное имя: " + new Name(firstName, lastName, patronymic));
    }

    private static void demonstratePoints() {
        System.out.println("Первая точка:");
        Point first = readPoint();
        System.out.println("Вторая точка:");
        Point second = readPoint();
        System.out.println("Первая точка: " + first);
        System.out.println("Вторая точка: " + second);
        System.out.println("Точки равны: " + first.equals(second));
    }

    private static Point readPoint() {
        return new Point(readInt("Координата X: "), readInt("Координата Y: "));
    }

    private static void demonstratePistol() {
        int capacity = readPositiveInt("Введите вместимость магазина: ");
        int bullets = readIntInRange("Введите начальное число патронов: ", 0, capacity);
        Pistol pistol = new Pistol(capacity, bullets);
        System.out.println("Статус: " + pistol.getStoreStatus());

        int toLoad = readNonNegativeInt("Сколько патронов добавить: ");
        System.out.println("Не поместилось патронов: " + pistol.reload(toLoad));
        System.out.println("Статус: " + pistol.getStoreStatus());

        int shots = readNonNegativeInt("Сколько раз выстрелить: ");
        for (int index = 0; index < shots; index++) {
            pistol.shoot();
        }
        System.out.println("Статус после выстрелов: " + pistol.getStoreStatus());
        System.out.println("Извлечено патронов: " + pistol.unload());
    }

    private static void demonstrateSmg() {
        int capacity = readPositiveInt("Введите вместимость магазина: ");
        int fireRate = readPositiveInt("Введите скорострельность (выстрелов за очередь): ");
        SMG smg = new SMG(capacity, fireRate);
        System.out.println("Автомат заряжен: " + smg.getStoreStatus());
        int seconds = readNonNegativeInt("Сколько очередей выпустить: ");
        smg.shootForSeconds(seconds);
        System.out.println("Статус после стрельбы: " + smg.getStoreStatus());
    }

    private static void demonstrateSniper() {
        String name = readRequiredLine("Введите имя стрелка: ");
        System.out.println("1 — без оружия; 2 — с пистолетом; 3 — с автоматом");
        int weaponChoice = readInt("Выберите оружие: ");
        Sniper sniper;
        switch (weaponChoice) {
            case 1:
                sniper = new Sniper(name);
                break;
            case 2:
                int pistolCapacity = readPositiveInt("Вместимость пистолета: ");
                sniper = new Sniper(name, new Pistol(pistolCapacity,
                        readIntInRange("Патронов в пистолете: ", 0, pistolCapacity)));
                break;
            case 3:
                sniper = new Sniper(name, new SMG(readPositiveInt("Вместимость автомата: "),
                        readPositiveInt("Скорострельность автомата: ")));
                break;
            default:
                System.out.println("Такого оружия нет.");
                return;
        }
        System.out.println("Стреляет " + sniper.getName() + ":");
        sniper.shoot();
    }

    private static void phoneBookMenu() {
        int choice;
        do {
            System.out.println("--- Телефонная книга ---");
            System.out.println("1 — добавить или изменить контакт");
            System.out.println("2 — найти телефон по имени");
            System.out.println("3 — удалить контакт");
            System.out.println("4 — найти имена по началу");
            System.out.println("5 — показать все контакты");
            System.out.println("0 — назад в главное меню");
            choice = readInt("Выберите пункт: ");

            switch (choice) {
                case 1:
                    String name = readRequiredLine("Введите имя: ");
                    String phone = readRequiredLine("Введите телефон: ");
                    String oldPhone = PHONE_BOOK.addRecord(phone, name);
                    System.out.println(oldPhone == null ? "Контакт добавлен." : "Контакт обновлён. Старый телефон: " + oldPhone);
                    break;
                case 2:
                    String searchName = readRequiredLine("Введите имя: ");
                    String foundPhone = PHONE_BOOK.getPhone(searchName);
                    System.out.println(foundPhone == null ? "Контакт не найден." : "Телефон: " + foundPhone);
                    break;
                case 3:
                    String removeName = readRequiredLine("Введите имя: ");
                    String removedPhone = PHONE_BOOK.removeByName(removeName);
                    System.out.println(removedPhone == null ? "Контакт не найден." : "Удалён телефон: " + removedPhone);
                    break;
                case 4:
                    String part = readOptionalLine("Введите начало имени: ");
                    System.out.println("Найдены: " + Arrays.toString(PHONE_BOOK.getNamesContainPart(part)));
                    break;
                case 5:
                    if (PHONE_BOOK.getCount() == 0) {
                        System.out.println("Телефонная книга пока пуста.");
                    } else {
                        System.out.println(PHONE_BOOK);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Такого пункта нет.");
            }
        } while (choice != 0);
    }

    private static int readPositiveInt(String message) {
        int value;
        do {
            value = readInt(message);
            if (value <= 0) {
                System.out.println("Введите положительное число.");
            }
        } while (value <= 0);
        return value;
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

    private static int readIntInRange(String message, int minimum, int maximum) {
        int value;
        do {
            value = readInt(message);
            if (value < minimum || value > maximum) {
                System.out.println("Введите число от " + minimum + " до " + maximum + ".");
            }
        } while (value < minimum || value > maximum);
        return value;
    }

    private static int readInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(readLine(message));
            } catch (NumberFormatException exception) {
                System.out.println("Это не целое число. Повторите ввод.");
            }
        }
    }

    private static String readRequiredLine(String message) {
        while (true) {
            String value = readLine(message);
            if (!value.isBlank()) {
                return value;
            }
            System.out.println("Значение не должно быть пустым.");
        }
    }

    private static String readOptionalLine(String message) {
        String value = readLine(message);
        return value.isBlank() ? null : value;
    }

    private static String readLine(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }
}
