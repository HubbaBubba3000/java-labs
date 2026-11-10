package com.bubnov.main;

import com.bubnov.communication.Name;
import com.bubnov.communication.PhoneBook;
import com.bubnov.math.Point;
import com.bubnov.millitary.Pistol;
import com.bubnov.millitary.SMG;
import com.bubnov.millitary.Sniper;

import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println("Результат возведения в степень: " + power(args[0], args[1]));
        } else {
            System.out.println("Для вычисления степени передайте два аргумента: X Y.");
        }

        demonstratePistol();
        demonstrateName();
        demonstratePhoneBook();
        demonstratePoint();
        demonstrateShooters();
    }

    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }

    private static void demonstratePistol() {
        System.out.println("\nПистолет:");
        Pistol pistol = new Pistol(7);
        pistol.reload(3);
        for (int i = 0; i < 5; i++) {
            pistol.shoot();
        }
        System.out.println("Не поместилось патронов: " + pistol.reload(8));
        pistol.shoot();
        pistol.shoot();
        System.out.println("Разряжено патронов: " + pistol.unload());
        pistol.shoot();
    }

    private static void demonstrateName() {
        System.out.println("\nИмя: " + new Name("Андрей", "Бубнов", null));
        try {
            new Name(" ", null, "");
        } catch (IllegalArgumentException exception) {
            System.out.println("Проверка имени: " + exception.getMessage());
        }
    }

    private static void demonstratePhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addRecord("89003337788", "Вася");
        phoneBook.addRecord("89001112233", "Анна");
        String oldPhone = phoneBook.addRecord("89004445566", "Вася");

        System.out.println("\nТелефонный справочник:\n" + phoneBook);
        System.out.println("Старый телефон Васи: " + oldPhone);
        System.out.println("Имена на «А»: " + Arrays.toString(phoneBook.getNamesContainPart("А")));
    }

    private static void demonstratePoint() {
        Point first = new Point(2, 3);
        Point second = new Point(2, 3);
        System.out.println("\nТочки равны: " + first.equals(second));
    }

    private static void demonstrateShooters() {
        System.out.println("\nСтрелки:");
        new Sniper("Безоружный").shoot();
        new Sniper("С пистолетом", new Pistol(1, 1)).shoot();
        new Sniper("С автоматом", new SMG(2, 2)).shoot();
    }
}
