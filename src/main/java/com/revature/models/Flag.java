package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.filters.jsonview.FlagView;
import com.revature.filters.jsonview.QuestionView;

@Entity
@Table(name="FLAGS")
@SequenceGenerator(name="flags_seq", sequenceName="flags_seq", allocationSize=1)

public class Flag {

	@Id
	@Column(name="FLAG_ID")
	@JsonView({QuestionView.Public.class, FlagView.Public.class})
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flags_seq")
	private int flag_id;
	
	@JsonView({QuestionView.Public.class, FlagView.Public.class})
	@Column(name="FLAG_DESCRIPTION")
	private String description;
	
	@JsonView(FlagView.Public.class)
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="question_id")
	private Question question;
	
	public Flag() {
		super();
	}

	public Flag(int flag_id, String description, Question question) {
		super();
		this.flag_id = flag_id;
		this.description = description;
		this.question = question;
	}

	public Flag(int flag_id, String description) {
		super();
		this.flag_id = flag_id;
		this.description = description;
	}

	public int getFlag_id() {
		return flag_id;
	}

	public void setFlag_id(int flag_id) {
		this.flag_id = flag_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + flag_id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flag [flag_id=" + flag_id + ", description=" + description + ", question=" + question + "]";
	}
}

