package pl.com.hom.transactions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TransactionType implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionTypeId transactionTypeId;

	@Column(nullable = false)
	private String            name;

	@OneToMany(mappedBy = "transactionType")
	List<Transaction> transactions = new ArrayList<Transaction>();

	public int getId() {
		return transactionTypeId.getId();
	}

	public void setId(int id) {
		transactionTypeId.setId(id);
	}

	public void setTransactionTypeId(int id, String type) {
		this.transactionTypeId = new TransactionTypeId(id,type);
	}

	public TransactionTypeId getTransactionTypeId() {
		return transactionTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return transactionTypeId.getType();
	}

	public void setType(String type) {
		transactionTypeId.setType(type);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionTypeId.getId();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TransactionType))
			return false;
		TransactionType other = (TransactionType) obj;
		if (transactionTypeId.getId() != other.getTransactionTypeId().getId())
			return false;
		return true;
	}
}