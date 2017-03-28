package com.girnarsoft.customercomplaintsystem.actions;

import java.util.ArrayList;
import java.util.List;

import com.girnarsoft.customercomplaintsystem.dto.CustomerDetails;
import com.girnarsoft.customercomplaintsystem.dto.ManagerDetails;
import com.girnarsoft.customercomplaintsystem.service.ComplaintService;
import com.girnarsoft.customercomplaintsystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerSearchResultAction extends ActionSupport {
	private String customerName;
	private String mobileNumber;
	private String fromDate;
	private String toDate;
	private String email;
	private EmployeeService employeeService;
	private ComplaintService complaintService;
	private List<CustomerDetails> customersList;
    private List<ManagerDetails>  l2ManagersList;
	public ManagerSearchResultAction() {
		employeeService = new EmployeeService();
		complaintService = new ComplaintService();
		customersList = new ArrayList<>();
	}

	public String execute() {
		int employeeId = employeeService.getEmployeeId(email);
		customersList = complaintService.getCustomersListBySearch(employeeId, customerName, mobileNumber, fromDate, toDate);
		setL2ManagersList(employeeService.getL2Managers());
		return "success";

	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List<CustomerDetails> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(List<CustomerDetails> customersList) {
		this.customersList = customersList;
	}

	public List<ManagerDetails> getL2ManagersList() {
		return l2ManagersList;
	}

	public void setL2ManagersList(List<ManagerDetails> l2ManagersList) {
		this.l2ManagersList = l2ManagersList;
	}

	
}
