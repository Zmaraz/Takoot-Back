package com.revature.models;

public class DefaultStatus {
	
	private int default_id;
	private int default_value;
	
	public DefaultStatus() {
		super();
	}

	public DefaultStatus(int default_id, int default_value) {
		super();
		this.default_id = default_id;
		this.default_value = default_value;
	}

	public int getDefault_id() {
		return default_id;
	}

	public void setDefault_id(int default_id) {
		this.default_id = default_id;
	}

	public int getDefault_value() {
		return default_value;
	}

	public void setDefault_value(int default_value) {
		this.default_value = default_value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + default_id;
		result = prime * result + default_value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultStatus other = (DefaultStatus) obj;
		if (default_id != other.default_id)
			return false;
		if (default_value != other.default_value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DefaultStatus [default_id=" + default_id + ", default_value=" + default_value + "]";
	}
	
	

}
