package com.revature.models;

public class Difficulty {
	
	private int difficulty_id;
	private String difficulty;
	
	public Difficulty() {
		super();
	}

	public Difficulty(int difficulty_id, String difficulty) {
		super();
		this.difficulty_id = difficulty_id;
		this.difficulty = difficulty;
	}

	public int getDifficulty_id() {
		return difficulty_id;
	}

	public void setDifficulty_id(int difficulty_id) {
		this.difficulty_id = difficulty_id;
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
		result = prime * result + difficulty_id;
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
		if (difficulty_id != other.difficulty_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Difficulty [difficulty_id=" + difficulty_id + ", difficulty=" + difficulty + "]";
	}
	
	

}
