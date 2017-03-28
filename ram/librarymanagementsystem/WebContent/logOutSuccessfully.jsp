<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thank You</title>
<link rel="stylesheet" href="styleForLastpages.css">
</head>
<body>
<center>
<s:form >
<h1>THANKS FOR VISITING OUR LIBRARY</h1>
<h2>IF YOU WANT TO GO HOME CLICK HOME BUTTON</h2>
<s:submit formaction="index.jsp" cssClass="button" value="Home"></s:submit>
</s:form>
</center>
</body>
</html>