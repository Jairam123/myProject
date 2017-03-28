<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager Form</title>
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link type="text/css" rel="Stylesheet" href="http://ajax.microsoft.com/ajax/jquery.ui/1.8.6/themes/smoothness/jquery-ui.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="Css/style.css">
  <link rel="stylesheet" href="Css/styleForLastpages.css">
</head>
<body>
<form >
 <button formaction="logOut" type="submit" id="logOut">LogOut</button>
</form>
<div class="form">
     <h1>Complaints Search Form</h1>
       <div id="signup">
          <form action="manager1SearchResult" method="post" id="managerForm">
           <div class="field-wrap">
               <label style="margin-top:-40px;">Customer Name</label>
               <br>
               <br>
              <sx:autocompleter  id="name" list="complainersList" name="customerName" showDownArrow="false" cssStyle="width:100%;position:absolute;top:-10px;" ></sx:autocompleter>
            </div>
     <br>
     <br>
         <div class="field-wrap" style="margin-top:-15px;">
         
            <input placeholder="Mobile Number"type="text" autocomplete="off" id="mobileNumber" name="mobileNumber"/>
          </div>
          <div class="field-wrap" style="margin-top:-15px;">
            <label style="margin-left:-10px;">
             Complaints:From Date
            </label>
            <br>
            <br>
             <input type="text" id="calendar" autocomplete="off" name="fromDate"/>
           </div>
           <div class="field-wrap" style="margin-top:-15px;">
             <label style="margin-left:-10px;">
               Complaints:To Date
             </label>
             <br>
             <br>
              <input type="text" id="calendar1" autocomplete="off" name="toDate"/>
            </div>
           <input type="text" name="email" value="<s:property value="#session.email"/>" style="display:none;"/>
          <button type="submit" class="button button-block" id="search">Search</button>
          </form>
        </div>
</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="Js/manager.js"></script>
  <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
  $(function() {
       $( "#calendar" ).datepicker({ minDate: -20, maxDate: "-1D" });
       $( "#calendar1" ).datepicker({ minDate: -20, maxDate: "0" });
  });
</script>
    
  
</body>
</html>