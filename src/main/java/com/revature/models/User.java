package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonView;
import com.revature.filters.jsonview.FlagView;
import com.revature.filters.jsonview.HighScoreView;
import com.revature.filters.jsonview.QuizView;
import com.revature.filters.jsonview.UserView;

@NamedQueries({
	@NamedQuery(name="getAllUsers", query="from User"),
	@NamedQuery(name="getUserById", query="from User u where u.user_id = :user_id"),
	@NamedQuery(name="getUserByUsername", query="from User u where u.username like :username"),
	@NamedQuery(name="getUserByCredentials", query="from User u where u.username like :username AND u.password like :user_password")

})


@Entity
@Table(name="Quiz_Users")
@SequenceGenerator(name="user_seq", sequenceName="user_sequence", allocationSize=1, initialValue=6)
//@JsonFilter("depth_2")
public class User {
	
	@Id
	@Column(name="user_id")
	@JsonView(UserView.Public.class)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	private int user_id;
	
	@JsonView(UserView.Public.class)
	@Column(name="first_name")
	private String first_name;
	
	@JsonView(UserView.Public.class)
	@Column(name="last_name")
	private String last_name;
	
	@JsonView({UserView.Public.class, QuizView.Public.class, HighScoreView.Public.class})
	@Column(name="username")
	private String username;
	
	@JsonView({UserView.Private.class, FlagView.Public.class})
	@Column(name="user_password")
	private String password;
	
	@JsonView(UserView.Public.class)
	@Column(name="email")
	private String email;
	
	@JsonView({UserView.Quiz.class, UserView.Public.class})
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Quiz> quizzes; 
	
	@JsonView(UserView.Quiz.class)
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<HighScore> highScores;
	
	public User() {
		super();
	}

	public User(int user_id, String first_name, String last_name, String username, String password, String email) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
//	
	public List<HighScore> getHighScores() {
		return highScores;
	}

	public void setHighScores(List<HighScore> highScores) {
		this.highScores = highScores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
				+ username + ", password=" + password + ", email=" + email + "]";
	}

}
