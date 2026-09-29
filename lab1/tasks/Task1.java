package tasks;

public class Task1 extends Task {

    public float fraction(double x) {
        return (float)(x - (int)x);
    }

    public int charToNum(char x) {
        if (x < 48 || x > 57) {
            System.out.println("ошибка: символ не является числом");
            return -1;
        }
        return (int)x - 48;
    }

    public boolean is2Digits(int x) {
        return (x > 9) && (x<100);
    }
    public boolean isInRange(int a, int b, int num) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        return (a <= num) && (num >= b);
    }
    public boolean isEqual(int a, int b, int c) {
        return (a == b) && (b == c);
    }
    @Override
    public void main(String[] args) {
        Task1 m = new Task1();
        //1.1
        System.out.print("введите дробное число: ");
        double frac = m._scanner.nextDouble();
        System.out.println(m.fraction(frac));
        // 1.3
        System.out.print("введите число(символ): ");
        char ch = m._scanner.next().charAt(0);
        System.out.println(m.charToNum(ch));
        // 1.5
        System.out.print("введите любое целое число: ");
        int number = m._scanner.nextInt();
        String not = !m.is2Digits(number) ? "не" : " ";
        System.out.println(String.format("число %sдвухзначное", not));
        //1.7
        System.out.print("введите число a: ");
        int a = m._scanner.nextInt();
        System.out.print("введите число b: ");
        int b = m._scanner.nextInt();
        System.out.print("введите число между ними: ");
        number = m._scanner.nextInt();
        not = m.isInRange(a,b,number) ? "не" : "";
        System.out.println(String.format("число %s в диапазоне!", not));
        //1.9
        System.out.print("введите число a: ");
        a = m._scanner.nextInt();
        System.out.print("введите число b: ");
        b = m._scanner.nextInt();
        System.out.print("введите число c: ");
        int c = m._scanner.nextInt();
        if (m.isEqual(a,b,c)) {
            System.out.println("все числа равны");
        } else {
            System.out.println("числа не равны");
        }
    }
}
