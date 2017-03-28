package com.girnarsoft.customercomplaintsystem.actions;

import java.util.List;
import com.girnarsoft.customercomplaintsystem.service.ComplaintService;
import com.opensymphony.xwork2.ActionSupport;

public class ComplaintResolvedAction extends ActionSupport {
	private List<Integer> checkBoxes;
    private ComplaintService complaintService;
    private int employeeId;
    private String comments;
    public ComplaintResolvedAction() {
    	complaintService = new ComplaintService();
	}
	
  public String resolved(){
	       for(int checkBoxesIndex=0;checkBoxesIndex<checkBoxes.size();checkBoxesIndex++){
	    	   int complaintId=checkBoxes.get(checkBoxesIndex);
	    	   complaintService.updateComplaintByResolving(complaintId, comments);
	       }
		return "success";
   }
  public String escalate(){
      for(int checkBoxesIndex=0;checkBoxesIndex<checkBoxes.size();checkBoxesIndex++){
   	   int complaintId=checkBoxes.get(checkBoxesIndex);
   	   complaintService.escalateComplaintToAnotherManager(employeeId,complaintId);
      }
	return "escalate";
}
	
	
	
	public List<Integer> getCheckBoxes() {
		return checkBoxes;
	}

	public void setCheckBoxes(List<Integer> checkBoxes) {
		this.checkBoxes = checkBoxes;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}