package currenciesConverter.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ConverterService {
	private static URL url = null;
	 
	ConverterService() throws MalformedURLException{
		url = new URL("http://api.nbp.pl/api/exchangerates/tables/A/");
	}
	
	
	public HashMap<String, Double> getCurrencies() throws JSONException, IOException{
	    HashMap<String, Double> map = new HashMap<>();
	      
        JSONObject obj = readJsonFromUrl().getJSONObject(0);
        JSONArray arr = obj.getJSONArray("rates");

		map.put("PLN",1.0);
        
        for(int i = 0; i < arr.length(); i++) {
            JSONObject ob = arr.getJSONObject(i);
            String code = ob.get("code").toString();
            Double mid = Double.parseDouble(ob.get("mid").toString());
            
            if(code.equals("USD") || code.equals("EUR") || code.equals("UAH")) map.put(code, mid);
        }
        
        return map;
	}
	
	private JSONArray readJsonFromUrl() throws IOException, JSONException {
		  InputStream is = url.openStream();
		  try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      return json;
		  } finally {
		      is.close();
		  }
	}
	private String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) 
	      sb.append((char) cp);

	 
	    return sb.toString();
	}
}
