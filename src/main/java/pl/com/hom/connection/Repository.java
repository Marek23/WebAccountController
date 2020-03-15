package pl.com.hom.connection;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;

import pl.com.hom.transactions.TransactionEntity;

import static pl.com.hom.connection.SessionCreator.getSession;
import static pl.com.hom.connection.SessionCreator.getEntityManager;
import static pl.com.hom.utils.StringJoin.buildString;

public final class Repository {

	public static TransactionEntity getEntity(int id) {
		return (TransactionEntity) getSession().load(TransactionEntity.class, id);
	}

	public static List<Tuple>getFromQuery(String... query) {
		TypedQuery<Tuple> t = getEntityManager().createQuery(buildString(query), Tuple.class);
		List<Tuple> results = t.getResultList();
		return results;
	}
}
