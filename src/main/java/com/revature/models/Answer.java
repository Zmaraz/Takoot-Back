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
import com.revature.filters.jsonview.QuizView;

@Entity
@Table(name="ANSWERS")
@SequenceGenerator(name="answers_seq", sequenceName="answers_seq", allocationSize=1)
public class Answer {
	
	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answers_seq")
	private int answerId;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="question_id")
	private Question question;
	
	@Column(name="answer")
	@JsonView(QuizView.Public.class)
	private String answer;
	
	@Column(name="answer_value")
	@JsonView(QuizView.Public.class)
	private int answerValue;
	
	public Answer() {
		super();
	}

	public Answer(int answerId, String answer, int answerValue) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.answerValue = answerValue;
	}

	public Answer(int answerId, Question question, String answer, int answerValue) {
		super();
		this.answerId = answerId;
		this.question = question;
		this.answer = answer;
		this.answerValue = answerValue;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
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

	public int getAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(int answerValue) {
		this.answerValue = answerValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + answerId;
		result = prime * result + answerValue;
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
		if (answerId != other.answerId)
			return false;
		if (answerValue != other.answerValue)
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
		return "Answer [answerId=" + answerId + ", question=" + question + ", answer=" + answer + ", answerValue="
				+ answerValue + "]";
	}

	

}	

