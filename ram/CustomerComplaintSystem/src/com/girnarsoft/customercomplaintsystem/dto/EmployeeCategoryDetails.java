package com.girnarsoft.customercomplaintsystem.dto;

public class EmployeeCategoryDetails {
    private int categoryId;
    private String category;
    
	public EmployeeCategoryDetails(int categoryId, String category) {
		
		this.categoryId = categoryId;
		this.category = category;
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
	
}
