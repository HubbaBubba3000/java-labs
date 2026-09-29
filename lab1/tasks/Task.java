package tasks;

import java.util.Scanner;

// Абстрактный класс для всех задач
abstract public class Task {

    protected Scanner _scanner = new Scanner(System.in);

    abstract public void main(String[] args);
}
