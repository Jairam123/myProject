<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SingUp Form</title>
<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="Css/style.css">
</head>
<body>
	<div class="form">

		<h1>Sign Up</h1>
		<div id="signup">
			<form action="register" id="signUpForm" method="post">
				<div class="field-wrap">
					<label> First Name<span class="req">*</span>
					</label> <input type="text" required autocomplete="off" id="name"
						name="name" />
				</div>
				<div class="field-wrap">
					<label> Email Address<span class="req">*</span>
					</label> <input type="email" required autocomplete="off" name="email"
						id="email" />
				</div>
				<div class="field-wrap">
					<label> Mobile Number<span class="req">*</span>
					</label> <input type="text" required autocomplete="off" name="mobileNumber" id="mobileNumber" />
						 
				</div>
				<div class="field-wrap" style="margin-top: -10px;">
					<label style="margin-left: -10px;">select Security Question
					</label> <br> <br> <select name="questionId" style="width: 100%;"
						required>
						<option selected disabled>choose here</option>
						<s:iterator value="questionList">
							<option value="<s:property value="questionId"/>"><s:property
									value="question" /></option>
						</s:iterator>
					</select>

				</div>

				<div class="field-wrap">
					<label> Answer<span class="req">*</span>
					</label> <input type="text" required autocomplete="off" name="answer"
						id="answer" />
				</div>

				<div class="field-wrap" style="margin-top: -10px;">
					<label style="margin-left: -10px;">select Role </label> <br>
					<br> <select name="categoryId" style="width: 100%;" required>
						<option selected disabled>choose here</option>
						<s:iterator value="categoryList">
							<option value="<s:property value="categoryId"/>"><s:property
									value="category" /></option>
						</s:iterator>
					</select>
				</div>
				<div class="field-wrap">
					<label> Set A Password<span class="req">*</span>
					</label> <input type="password" required autocomplete="off" id="password" />
				</div>
				<div class="field-wrap">
					<label> Confirm Password<span class="req">*</span>
					</label> <input type="password" required autocomplete="off"
						id="confirm_password" name="password" />
				</div>
				<button type="submit" class="button button-block" id="signUp">Sign Up
				</button>
			</form>
		</div>
	</div>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="Js/signUp.js"></script>
</body>
</html>