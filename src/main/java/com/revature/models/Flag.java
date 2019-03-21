package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FLAGS")
public class Flag {
	
	private int flag_id;
	private int question_id;
	private String description;
	
	public Flag() {
		super();
	}

	public Flag(int flag_id, int question_id, String description) {
		super();
		this.flag_id = flag_id;
		this.question_id = question_id;
		this.description = description;
	}

	public int getFlag_id() {
		return flag_id;
	}

	public void setFlag_id(int flag_id) {
		this.flag_id = flag_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + flag_id;
		result = prime * result + question_id;
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
		Flag other = (Flag) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flag_id != other.flag_id)
			return false;
		if (question_id != other.question_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flag [flag_id=" + flag_id + ", question_id=" + question_id + ", description=" + description + "]";
	}
	
	

}
