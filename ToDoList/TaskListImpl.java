class TaskListImpl implements TaskList{
    private final ToDoService service= new ToDoServiceImpl();

    public void run(int task) {
        switch (task) {
            case 1 -> service.addTask();
            case 2 -> service.removeTask();
            case 3 -> service.taskShowList();
            case 4 -> service.clearAll();
            case 5 -> service.sizeInTheList();
        }
    }

    public void showOptions() {
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. View tasks");
        System.out.println("4. Clear the list");
        System.out.println("5. Get the number of tasks in the list");
    }
}