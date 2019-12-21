package stream.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BeforeStreamAfterStream {
	
	public static void main(String[] args) {
		//Old approach to process a collection of objects begins
		
		//Create list of transactions
		List<Transaction> totalTransactionList = Arrays.asList(new Transaction(121,"Grocery",400),new Transaction(91,"Garments", 500)
				,new Transaction(176,"Grocery",1000),new Transaction(134,"Fee",100),new Transaction(55,"Grocery",2000));
		
		//Filter Only the grocery transactions
		List<Transaction> groceryTransaction = new ArrayList<>();
		for(Transaction t:totalTransactionList){
			if("Grocery".equals(t.getType())){
				groceryTransaction.add(t);
			}
		}
		//sort according to ascending order of value
		Collections.sort(groceryTransaction,(t1,t2) -> (t1.getTransactionId()-t2.getTransactionId()));
		//only need transactionId for the new list.so map Transaction object to TransactionId
		List<Integer> groceryTransactionIdList = new ArrayList<>();
		for(Transaction g:groceryTransaction){
			groceryTransactionIdList.add(g.getTransactionId());
			
		}
		System.out.println(groceryTransactionIdList);
		
		//Old approach to process a collection of objects ends
		
		//pitfalls in the above approach
		//1) Intermediate results has to be stored somewhere to process further.
		//2)It has to explicitly iterated by us to process it.
		
		
		//New approach to process a sequence of objects using stream api begins
		
		List<Integer> transactionId = totalTransactionList.stream().filter(t -> "Grocery".equals(t.getType())).sorted(Comparator.comparing(Transaction::getTransactionId)).map(Transaction::getTransactionId).collect(Collectors.toList());
		
		System.out.println(transactionId);
	}
	
	
}



class Transaction{
	private String type;
	private int value;
	private int transactionId;
	
	public Transaction(int transactionId, String type, int value){
		this.transactionId = transactionId;
		this.type = type;
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	
}