import java.util.*;

public class ToDoList{
    public static void main(String[] args) {
        toDoRunner();
    }

    static void toDoRunner() {
        int ProgramStart = 0;
        int choose;
        TaskList l = new TaskListImpl();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                if (ProgramStart == 0)
                    System.out.println("Do you want to start a program? Yes = 1, No = 2");
                else
                    System.out.println("Resume? Yes = 1, No = 2");
                System.out.print("Put option: ");
                choose = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("----------\n" + "Your choice is incorrect!");
                continue;
            }
            System.out.println("----------");
            switch (choose) {
                case 1 -> {
                    int t;
                    try {
                        l.showOptions();
                        System.out.println("----------");
                        System.out.print("Put option: ");
                        t = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("your command isn't included");
                        continue;
                    }
                    System.out.println();
                    l.run(t);
                    System.out.println("----------\n");
                    ProgramStart++;
                }
                case 2 -> System.out.println("Thank you!");
            }
            System.out.println();
            if (choose == 2) {
                break;
            }
        }
    }
}