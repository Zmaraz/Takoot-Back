package com.revature.models;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getAllQuizzes", query="from Quiz"),
	@NamedQuery(name="getQuizzesByDifficulty", query="from Quiz q where q.difficultyId = :difficulty_id"),
	@NamedQuery(name="getQuizzesByDefaultStatus", query="from Quiz q where q.defaultId = :default_id")
})


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
	
	@Column(name="DATE_CREATED")
	private String dateCreated;
	
	@Column(name="DATE_LAST_UPDATED")
	private String dateLastUpdated;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name="DIFFICULTY_ID")
	private int difficultyId;
	
	@Column(name="DEFAULT_ID")
	private int defaultId;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
	private List<HighScore> highScores;
	
	@ManyToOne(cascade={
			CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH
	})
	@JoinColumn(name="author_id")
	private User user;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
	private List<Question> questions;
	
	public Quiz() {
		super();
	}

	public Quiz(int quizId, String title, String dateCreated, String dateLastUpdated, Category category,
			int difficultyId, int defaultId, List<HighScore> highScores, User user, List<Question> questions) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.dateCreated = dateCreated;
		this.dateLastUpdated = dateLastUpdated;
		this.category = category;
		this.difficultyId = difficultyId;
		this.defaultId = defaultId;
		this.highScores = highScores;
		this.user = user;
		this.questions = questions;
	}

	public Quiz(int quizId, String title, String dateCreated, String dateLastUpdated, int difficultyId, int defaultId) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.dateCreated = dateCreated;
		this.dateLastUpdated = dateLastUpdated;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public List<HighScore> getHighScores() {
		return highScores;
	}

	public void setHighScores(List<HighScore> highScores) {
		this.highScores = highScores;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateLastUpdated == null) ? 0 : dateLastUpdated.hashCode());
		result = prime * result + defaultId;
		result = prime * result + difficultyId;
		result = prime * result + ((highScores == null) ? 0 : highScores.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + quizId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Quiz other = (Quiz) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
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
		if (highScores == null) {
			if (other.highScores != null)
				return false;
		} else if (!highScores.equals(other.highScores))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (quizId != other.quizId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "Quiz [quizId=" + quizId + ", title=" + title + ", dateCreated=" + dateCreated + ", dateLastUpdated="
				+ dateLastUpdated + ", difficultyId=" + difficultyId + ", defaultId=" + defaultId + ", user=" + user
				+ "]";
	}

	
}

