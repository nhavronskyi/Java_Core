import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MyList{
    int task, sumOfElem = 0;
    List<String> list = new ArrayList<>();
    Map<String, String> map= new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void setTask(int task){ this.task = task;}
    int getTask(){return task;}

    void work(){
        switch (getTask()) {
            case 1 -> taskAdd();
            case 2 -> taskRemove();
            case 3 -> taskShowList();
            case 4 -> clearAll();
            case 5 -> sizeInTheList();
        }
    }
    void sizeInTheList(){
        System.out.println("num of elements in your list is: " + list.size());
    }
    void clearAll(){
        list.clear();
        System.out.println("Your list is clear");
    }


    void taskAdd(){
        sumOfElem++;
        System.out.println("Put your task " + sumOfElem + ":");
        System.out.print("Put title: ");
        String title = sc.nextLine();
        System.out.print("\nPut text: ");
        String text = sc.nextLine();
        map.put(title, text);
        list.add(title);
    }
    void taskRemove(){
        System.out.println("Your list:");
        showList();
        System.out.println("Remove elem: ");
        sumOfElem--;
        int removeElem = 0;
        try{
        removeElem = sc.nextInt();}
        catch (InputMismatchException e){
            System.out.println("this symbol isn't exist");
        }
        removeElem--;
        try{
            map.remove(list.get(removeElem));
            list.remove(removeElem);
        } catch (IndexOutOfBoundsException e){
            System.out.println("In list are no element with number: " + ++removeElem);
        }
    }
    void taskShowList(){
        System.out.println("Show list:");
        showList();
        showText();
    }

    void showList(){
        list.forEach(x-> System.out.println(list.indexOf(x)+1 + ": " + x));
    }
    void showText(){
        try{
            System.out.println("Show current element? Yes = 1 , No = 2");
            System.out.print("put option: ");
            int choose = sc.nextInt();
            switch (choose){
            case 1:
                System.out.print("Choose your elem: ");
                int chooseElem = sc.nextInt();
                System.out.println("Title: " + list.get(chooseElem - 1));
                System.out.println("Text: " + map.get(list.get(chooseElem-1)));
                break;
            case 2: break;
            default:
                System.out.println("You put invalid number");
                break;
        }
        }catch (InputMismatchException e){
            System.out.println("ERROR!");
        }
    }
    void toDo(){
        System.out.println("1. add element");
        System.out.println("2. remove");
        System.out.println("3. view tasks");
        System.out.println("4. clear list");
        System.out.println("5. how many elements are in the list");
    }
}

