package com.revature.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.revature.filters.jsonview.QuizView;
import com.revature.filters.jsonview.UserView;


@NamedQueries({
	@NamedQuery(name="getAllCateogories", query="from Category"),
	@NamedQuery(name="getCategoryById", query="from Category c where c.categoryId = :category_id")
})

@Entity
@Table(name="CATEGORIES")
public class Category {
	
	@Id
	@Column(name="category_id")
	@JsonView(UserView.Quiz.class)
	private int categoryId;
	
	@Column(name="quiz_category")
	@JsonView({UserView.Quiz.class, QuizView.Public.class})
	private String category;

	@JsonBackReference(value="quiz-cat")
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Quiz> quizzes;
	

	public Category() {
		super();
	}


	public Category(int categoryId, String category, List<Quiz> quizzes) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.quizzes = quizzes;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + categoryId;

		result = prime * result + ((quizzes == null) ? 0 : quizzes.hashCode());

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
		Category other = (Category) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryId != other.categoryId)
			return false;

		if (quizzes == null) {
			if (other.quizzes != null)
				return false;
		} else if (!quizzes.equals(other.quizzes))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category + ", quizzes=" + quizzes + "]";
	}
}