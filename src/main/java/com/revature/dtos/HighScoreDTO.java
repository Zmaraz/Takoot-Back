package com.revature.dtos;

public class HighScoreDTO {

	private int scoreId;
	private int score;
	private int quizId;
	
	public HighScoreDTO() {
		super();
	}

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quizId;
		result = prime * result + score;
		result = prime * result + scoreId;
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
		HighScoreDTO other = (HighScoreDTO) obj;
		if (quizId != other.quizId)
			return false;
		if (score != other.score)
			return false;
		if (scoreId != other.scoreId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HighScoreDTO [scoreId=" + scoreId + ", score=" + score + ", quizId=" + quizId + "]";
	}

	
	
}
