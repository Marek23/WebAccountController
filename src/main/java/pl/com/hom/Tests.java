package pl.com.hom;

import pl.com.hom.transactions.TransactionEntity;
import pl.com.hom.transactions.TransactionType;

import static pl.com.hom.connection.SessionCreator.saveToDB;
import static pl.com.hom.connection.SessionCreator.init;

public class Tests {
	public static void main(String[] args) {
		System.out.println("Start");
		init();

		TransactionEntity e = new TransactionEntity();
		e.setName("test name");

		TransactionType t = new TransactionType();
		t.setName("test name");
		t.setType("TYPE____");

		saveToDB(e);
		saveToDB(t);

		System.out.println("Stop");
	}
}