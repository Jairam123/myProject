<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Valiadtion</title>
<link rel="stylesheet" href="Css/styleForLastpages.css">
</head>
<body>
<center>
<s:form >
<h1>YOUR COMPLAINT SUCCESSFULLY FILED</h1>
<h2>IF YOU WANT GO TO LOGIN PAGE AGAIN CLICK THIS BUTTON???</h2>
<s:submit action="logOut" cssClass="button" value="HOME"></s:submit>
</s:form>
</center>
</body>
</html>