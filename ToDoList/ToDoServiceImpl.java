import java.util.*;

public class ToDoServiceImpl implements ToDoService{
    private final List<String> list = new ArrayList<>();
    private final Map<String, String> map = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addTask() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        map.put(title, text);
        list.add(title);
        System.out.println("Task added successfully!");
    }

    public void removeTask() {
        System.out.println("Current tasks:");
        showList();
        System.out.print("Enter the index of the task to remove: ");
        int index = scanner.nextInt();
        if (index >= 1 && index <= list.size()) {
            String title = list.get(index - 1);
            list.remove(index - 1);
            map.remove(title);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void taskShowList() {
        System.out.println("Current tasks:");
        showList();
        System.out.print("Do you want to view a task's details? (1 = Yes, 2 = No): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Enter the index of the task: ");
            int index = scanner.nextInt();
            if (index >= 1 && index <= list.size()) {
                String title = list.get(index - 1);
                String text = map.get(title);
                System.out.println("Title: " + title);
                System.out.println("Text: " + text);
            } else {
                System.out.println("Invalid task index!");
            }
        } else if (choice == 2) {
            System.out.println("Returning to the main menu...");
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public void showList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
    }

    public void clearAll() {
        list.clear();
        map.clear();
        System.out.println("All tasks have been cleared!");
    }

    public void sizeInTheList() {
        System.out.println("Number of tasks in the list: " + list.size());
    }
}
