package com.revature.models;

public class HighScore {
	
	private int score_id;
	private int user_id;
	private int quiz_id;
	private int score;
	
	public HighScore() {
		super();
	}

	public HighScore(int score_id, int user_id, int quiz_id, int score) {
		super();
		this.score_id = score_id;
		this.user_id = user_id;
		this.quiz_id = quiz_id;
		this.score = score;
	}

	public int getScore_id() {
		return score_id;
	}

	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quiz_id;
		result = prime * result + score;
		result = prime * result + score_id;
		result = prime * result + user_id;
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
		HighScore other = (HighScore) obj;
		if (quiz_id != other.quiz_id)
			return false;
		if (score != other.score)
			return false;
		if (score_id != other.score_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HighScore [score_id=" + score_id + ", user_id=" + user_id + ", quiz_id=" + quiz_id + ", score=" + score
				+ "]";
	}
	
	

}
