<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Return Page</title>
<link rel="stylesheet" href="styleForLastpages.css">
</head>
<body >
<center>
<s:form action="bookDisplay">
<h1>YOU HAVE SUCCESSFULLY RETURNED BOOK</h1>
<h2>WANT TO MOVE TO LIBRARY AGAIN CLICK THIS BUTTON???</h2>
<s:submit cssClass="button" value="Back"></s:submit>
</s:form>
</center>
</body>
</html>
