package pl.com.hom;

import pl.com.hom.transactions.TransactionEntity;
import pl.com.hom.transactions.TransactionType;
import pl.com.hom.transactions.Transaction;

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

		Transaction out = new Transaction();
		out.setDescription("test");
		out.setExecDate("20190101");
		out.setOrderDate("20190101");
		out.setTransactionEntity(e);
		out.setTransactionType(t);

		saveToDB(e);
		saveToDB(t);
		saveToDB(out);

		System.out.println("Stop");
	}
}