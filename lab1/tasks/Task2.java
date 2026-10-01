package tasks;

public class Task2 extends Task {

    public int abs(int x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }
    public double safeDiv(int x, int y) {
        if (y == 0) {
            System.out.println("на 0 делить нельзя");
            return 0;
        }
        return x/y;
    }
    public boolean is35(int x) {
        if (x % 3 == 0 && x % 5 == 0) {
            return false;
        }
        if (x%3 == 0 || x % 5 == 0) {
            return true;
        }
        return false;
        // return (x % 3 == 0 ^ x % 5 == 0);
    }

    public int max3 (int x, int y, int z) {
        if (x >= y && x >= z) {
            return x;
        }
        if (y >= x && y >= z) {
            return y;
        }
        return z;
    }
    public int sum2 (int x, int y) {
        if (x+y >= 10 && x+y <= 19) {
            return 20;
        }
        return x+y;
    }
    public String day(int x) {
        return switch (x) {
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            case 7 -> "воскресенье";
            default -> "не день недели";
        };
    }

    @Override
    public void main(String[] args) {
        Task2 m = new Task2();
        // 2.1
        System.out.print("введите целое число: ");
        int mod = m._scanner.nextInt();
        System.out.println("модуль: "+m.abs(mod));
        //2.3
        System.out.print("введите целое число: ");
        int num = m._scanner.nextInt();
        System.out.println("число " + num + " " + (m.is35(num) ? "делится на 3 или 5" : "не делится на 3 или 5"));
        // 2.5
        System.out.print("введите 3 числа: ");
        int x = m._scanner.nextInt();
        int y = m._scanner.nextInt();
        int z = m._scanner.nextInt();
        System.out.println("наибольшее: " + m.max3(x,y,z));
        // 2.7
        System.out.print("введите 2 числа: ");
        x = m._scanner.nextInt();
        y = m._scanner.nextInt();
        System.out.println("сумма: "+m.sum2(x,y));
        //2.9
        System.out.print("введите день недели: ");
        int day = m._scanner.nextInt();
        System.out.println("день недели: "+m.day(day));
    }
}
