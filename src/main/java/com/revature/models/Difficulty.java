package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DIFFICULTY")
public class Difficulty {
	
	@Id
	@Column(name="DIFFICULTY_ID")
	private int difficultyId;
	
	@Column(name="DIFFICULTY")
	private String difficulty;
	
	public Difficulty() {
		super();
	}

	public Difficulty(int difficultyId, String difficulty) {
		super();
		this.difficultyId = difficultyId;
		this.difficulty = difficulty;
	}

	public int getDifficultyId() {
		return difficultyId;
	}

	public void setDifficulty_id(int difficultyId) {
		this.difficultyId = difficultyId;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + difficultyId;
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
		Difficulty other = (Difficulty) obj;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (difficultyId != other.difficultyId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Difficulty [difficulty_id=" + difficultyId + ", difficulty=" + difficulty + "]";
	}
	
	

}
