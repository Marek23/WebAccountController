package pl.com.hom;

import pl.com.hom.transactions.TransactionEntity;

import static pl.com.hom.connection.SessionCreator.saveToDB;
import static pl.com.hom.connection.SessionCreator.init;

public class Tests {
	public static void main(String[] args) {
		System.out.println("Start");
		init();

		TransactionEntity e = new TransactionEntity();
		e.setName("test name");

		saveToDB(e);

		System.out.println("Stop");
	}
}