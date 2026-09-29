package tasks;

public class Task3 extends Task {

    public String listNums (int x) {
        if (x < 1) return "Число должно быть больше 0";
        StringBuilder sb = new StringBuilder(x*2);
        for (int i = 1; i <= x; i++) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public String chet (int x) {
        if (x < 1) return "Число должно быть больше 0";
        StringBuilder sb = new StringBuilder(x*2);
        for (int i = 0; i <= x; i+=2) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public int numLen (long x) {
        int len = 0;
        while (x != 0) {
            x /= 10;
            len++;
        }
        return len;
    }

     public void square (int x) {
         for (int i = 1; i <= x; i++) {
             System.out.println("*".repeat(x));
         }
     }

     public void rightTriangle (int x) {
         for (int i = 1; i <= x; i++) {
             System.out.println(" ".repeat(x-i) + "*".repeat(i));
         }
     }

    @Override
    public void main(String[] args) {
        Task3 m = new Task3();
        //3.1
        System.out.println("Введите число: ");
        int x = m._scanner.nextInt();
        System.out.println("Числа до " + x + ": " + m.listNums(x));
        //3.3
        System.out.println("Введите число: ");
        int y = m._scanner.nextInt();
        System.out.println("Четные числа до " + y + ": " + m.chet(y));
        //3.5
        System.out.println("Введите длинное число: ");
        long z = m._scanner.nextLong();
        System.out.println("Длина числа: " + m.numLen(z));
        //3.7
        System.out.println("Введите число(размер квадрата): ");
        int n = m._scanner.nextInt();
        m.square(n);
        //3.9
        System.out.println("Введите число(размер треугольника): ");
        int t = m._scanner.nextInt();
        m.rightTriangle(t);
    }
}
