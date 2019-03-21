package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEFAULT_STATUS")
public class DefaultStatus {
	
	@Id
	@Column(name="DEFAULT_ID")
	private int defaultId;
	
	@Column(name="DEFAULT_VALUE")
	private int defaultValue;
	
	public DefaultStatus() {
		super();
	}

	public DefaultStatus(int defaultId, int defaultValue) {
		super();
		this.defaultId = defaultId;
		this.defaultValue = defaultValue;
	}

	public int getDefaultId() {
		return defaultId;
	}

	public void setDefaultId(int defaultId) {
		this.defaultId = defaultId;
	}

	public int getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + defaultId;
		result = prime * result + defaultValue;
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
		if (defaultId != other.defaultId)
			return false;
		if (defaultValue != other.defaultValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DefaultStatus [default_id=" + defaultId + ", default_value=" + defaultValue + "]";
	}
	
	

}