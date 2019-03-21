package com.revature.models;

public class Quiz {
	
	private int quiz_id;
	private String title;
	private int author_id;
	private String date_created;
	private String date_last_updated;
	private int category_id;
	private int difficulty_id;
	private int default_id;
	
	public Quiz() {
		super();
	}

	public Quiz(int quiz_id, String title, int author_id, String date_created, String date_last_updated,
			int category_id, int difficulty_id, int default_id) {
		super();
		this.quiz_id = quiz_id;
		this.title = title;
		this.author_id = author_id;
		this.date_created = date_created;
		this.date_last_updated = date_last_updated;
		this.category_id = category_id;
		this.difficulty_id = difficulty_id;
		this.default_id = default_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getDate_last_updated() {
		return date_last_updated;
	}

	public void setDate_last_updated(String date_last_updated) {
		this.date_last_updated = date_last_updated;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getDifficulty_id() {
		return difficulty_id;
	}

	public void setDifficulty_id(int difficulty_id) {
		this.difficulty_id = difficulty_id;
	}

	public int getDefault_id() {
		return default_id;
	}

	public void setDefault_id(int default_id) {
		this.default_id = default_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + author_id;
		result = prime * result + category_id;
		result = prime * result + ((date_created == null) ? 0 : date_created.hashCode());
		result = prime * result + ((date_last_updated == null) ? 0 : date_last_updated.hashCode());
		result = prime * result + default_id;
		result = prime * result + difficulty_id;
		result = prime * result + quiz_id;
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
		if (author_id != other.author_id)
			return false;
		if (category_id != other.category_id)
			return false;
		if (date_created == null) {
			if (other.date_created != null)
				return false;
		} else if (!date_created.equals(other.date_created))
			return false;
		if (date_last_updated == null) {
			if (other.date_last_updated != null)
				return false;
		} else if (!date_last_updated.equals(other.date_last_updated))
			return false;
		if (default_id != other.default_id)
			return false;
		if (difficulty_id != other.difficulty_id)
			return false;
		if (quiz_id != other.quiz_id)
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
		return "Quiz [quiz_id=" + quiz_id + ", title=" + title + ", author_id=" + author_id + ", date_created="
				+ date_created + ", date_last_updated=" + date_last_updated + ", category_id=" + category_id
				+ ", difficulty_id=" + difficulty_id + ", default_id=" + default_id + "]";
	}
	
	
	

}
