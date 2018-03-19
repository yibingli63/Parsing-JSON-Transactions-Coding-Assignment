Core Java Code Challenge v2: Parsing JSON Transactions
Overview: 
Your are provided a JSON string of credit card transactions; implement the code below to determine the balance of all transactions & the balance for transactions of a given category.

Requirements: 

Complete the getBalanceForCategory(String input3sON, String category) method below to the following specifications:
1.	The json-simple (org.json.simple) library is available to use for decoding the JSON; however, it is not mandatory to use this library.
2.	Remember, while you can use reference documentation, you cannot copy directly from another website.
Inputs: 
1.	The inputJSON (shown in the sample input below) is a JSON String containing an array of transactions -- each with an id, accountld, postDate, merchantName, category, type, and amot
2.	The amount is always positive, and the type determines whether it is added or subtracted from the balance.
3.	Transactions of type=' CREDIT' are subtracted from the balance, and Transactions of type=' DEBIT' are added to the balance.
Output: 
1.	Return the balance for all transactions of the provided category; String comparisons on the category values should ignore case.
2.	If a NULL category is provided, then return the balance for all transactions.
3.	If there are no transactions for the given category, return 0.00  .
4.	Only return null when there is an error parsing the inputJSON.
Error Handling: 
1.	In a few cases, the JSON fragment containing the transaction may be malformed (contains extra braces or brackets, missing a value, etc.). When this occurs, a null value should be return
2.	A null value should also be returned if the input JSON is null.

Sample Input: 
Here is a sample inputJSON string:
{"transactions": [{"id" : "neer., "accountId" : "222333", "postDate" : "2014-08-12", "merchantName" : "Starbucks" „ "category" : "Dining", "type" : "DEBIT", "amount" : "10.322,
("id" : "10002", "accountId" : "222333", "postDate" : "2014-07-29", "merchantName" : "Dennys", "category" : "Dining" „ "type" : "DEBIT", "amount" : "32.12"),
("id" : "10003", "accountId" : "222333", "postDate" : "2014-08-05", "merchantName" : "Home Depot", "category" : "Home Improvement", "type" : "DEBIT", "amount": "344.93"), ("id" : "10004", "accountId" : "222333", "postDate" : "2014-08-10", "merchantName" : "Online Payment", "category" : "Payment/Credit", "type" : "CREDIT", "amount" : "200.00"), ("id" : "10005", "accountId" : "222333", "postDate" : "2014-09-01", "merchantName" : "Subway", "category" : "Dining", "type" : "DEBIT", "amount" : "5.582] }

The above input is understandably difficult to read, so here is what it looks like with formatting (only the first transaction is displayed):

{"transactions":[
"id" "10001",
"accountId" "222333",
"postDate" "2014-08-12", "merchantName" : "Starbucks", "category" : "Dining",
"type"  "DEBIT",
"amount"  "10.32"
• • •
]}

Sample Output: 
For getBalanceForCategory(samplelnput, null):
192.95
For getBalanceForCategory(samplelnput, "DINING"):
48.02

Available Libraries: 
The following libraries are available for you to use: import java io.*;

import java . math .*;
import java.text.*;
import java.util.*;
import java.util.ArrayList; import java.util.Collections; import java.util.List;
import java.util.regex.*;
import org.json.simple.parser.*;
import org.json.simple.*;

Important Notes: 
1.	While you may consult online references for guidance, you must not copy code from websites and/or other candidates.
2.	Do not change the method signatures of the getBalanceForCategory( ) method.
3.	This problem should take 45 minutes to complete.
4.	Click the "Run Code" button to try out your code against the test cases.
5.	You can debug your code using System.out.println( ) statements.

Your Answer

54     /**
55	* Takes in a JSON string of transactions and returns the total for the specified category.
56	* Returns the total of all transactions if NULL is passed in as the category.
57	* Credits are subtracted from the balance, and debits are added.
58	*
59	* @param inputJSON a JSON string of transactions
60      * @param category the category of transactions to get the balance of
61	* @return the total balance for the given category
62	*/
63 	public static BigDecimal getBalanceForCategory(String inputJSON, String category) throws Exception {
64
65
66		BigDecimal balance = new BigDecimal(0.0);
67		JSONParser parser = new	7SONParser();	
68		JSONObject jsonObject =	(JSONObject)	parser.parse(inputJSON);
69				
70		// YOUR CODE GOES HERE		
71				
72		return balance;		
73	}			



