package tasks;

import java.lang.Math;
import java.util.Arrays;

public class Task4 extends Task {
    public int findFirst (int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int maxAbs(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max) {
                max = Math.abs(arr[i]);
            }
        }
        return max;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        System.arraycopy(arr, 0, result, 0, pos);
        System.arraycopy(ins, 0, result, pos, ins.length);
        System.arraycopy(arr, pos, result, pos + ins.length, arr.length - pos);
        return result;
    }

    public int[] reverseBack (int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int v : arr) {
            if (v == x) count++;
        }
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) result[idx++] = i;
        }
        return result;
    }

    private int[] inputArray() {
        String[] tokens = _scanner.nextLine().split(" ");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                arr[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод: " + tokens[i]);
                return null;
            }
        }
        return arr;
    }

    @Override
    public void main(String[] args) {
        //4.1
        System.out.print("Введите элементы массива через пробел: ");
        int[] arr = inputArray();
        if (arr == null) return;
        System.out.print("Введите число для поиска: ");
        int x = _scanner.nextInt();
        _scanner.nextLine();
        int result = findFirst(arr, x);
        System.out.println("Найдено в позиции: " + result);
        //4.3
        System.out.print("Введите элементы массива через пробел: ");
        arr = inputArray();
        if (arr == null) return;
        System.out.println("Максимальное абсолютное значение: " + maxAbs(arr));
        //4.5
        System.out.print("Введите элементы массива через пробел: ");
        arr = inputArray();
        if (arr == null) return;
        System.out.print("Введите элементы массива для вставкичерез пробел: ");
        int[] ins = inputArray();
        if (ins == null) return;
        System.out.print("Введите позицию для вставки: ");
        int pos = _scanner.nextInt();
        _scanner.nextLine();
        arr = add(arr, ins, pos);
        System.out.println("Результат: " + Arrays.toString(arr));
        //4.7
        System.out.print("Введите элементы массива через пробел: ");
        arr = inputArray();
        if (arr == null) return;
        arr = reverseBack(arr);
        System.out.println("Перевернутый массив: " + Arrays.toString(arr));
        //4.9
        System.out.print("Введите элементы массива через пробел: ");
        arr = inputArray();
        if (arr == null) return;
        System.out.print("Введите число для поиска: ");
        x = _scanner.nextInt();
        _scanner.nextLine();
        int[] resultArr = findAll(arr, x);
        System.out.println("Индексы вхождений: " + Arrays.toString(resultArr));
    }
}
