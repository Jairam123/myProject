<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/styleForLastpages.css">
</head>
<body>
<s:form >
<h1> YOUR PASSWORD </h1>
<h2><s:property value="password"/></h2>
<center><s:submit action="logOut" cssClass="button" value="HOME"></s:submit></center>
</s:form>
</body>
</html>