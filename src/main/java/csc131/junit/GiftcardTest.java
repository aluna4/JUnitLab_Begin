package csc131.junit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
//import java.util.Scanner;

import org.junit.jupiter.api.Test;
//import org.junit.rules.ExpectedException;


public class GiftcardTest {

	@Test
	
	public void getIssuingStore() {
		double balance;
		GiftCard card;
		int issuingStore;
		//double tolerance = 0.001;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",issuingStore,card.getIssuingStore());
	}
	
	@Test
	
	public void getBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		double tolerance;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		tolerance = 0.001;
		
		assertEquals("getBalance()",balance,card.getBalance(),tolerance);
	}
	
	@Test
	
	public void deduct_RemainingBalance() {
		double balance = 100.00;
		double amt = 25.00;
		String result;
		int issuingStore = 1337;
		
		GiftCard card = new GiftCard(issuingStore,balance);
		result = card.deduct(amt);
		amt = 0.00;
		assertEquals("deductBalance()",result,card.deduct(amt));
	}

	@Test
	public void deductTest1() {
		double balance = 100.00;
		double amt = -5.00;//getAmount();
		int issuingStore = 1337;
		GiftCard card = new GiftCard(issuingStore,balance);
		card.deduct(amt);
	}
	
	@Test
	public void deductTest2() {
		double balance = 100.00;
		double amt = 110;//getAmount();
		int issuingStore = 1337;
		GiftCard card = new GiftCard(issuingStore,balance);
		card.deduct(amt);
	}
	
	@Test
	public void throwException() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void testExceptions() {	
		double balance = -5;
		int issuingStore = 1337;
		GiftCard card = new GiftCard(issuingStore,balance);
		card.getBalance();	
	}
	
	@Test
	public void constructor_IncorrectID_Low() {
		double balance = 100;
		int issuingStore = -1;
		GiftCard card = new GiftCard(issuingStore,balance);
		card.getIssuingStore();
	}
	
	@Test
	public void constructor_IncorrectID_High() {
		double balance = 100;
		int issuingStore = 100000;
		GiftCard card = new GiftCard(issuingStore,balance);
		card.getIssuingStore();
	}

}
