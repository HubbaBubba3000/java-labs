import tasks.*;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Task> tasks = List.of(
            new Task1(),
            new Task2(),
            new Task3(),
            new Task4()
        );
        if (args.length == 0) {
            System.out.println("выполение всех задач по очереди\n====================");
            for (Task task : tasks) {
                task.main(args);
            }
            return;
        }
        tasks.get(Integer.parseInt(args[0])-1).main(args);
    }
}
