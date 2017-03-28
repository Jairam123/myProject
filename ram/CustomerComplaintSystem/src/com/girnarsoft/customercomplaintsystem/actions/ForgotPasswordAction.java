package com.girnarsoft.customercomplaintsystem.actions;

import java.util.ArrayList;
import java.util.List;

import com.girnarsoft.customercomplaintsystem.dto.SecurityQuestionDetails;
import com.girnarsoft.customercomplaintsystem.service.EmployeeService;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport {
	
	private EmployeeService employeeService;
	private int questionId;
	private String email;
	private String answer;
	private String password;

	public ForgotPasswordAction() {
		employeeService = new EmployeeService();
	}

	
	public String execute() {
		password = employeeService.getPassword(email, questionId, answer);
		if (password == null) {
			return "missMatch";
		} else {
			return "success";
		}
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
