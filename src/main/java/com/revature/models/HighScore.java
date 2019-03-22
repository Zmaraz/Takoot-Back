package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name="getAllHighScores", query="from HighScore"),
	@NamedQuery(name="getByUserId", query="from HighScore h where h.userId = :user_id"),
	@NamedQuery(name="getByQuizId", query="from HighScore h where h.quizId = :quiz_id"),
	@NamedQuery(name="getById", query="from HighScore h where h.scoreId = :score_id")

})

@Entity
@Table(name="HIGH_SCORES")
@SequenceGenerator(name="highscore_seq", sequenceName="highscore_seq", allocationSize=1)

public class HighScore {
	
	@Id
	@Column(name="score_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="highscore_seq")
	private int scoreId;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="user_id")
	private int userId;
	
	@Column(name="quiz_id")
	private int quizId;
	
	@Column(name="score")
	private int score;
	
	public HighScore() {
		super();
	}

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
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
		result = prime * result + quizId;
		result = prime * result + score;
		result = prime * result + scoreId;
		result = prime * result + userId;
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
		if (quizId != other.quizId)
			return false;
		if (score != other.score)
			return false;
		if (scoreId != other.scoreId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HighScore [scoreId=" + scoreId + ", userId=" + userId + ", quizId=" + quizId + ", score=" + score + "]";
	}



}