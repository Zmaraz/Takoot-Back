package com.revature.models;

public class Category {
	
	private int category_id;
	private String category;
	
	public Category() {
		super();
	}

	public Category(int category_id, String category) {
		super();
		this.category_id = category_id;
		this.category = category;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + category_id;
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
		if (category_id != other.category_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category=" + category + "]";
	}
	
	

}
