package currenciesConverter.com;

import java.io.IOException;
import java.util.Scanner;

import org.json.JSONException;

public class Application {

    public static void main(String[] args) throws JSONException, IOException {
        consoleTest();
    }
    
    public static void consoleTest() throws JSONException, IOException {
    	ConverterController converterController = new ConverterController();
    	
    	System.out.println(converterController.getListOfValutes());
    	
    	
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("from USD UAH EUR");
    	String from = sc.next();
    	converterController.setFrom(from);
    	
    	System.out.println("amount");
    	double amount = sc.nextDouble();
    	converterController.setAmount(amount);
    	
    	System.out.println("to USD UAH EUR");
    	String to = sc.next();
    	converterController.setTo(to);
    	
    	System.out.println(converterController.getFrom() + " " + converterController.getAmount() + " " + converterController.getTo());
    	
    	System.out.println(converterController.calcucalate());
    }
}
