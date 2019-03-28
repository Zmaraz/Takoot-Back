package com.revature.dtos;

public class QuizDTO {
	
	private int quizId;
	private String title;
	private String dateCreated;
	private String dateLastUpdated;
	private int categoryId;
	private int difficultyId;
	private int defaultId;
	
	public QuizDTO() {
		super();
	}

	
	public int getQuizId() {
		return quizId;
	}


	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateLastUpdated() {
		return dateLastUpdated;
	}

	public void setDateLastUpdated(String dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(int difficultyId) {
		this.difficultyId = difficultyId;
	}

	public int getDefaultId() {
		return defaultId;
	}

	public void setDefaultId(int defaultId) {
		this.defaultId = defaultId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateLastUpdated == null) ? 0 : dateLastUpdated.hashCode());
		result = prime * result + defaultId;
		result = prime * result + difficultyId;
		result = prime * result + quizId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		QuizDTO other = (QuizDTO) obj;
		if (categoryId != other.categoryId)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateLastUpdated == null) {
			if (other.dateLastUpdated != null)
				return false;
		} else if (!dateLastUpdated.equals(other.dateLastUpdated))
			return false;
		if (defaultId != other.defaultId)
			return false;
		if (difficultyId != other.difficultyId)
			return false;
		if (quizId != other.quizId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "QuizDTO [quizId=" + quizId + ", title=" + title + ", dateCreated=" + dateCreated + ", dateLastUpdated="
				+ dateLastUpdated + ", categoryId=" + categoryId + ", difficultyId=" + difficultyId + ", defaultId="
				+ defaultId + "]";
	}

		
}
