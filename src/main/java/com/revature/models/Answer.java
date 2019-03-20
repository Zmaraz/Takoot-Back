package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
@SequenceGenerator(name="answers_seq", sequenceName="answers_seq", allocationSize=1)
public class Answer {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answers_seq")
	private int answer_id;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	@Column(name="answer")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name="answer_value_id")
	private Answer answer_value;
	
	public Answer() {
		super();
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Answer getAnswer_value() {
		return answer_value;
	}

	public void setAnswer_value(Answer answer_value) {
		this.answer_value = answer_value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + answer_id;
		result = prime * result + ((answer_value == null) ? 0 : answer_value.hashCode());
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
		Answer other = (Answer) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answer_id != other.answer_id)
			return false;
		if (answer_value == null) {
			if (other.answer_value != null)
				return false;
		} else if (!answer_value.equals(other.answer_value))
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
		return "Answer [answer_id=" + answer_id + ", question=" + question + ", answer=" + answer + ", answer_value="
				+ answer_value + "]";
	}

	
	

}
