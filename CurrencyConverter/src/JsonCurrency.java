import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

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
    private JSONObject cur;
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
        cur = parser.getJSONObject("rates");
        
        money.add(new Currency(base,1.0));
        
        int i=0;
        
        Iterator keys= cur.keys();
        
        while(keys.hasNext()){
        	String key=(String)keys.next();
        	money.add(new Currency(key,cur.getDouble(key)));
        }
        

    }
    public ArrayList<Currency> getList(){
    	
    	return money;
    }
}
	

