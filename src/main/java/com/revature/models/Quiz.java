package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="QUIZZES")
@SequenceGenerator(name="quiz_seq", sequenceName="quiz_seq", allocationSize=1)

public class Quiz {
	
	@Id
	@Column(name="QUIZ_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="quiz_seq")
	private int quizId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="AUTHOR_ID")
	private int authorId;
	
	@Column(name="DATE_CREATED")
	private String dateCreated;
	
	@Column(name="DATE_LAST_UPDATED")
	private String dateLastUpdated;
	
	@Column(name="CATEGORY_ID")
	private int categoryId;
	
	@Column(name="DIFFICULTY_ID")
	private int difficultyId;
	
	@Column(name="DEFAULT_ID")
	private int defaultId;
	
	public Quiz() {
		super();
	}

	public Quiz(int quizId, String title, int authorId, String dateCreated, String dateLastUpdated,
			int categoryId, int difficultyId, int defaultId) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.authorId = authorId;
		this.dateCreated = dateCreated;
		this.dateLastUpdated = dateLastUpdated;
		this.categoryId = categoryId;
		this.difficultyId = difficultyId;
		this.defaultId = defaultId;
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

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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
		result = prime * result + authorId;
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
		Quiz other = (Quiz) obj;
		if (authorId != other.authorId)
			return false;
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
		return "Quiz [quiz_id=" + quizId + ", title=" + title + ", author_id=" + authorId + ", date_created="
				+ dateCreated + ", date_last_updated=" + dateLastUpdated + ", category_id=" + categoryId
				+ ", difficulty_id=" + difficultyId + ", default_id=" + defaultId + "]";
	}
	
	
	

}