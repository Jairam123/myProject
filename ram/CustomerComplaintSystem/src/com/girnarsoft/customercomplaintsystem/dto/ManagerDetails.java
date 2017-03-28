package com.girnarsoft.customercomplaintsystem.dto;

public class ManagerDetails {
  private int employeeId;
  private String managerName;
public ManagerDetails(int managerId, String managerName) {
	this.setEmployeeId(managerId);
	this.managerName = managerName;
}

public String getManagerName() {
	return managerName;
}
public void setManagerName(String managerName) {
	this.managerName = managerName;
}

public int getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
  
}
