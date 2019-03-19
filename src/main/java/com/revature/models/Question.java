package com.revature.models;

public class Question {
	
	private int question_id;
	private String question;
	private int quiz_id;
	
	public Question() {
		super();
	}

	public Question(int question_id, String question, int quiz_id) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.quiz_id = quiz_id;
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

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + question_id;
		result = prime * result + quiz_id;
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
		if (quiz_id != other.quiz_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", quiz_id=" + quiz_id + "]";
	}
	
	
	
	

}
