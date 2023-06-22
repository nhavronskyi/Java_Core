package ShopingList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Shopping {
    private final LinkedList<String> list;

    public Shopping(LinkedList<String> list) {
        this.list = list;
    }

    public void shoppingList() {
        Scanner sc = new Scanner(System.in);
        Set<String> checker = new HashSet<>();

        while (true) {
            if (checker.size() == list.size()) {
                System.out.println("All products have been checked.");
                break;
            }

            System.out.print("Enter the index: ");
            int index = sc.nextInt() - 1;

            if (index < 0 || index >= list.size()) {
                System.out.println("Invalid index. Please try again.");
            } else {
                String product = list.get(index);
                if (product.contains("[checked]")) {
                    System.out.println("Product " + product.split(" ")[0] + " has already been checked.");
                } else {
                    checkProduct(checker, index);
                }
            }
        }
    }

    private void checkProduct(Set<String> checker, int index) {
        String product = list.get(index);
        checker.add(product.split(" ")[0]);

        String checkedProduct = product + " [checked]";
        list.set(index, checkedProduct);

        System.out.println("Product " + product.split(" ")[0] + " has been checked.");
        showList();
    }

    public void showList() {
        System.out.println("Your list:");
        list.stream()
                .map(entry -> (list.indexOf(entry) + 1) + " " + entry)
                .forEach(System.out::println);
    }
}