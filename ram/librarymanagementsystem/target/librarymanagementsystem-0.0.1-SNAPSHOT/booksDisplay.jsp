<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books Display</title>
 <link rel="stylesheet" href="booksDisplay.css">
</head>
<body>
	<%@ taglib uri="/struts-tags" prefix="s"%>
	
	<h1>Books Inventory</h1>
	<s:form action="bookDisplay" method="post">
	 <button class="button" type="submit" formaction="index.jsp">LogOut</button>
		<table class="container">
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
				<s:iterator value="booksList" status="counter">
					<tr>
						<td><s:checkbox name="checkBoxes"
								fieldValue="%{#counter.index}" theme="simple" /></td>
						<td><s:property value="serialNo" /></td>
						<td><s:property value="bookName" /></td>
						<td><s:property value="quantity" /></td>
						<td><s:property value="author" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:submit method="returnBooks" value="return" id="return"/>
		<s:submit method="borrowBooks" value="borrow" id="borrow"/>
	</s:form>
</body>
</html>