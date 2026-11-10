import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bubnov.communication.Name;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static String askString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int askInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Ожидается целое число, попробуйте ещё раз.");
            }
        }
    }

    // ---------- Задача 1.2 ----------

    public static void printHumanHeights() {
        System.out.println("============Задача 1.2===========");
        int n = askInt("Сколько людей ввести? ");
        List<Human> humans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String name = askString("Имя человека #" + i + ": ");
            int height = askInt("Рост (см) человека #" + i + ": ");
            humans.add(new Human(name, height));
        }
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    // ---------- Задача 2.4 и 3.4 ----------

    public static void manageEmploees() {
        System.out.println("============Задача 2.4 и 3.4===========");

        String sectionName = askString("Название отдела: ");
        String leaderName  = askString("Имя начальника отдела: ");

        Emploee leader = new Emploee(leaderName);
        Section it     = new Section(sectionName, leader);

        int n = askInt("Сколько сотрудников добавить (не считая начальника)? ");
        List<Emploee> employees = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String empName = askString("Имя сотрудника #" + i + ": ");
            employees.add(new Emploee(empName, it));
        }

        System.out.println();
        System.out.println(leader);
        for (Emploee e : employees) {
            System.out.println(e);
        }

        // Список отдела от лица первого добавленного сотрудника
        if (!employees.isEmpty()) {
            System.out.println(employees.get(0).section.getEmploeesList());
        }
    }

    // ---------- Задача 1.3 и 4.5 ----------

    public static void naming() {
        System.out.println("============Задача 1.3 и 4.5===========");
        int n = askInt("Сколько имён ввести? ");
        List<Name> names = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("--- Имя #" + i + " ---");
            String firstName  = askString("Личное имя (обязательно): ");
            String lastName   = askString("Фамилия (Enter — пропустить): ");
            String patronymic = askString("Отчество (Enter — пропустить): ");

            Name name;
            if (lastName.isEmpty() && patronymic.isEmpty()) {
                name = new Name(firstName);
            } else if (patronymic.isEmpty()) {
                name = new Name(firstName, lastName);
            } else {
                name = new Name(firstName,
                                lastName.isEmpty() ? null : lastName,
                                patronymic);
            }
            names.add(name);
        }

        for (Name name : names) {
            System.out.println(name);
        }
    }

    // ---------- Задача 5.1 ----------

    public static void shooting() {
        System.out.println("============Задача 5.1===========");

        System.out.print("Начальное количество патронов (Enter — по умолчанию 5): ");
        String s = sc.nextLine().trim();
        Pistol pistol;
        if (s.isEmpty()) {
            pistol = new Pistol();
        } else {
            try {
                pistol = new Pistol(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод — использую значение по умолчанию (5).");
                pistol = new Pistol();
            }
        }

        int shots = askInt("Сколько раз выстрелить? ");
        for (int i = 1; i <= shots; i++) {
            System.out.print("Выстрел " + i + ": ");
            pistol.shoot();
        }
        System.out.println("Осталось патронов: " + pistol.getBullets());
    }

    // ---------- Точка входа ----------

    public static void main(String[] args) {
        // printHumanHeights();
        manageEmploees();
        // naming();
        // shooting();
    }
}
