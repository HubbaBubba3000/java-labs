
public class Main {

    public static void printHumanHeights() {
        System.out.println("============Задача 1.2===========");
        final Human p = new Human("Пушкин", 167);
        final Human k = new Human("Клеопатра",152);
        final Human v = new Human("Владимир", 189);
        System.out.println(k);
        System.out.println(p);
        System.out.println(v);
    }

    public static void manageEmploees() {
        System.out.println("============Задача 2.4 и 3.4===========");

        Emploee k = new Emploee("Козлова");
        Section it = new Section("IT", k);
        Emploee p = new Emploee("Петрова", it);
        Emploee s = new Emploee("Сидорова", it);
        System.out.println(p);
        System.out.println(k);
        System.out.println(s);
        System.out.println(p.section.getEmploeesList()); // выводим список от лица петровой
    }
    public static void naming() {
        System.out.println("============Задача 1.3 и 4.5===========");
        Name c = new Name("Клеопатра");
        Name p = new Name("Александр", "Пушкин", "Сергеевич");
        Name m = new Name("Владимир", "Маяковский");
        Name k = new Name("Христофор", "Бонифатьевич");
        System.out.println(c);
        System.out.println(p);
        System.out.println(m);
        System.out.println(k);
    }
    public static void shooting() {
        System.out.println("============Задача 5.1===========");
        Pistol p = new Pistol(3);
        for(int i=1;i<=5;i++)
            p.shoot();
    }

    public static void main(String[] args) {

        printHumanHeights();
        manageEmploees();
        naming();
        shooting();
    }
}
