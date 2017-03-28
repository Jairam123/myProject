package com.girnarsoft.customercomplaintsystem.actions;

import java.util.ArrayList;
import java.util.List;

import com.girnarsoft.customercomplaintsystem.service.SignUpService;
import com.opensymphony.xwork2.ActionSupport;
import com.girnarsoft.customercomplaintsystem.dto.EmployeeCategoryDetails;
import com.girnarsoft.customercomplaintsystem.dto.SecurityQuestionDetails;
public class IndexAction extends ActionSupport {
    private List<SecurityQuestionDetails> questionList = new ArrayList<>();
    private List<EmployeeCategoryDetails> categoryList = new ArrayList<>();
	private SignUpService signUpService;
	public IndexAction() {
		signUpService =  new SignUpService();
	}
	
		public String execute(){
	    	questionList = signUpService.getQuestionsListFromDao();
	    	categoryList = signUpService.getCategoryListFromDao();
			return "success";
		}

		public List<SecurityQuestionDetails> getQuestionList() {
			return questionList;
		}

		public void setQuestionList(List<SecurityQuestionDetails> questionList) {
			this.questionList = questionList;
		}

		public List<EmployeeCategoryDetails> getCategoryList() {
			return categoryList;
		}

		public void setCategoryList(List<EmployeeCategoryDetails> categoryList) {
			this.categoryList = categoryList;
		}



}
