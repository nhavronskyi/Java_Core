package ShopingList;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShoppingRunner {
    public static void main(String[] args) {
        System.out.print("Put your List of product <format [pos1,pos2,pos3]>: ");
        Scanner sc = new Scanner(System.in);

        String fullList = sc.nextLine();

        LinkedList<String> list = new LinkedList<>(List.of(fullList.split(",")));

        Shopping shopping = new Shopping(list);

        shopping.showList();

        shopping.shoppingList();
    }
}