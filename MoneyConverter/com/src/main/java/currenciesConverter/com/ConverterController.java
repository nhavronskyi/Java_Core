package currenciesConverter.com;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.json.JSONException;

public class ConverterController {
	private ConverterService converterService;
	
	public ConverterController() throws MalformedURLException {
		converterService = new ConverterService();
	}
	
	private String from;
	private double amount;
	private String to;
	
	public void setFromNum(double amount) {
		this.amount = amount;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}
	public double getAmount() {
		return amount;
	}
	public String getTo() {
		return to;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double calcucalate() throws JSONException, IOException {
		return 1/converterService.getCurrencies().get(to) * converterService.getCurrencies().get(from) * amount;
	}
	
	public String getListOfValutes() throws JSONException, IOException {
		StringBuilder string = new StringBuilder();
		
		Map<String, Double> map = converterService.getCurrencies();

		for(String str : map.keySet())
			string.append(str + " : ").append(map.get(str) + "\n");
		return string.toString();
	}
	
	public String getCurrency(String str) throws JSONException, IOException {
		return str + " : " + converterService.getCurrencies().get(str);
	}

}
