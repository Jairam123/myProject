<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" content="width=device-width, initial-scale=1">
<title>Books Display</title>
 <link rel="stylesheet" href="booksDisplay.css">
</head>
<body >
	<%@ taglib uri="/struts-tags" prefix="s"%>
	
	<s:form action="logout" id="logoutFrom">
        <s:submit method ="logOut" id="logout" value="LogOut"></s:submit>
	</s:form>
	<h1 id="name">Welcome,<s:property value="#session.userName"/> </h1>
	<h1>Books Inventory</h1>
		<s:form action="bookDisplay"  id="form" name="myForm" method="post" >
	    
		<table class="container" id="bookTable">
			<thead>
				<tr>
					<th><h1>Select</h1></th>
		        	<th><h1>BookID</h1></th>
					<th><h1>BookName</h1></th>
					<th><h1>Quantity</h1></th>
					<th><h1>Author</h1></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="booksList">
					<tr>
						<td><s:checkbox class="check"  name="checkBoxes" 
								fieldValue="%{serialNo}" theme="simple" /></td>
						<td><s:property value="serialNo" /></td>
						<td><s:property value="bookName" /></td>
						<td><s:property value="quantity" /></td>
						<td><s:property value="author" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	    	<s:submit method="returnBooks" value="Return Book" id="return" />
		<s:submit method="borrowBooks" value="Borrow Book" id="borrow"/>
		<h3 id="error_not_available" style="display:none"><center>Book not available</center>></h3>
		<h3 id="msg" style="display:none"><center>select a book</center></h3>
	</s:form>
	<script  src="booksDisplayValidation.js"></script> 
</body>
</html>