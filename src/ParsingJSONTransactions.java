
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParsingJSONTransactions {
	
		public static void main(String[] args) throws Exception {

			String jsonString = new String(Files.readAllBytes(Paths.get("inputJSON2.json")));

			System.out.println("All Trasactions = " + getBalanceForCategory(jsonString, null));
			System.out.println("Dining Only Trasactions = " + getBalanceForCategory(jsonString, "Dining"));
		}
		
		/* @param inputJSON a JSON string of transactions
		   @param category the category of transactions to get the balance of
		   @return the total balance for the given category
		*/
		public static BigDecimal getBalanceForCategory(String inputJSON, String category) throws Exception {
			BigDecimal balance = new BigDecimal(0.0);
			
			JSONParser parser = new	JSONParser();	
	
			double tran_balance = 0.0;
			String tran_type = null;
			double tran_amount = 0.0;
			String tran_category = null;
			
			try {
			JSONObject jsonObject =	(JSONObject) parser.parse(inputJSON);			
			
			JSONArray jsonArray = (JSONArray) jsonObject.get("transactions");
			
			ObjectMapper mapper = new ObjectMapper();
			
		    for (int i = 0; i < jsonArray.size(); i++) {
	
		    	Map<String, String> tran = new HashMap<String, String>();
	
		    	tran = mapper.readValue(jsonArray.get(i).toString(), new TypeReference<Map<String, String>>(){});
			    	
			   	for (Object key : tran.keySet()) {
	
			   		if (key.toString() == "type") {
			   			tran_type = tran.get(key);			   			
			   		}
					if ((key.toString() == "amount")) {
						tran_amount = Double.parseDouble(tran.get(key));						
					}
					if ((key.toString() == "category")) {
						tran_category = tran.get(key);						
					}					
				}			
			   	if (category == null) {
				   	if (tran_type.equals("DEBIT")) {					
				   		tran_balance = tran_balance + Double.valueOf(tran_amount);
					} else if (tran_type.equals("CREDIT")){
						tran_balance = tran_balance - Double.valueOf(tran_amount);
					}
			   	} else if ((category.equals("Dining")) && (tran_category.equals("Dining"))) {
			   		if (tran_type.equals("DEBIT")) {					
				   		tran_balance = tran_balance + Double.valueOf(tran_amount);
					} else if (tran_type.equals("CREDIT")){
						tran_balance = tran_balance - Double.valueOf(tran_amount);
					}
				} 

		    }
			   
		    balance = BigDecimal.valueOf(tran_balance).setScale(2,BigDecimal.ROUND_HALF_UP);
		    
		    if (balance.signum() < 0) {
		    	balance = new BigDecimal(0.00);
		    }

	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
			return balance;	
		}	
}
