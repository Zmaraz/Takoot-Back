package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
@SequenceGenerator(name="answers_seq", sequenceName="answers_seq", allocationSize=1)
public class Answer {
	
	@Id
	@Column(name="answer_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answers_seq")
	private int answerId;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private int questionId;
	
	@Column(name="answer")
	private String answer;
	
	@OneToOne
	@Column(name="answer_value")
	private boolean answerValue;
	
	public Answer() {
		super();
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(boolean answerValue) {
		this.answerValue = answerValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + answerId;
		result = prime * result + (answerValue ? 1231 : 1237);
		result = prime * result + questionId;
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
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", questionId=" + questionId + ", answer=" + answer + ", answerValue="
				+ answerValue + "]";
	}

	


}	


}	