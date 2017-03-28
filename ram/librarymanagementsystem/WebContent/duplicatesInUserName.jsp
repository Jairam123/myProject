<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Username Verfication</title>
<link rel="stylesheet" href="styleForLastpages.css">
</head>
<body>
<center>
<s:form>
<h1>OOPS! WITH THIS USERNAME USER ALREADY EXIST TRY WITH ANOTHER USERNAME</h1>
<h2>IF YOU WANT GOTO AGAIN SIGN UP PAGE PAGE CLICK THIS BUTTON</h2>
<s:submit formaction="index.jsp" cssClass="button" value="Home"></s:submit>
</s:form>
</center>
</body>
</html>