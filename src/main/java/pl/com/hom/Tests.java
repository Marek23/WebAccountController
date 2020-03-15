package pl.com.hom;

import java.util.List;

import javax.persistence.Tuple;

import pl.com.hom.transactions.TransactionEntity;
import pl.com.hom.transactions.TransactionType;
import pl.com.hom.transactions.Transaction;

import static pl.com.hom.connection.SessionCreator.saveToDB;
import static pl.com.hom.connection.SessionCreator.init;
import static pl.com.hom.connection.Repository.getFromQuery;

public class Tests {
	public static void main(String[] args) {
		System.out.println("Start");
		init();

		TransactionEntity e = new TransactionEntity();
		e.setName("test name");

		TransactionType t = new TransactionType();
		t.setName("test name");
		t.setTransactionTypeId(1,"TYPE____");

		Transaction out = new Transaction();
		out.setDescription("test");
		out.setExecDate("20190101");
		out.setOrderDate("20190101");

		out.setTransactionEntity(e);
		out.setTransactionType(t);

//		saveToDB(e);
//		saveToDB(t);
//		saveToDB(out);

		List<Tuple> results = getFromQuery(
			"FROM  Transaction",
			"WHERE transactionEntity.id = " + 1
		);

		for (Tuple r : results) {
			Transaction obj = (Transaction)r.get(0);
			System.out.println(obj.getDescription());
			System.out.println(obj.getTransactionEntity().getName());
		}

		System.out.println("Stop");
	}
}