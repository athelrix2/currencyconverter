import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

	
public class JsonCurrency {
	
	

	/***********************
	 * @author Justin Rolf *
	 ***********************/
		
    private URL url;
    private String result = "";
    private final String URL="http://api.fixer.io/latest";
    private JSONArray cur;
    private JSONObject parser;
    private ArrayList<Currency> money= new ArrayList<Currency>();
    private String base;

    public void getText()
    {
        try
        {
                url = new URL(URL);
                
                //connect to the url
                 HttpURLConnection connect =(HttpURLConnection)url.openConnection();
                 connect.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.2; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                
                //create buffered reader
                InputStreamReader stream=new InputStreamReader(connect.getInputStream());
                BufferedReader bufferedReader =new BufferedReader(stream);
                
                //get json text from webpage
                String line = null;
                result="";
                
                while((line = bufferedReader.readLine()) != null){
                    
                	result += line;
                }
                
                connect.disconnect();
                stream.close();
                bufferedReader.close();
                parseResult(result);
        }
        catch (Exception ex) {
        
        	System.out.println(ex);
        }
    }
    
    private void parseResult(String result) throws JSONException{
    	
        parser = new JSONObject(result);
        base = parser.getString("base");
        cur = parser.getJSONArray("rates");
        
        int i=0;
        
        while(!cur.getString(i).equals(null)){
        	
        	money.add(new Currency(cur.getString(i),cur.getDouble(i)));
        }
        
        i=0;
        
        while(!money.get(i).getName().equals(base)){
        	
        	i++;
        }
       
        for(Currency element:money){
        	
    	   element.setBase(money.get(i).getRate());
        }
    }
    public ArrayList<Currency> getList(){
    	
    	return money;
    }
}
	

