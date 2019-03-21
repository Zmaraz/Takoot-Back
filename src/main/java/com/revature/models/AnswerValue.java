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
	private int answerValueId;

	@Column(name="ANSWER_VALUE")
	private String value;
	

	public AnswerValue() {
		super();
	}

	public AnswerValue(int answerValueId, String value) {
		super();
		this.answerValueId = answerValueId;
		this.value = value;
	}

	public int getAnswerValueId() {
		return answerValueId;
	}

	public void setAnswerValueId(int answerValueId) {
		this.answerValueId = answerValueId;
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
		result = prime * result + answerValueId;
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
		if (answerValueId != other.answerValueId)
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
		return "AnswerValue [answer_value_id=" + answerValueId + ", value=" + value + "]";
	}
	
	

}