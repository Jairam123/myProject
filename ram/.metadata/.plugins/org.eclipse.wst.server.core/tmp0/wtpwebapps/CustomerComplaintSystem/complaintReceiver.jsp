<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email Verfication</title>
<link rel="stylesheet" href="Css/styleForLastpages.css">
</head>
<body>
<center>
<s:form action="complaintForm">
<button formaction="logOut" id="logOut" >Logout</button>
<h1>TO CREATE A COMPLAINT CLICK BELOW BUTTON</h1>
<s:submit cssClass="button" value="Create Complaint"></s:submit>
</s:form>
</center>
</body>
</html>