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
@Table(name="QUESTION")
@SequenceGenerator(name="question_seq", sequenceName="question_seq", allocationSize=1)
public class Question {
	
	@Id
	@Column(name="question_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="question_seq")
	private int question_id;
	
	@Column(name="question")
	private String question;
	
	@ManyToOne
	@JoinColumn(name="quiz_id")
	private Quiz quizId;
	
	public Question() {
		super();
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Quiz getQuizId() {
		return quizId;
	}

	public void setQuizId(Quiz quizId) {
		this.quizId = quizId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + question_id;
		result = prime * result + ((quizId == null) ? 0 : quizId.hashCode());
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
		Question other = (Question) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (question_id != other.question_id)
			return false;
		if (quizId == null) {
			if (other.quizId != null)
				return false;
		} else if (!quizId.equals(other.quizId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", quizId=" + quizId + "]";
	}

	

}
