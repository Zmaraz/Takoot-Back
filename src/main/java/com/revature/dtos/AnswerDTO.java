package com.revature.dtos;

public class AnswerDTO {

	private int answerId;
	private String answer;
	private int answerValue;
	
	public AnswerDTO() {
		super();
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
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
		AnswerDTO other = (AnswerDTO) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerId != other.answerId)
			return false;
		if (answerValue != other.answerValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnswerDTO [answerId=" + answerId + ", answer=" + answer + ", answerValue=" + answerValue + "]";
	}
	
	
}
