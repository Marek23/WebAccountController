package pl.com.hom.transactions;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionTypeId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int    id;
	private String type;

	public TransactionTypeId() {

	}
	public TransactionTypeId(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TransactionTypeId))
			return false;
		TransactionTypeId other = (TransactionTypeId) obj;
		if (id != other.id)
			return false;
		return true;
	}
}