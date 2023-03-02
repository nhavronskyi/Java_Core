package ShopingList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Shopping {

    private LinkedList<String> list;

    public Shopping(LinkedList<String> list) {
        this.list = list;
    }

    public void shoppingList() {
        Scanner sc = new Scanner(System.in);
        Set<String> checker = new HashSet<>();

		while(true) {
			
			if(checker.stream().count() == list.size()) {
				System.out.println("all product already checked");
				break;
			}
			
			System.out.print("Put num: ");
			int index;
			try {
				index = sc.nextInt()-1;
			}catch(OutOfMemoryError e) {
				System.out.println("stop!");
				break;
			}

			if(index >= list.size())
				System.out.println("your num is >= "+ list.size());
			else if(index < 0)
				System.out.println("your num is < "+ 0);
			else {
                if(list.get(index).split(" ").length > 1) {
                    System.out.println("product " + list.get(index).split(" ")[0] + " already checked");
                    continue;
                }
                sortAlgorithm(checker, index);
			}
			
		}
    }

    private void sortAlgorithm(Set<String> checker, int index) { 
        checker.add(list.get(index).split(" ")[0]);
        
        String s = list.get(index)+" [checked]";
        list.remove(index);
        list.addFirst(s);
        
        showList();
    }
    public void showList() {
        System.out.println("your list:");
        list.forEach(x -> System.out.println(list.indexOf(x)+1 + " " + x));
    }
    
}
