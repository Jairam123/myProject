package com.girnarsoft.customercomplaintsystem.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.girnarsoft.customercomplaintsystem.dao.EmployeeCategoryDao;
import com.girnarsoft.customercomplaintsystem.dao.SecurityQuestionDao;
import com.girnarsoft.customercomplaintsystem.dto.EmployeeCategoryDetails;
import com.girnarsoft.customercomplaintsystem.dto.SecurityQuestionDetails;

public class SignUpService {
    SecurityQuestionDao securityQuestionDao;
    EmployeeCategoryDao employeeCategoryDao;
    SecurityQuestionDetails securityQuestionDetails;
    EmployeeCategoryDetails employeeCategoryDetails;
	public SignUpService() {
		securityQuestionDao = new SecurityQuestionDao();
		employeeCategoryDao = new EmployeeCategoryDao();
	}
	public List<SecurityQuestionDetails> getQuestionsListFromDao() {
		List<SecurityQuestionDetails> questionList = new ArrayList<>();
	    try {
			ResultSet rSet = securityQuestionDao.questionList();
			while(rSet.next()){
				securityQuestionDetails = new SecurityQuestionDetails(rSet.getInt("QuestionId"),rSet.getString("Question"));
                questionList.add(securityQuestionDetails);			
 			
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionList;	
	
	}
	public List<EmployeeCategoryDetails> getCategoryListFromDao() {
		List<EmployeeCategoryDetails> categoryList = new ArrayList<>();
	    try {
			ResultSet rSet = employeeCategoryDao.categoryList();
			while(rSet.next()){
				employeeCategoryDetails = new EmployeeCategoryDetails(rSet.getInt("CategoryId"),rSet.getString("Category"));
                categoryList.add(employeeCategoryDetails);	
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;	
	
	}
	
}
