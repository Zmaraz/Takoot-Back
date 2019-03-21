package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Answer_Value")

public class AnswerValue {
	
	@Id
	@Column(name="ANSWER_VALUE_ID")
	private int answer_value_id;

	@Column(name="ANSWER_VALUE")
	private String value;
	
	@Column(name="ANSWER_VALUE")
	private String value;
	public AnswerValue() {
		super();
	}

	public AnswerValue(int answer_value_id, String value) {
		super();
		this.answer_value_id = answer_value_id;
		this.value = value;
	}

	public int getAnswer_value_id() {
		return answer_value_id;
	}

	public void setAnswer_value_id(int answer_value_id) {
		this.answer_value_id = answer_value_id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answer_value_id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		AnswerValue other = (AnswerValue) obj;
		if (answer_value_id != other.answer_value_id)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnswerValue [answer_value_id=" + answer_value_id + ", value=" + value + "]";
	}
	
	

}
