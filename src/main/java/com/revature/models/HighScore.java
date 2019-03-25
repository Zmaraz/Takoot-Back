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


@Entity
@Table(name="HIGH_SCORES")
@SequenceGenerator(name="highscore_seq", sequenceName="highscore_seq", allocationSize=1)
public class HighScore {
	
	@Id
	@Column(name="score_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="highscore_seq")
	private int scoreId;
	
	@Column(name="score")
	private int score;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="quiz_id")
	private Quiz quiz;
	
	
	public HighScore() {
		super();
	}


	public HighScore(int scoreId, int score, User user, Quiz quiz) {
		super();
		this.scoreId = scoreId;
		this.score = score;
		this.user = user;
		this.quiz = quiz;
	}
	

	public HighScore(int scoreId, int score) {
		super();
		this.scoreId = scoreId;
		this.score = score;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result + score;
		result = prime * result + scoreId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (score != other.score)
			return false;
		if (scoreId != other.scoreId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "HighScore [scoreId=" + scoreId + ", score=" + score + "]";
	}

		
}


	
	
	
	
	


