package com.girnarsoft.customercomplaintsystem.actions;

import java.sql.SQLException;

import com.girnarsoft.customercomplaintsystem.dto.ComplaintDetails;
import com.girnarsoft.customercomplaintsystem.service.ComplaintService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ComplaintFileAction extends ActionSupport implements ModelDriven{
   private ComplaintDetails complaintDetails;
   private ComplaintService complaintService;
   public ComplaintFileAction() {
	   complaintDetails = new ComplaintDetails();
	   complaintService = new ComplaintService();
}
     public String execute(){
    	 try {
			complaintService.insertComplaintDetailsInDb(complaintDetails);
			return "success";
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return "dataInsertionError";
		}
     }
	public Object getModel() {
		return complaintDetails;
	}

}
