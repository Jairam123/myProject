package com.girnarsoft.customercomplaintsystem.actions;

import java.util.ArrayList;
import java.util.List;

import com.girnarsoft.customercomplaintsystem.service.ComplaintService;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerSearchFormAction extends ActionSupport { 
 private ComplaintService complaintService;
 private List<String> complainersList = new ArrayList<>(); 
 public ManagerSearchFormAction() {
	 complaintService = new ComplaintService();
}
	public String execute(){
		complainersList = complaintService.complainersList();
		return "success";
		
	}
	public List<String> getComplainersList() {
		return complainersList;
	}
	public void setComplainersList(List<String> complainersList) {
		this.complainersList = complainersList;
	}
	
}
