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
<s:form>
<h1>OOPS! WITH THIS EMAIL ADDRESS OR MOBILE NUMBER USER ALREADY EXIST TRY WITH ANOTHER EMAIL ADDRESS</h1>
<h2>IF YOU WANT GOTO AGAIN SIGN UP PAGE PAGE CLICK THIS BUTTON</h2>
<s:submit action="logOut" cssClass="button" value="Home"></s:submit>
</s:form>
</center>
</body>
</html>