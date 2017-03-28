<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
firstname:<s:property value="firstName"></s:property><br/>
lastname:<s:property value="lastName"></s:property><br/>
username:<s:property value="userName"></s:property><br/>
Email:<s:property value="email"></s:property><br/>
password:<s:property value="password"/>
</body>
</html>