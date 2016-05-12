<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>cls-portal</title>
<!-- Bootstrap core CSS -->
<link href="
      <c:url value="/dist/css/bootstrap.min.css" />
      " rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="
      <c:url value="/assets/css/ie10-viewport-bug-workaround.css" />
      " rel="stylesheet">
<link rel="stylesheet" type="text/css" href="
      <c:url value="/assets/css/view.css" />
      " media="all">
<script type="text/javascript" src="
      <c:url value="/assets/js/view.js" />
      "></script>
<script type="text/javascript" src="
      <c:url value="/assets/js/calendar.js" />
      "></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- Custom styles for this template -->
<link href="
      <c:url value="/assets/css/justified-nav.css" />
      " rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="
      <c:url value="/assets/js/ie-emulation-modes-warning.js" />
      "></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
<script>
	$(function() {
		$("#element_5").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
			showOn : "button",
			buttonImage : "../images/calendar.gif",
			buttonImageOnly : true,
			buttonText : "Select date"
		});

	});
</script>

<style>
.must:before {
	content: " * ";
	color: red;
}
</style>
​
</head>
<body id="main_body">


	<div class="container">
		<img id="top" src="
         <c:url value="/images/top.png" />
         " alt="">
		<div id="form_container">
			<h1>
				<a></a>
			</h1>
			<c:url var="userActionUrl" value="/users/R.html" />
			<form:form id="form_1099064" cssClass="appnitro" method="post" action="${userActionUrl}">
				<div class="form_description">
					<h2>Register Staff</h2>
				</div>
				<ul>
					<li><form:label path="firstName" cssClass="description must" for="element_1">First Name </form:label>
						<div>
							<form:input path="firstName" id="element_1" cssClass="element text medium" required="required" />
						</div></li>
					<li><form:label path="secondName" cssClass="description" for="element_2">SecondName </form:label>
						<div>
							<form:input path="secondName" id="element_2" cssClass="element text medium" />
						</div></li>
					<li><form:label path="surName" cssClass="description must" for="element_3">Surname</form:label>
						<div>
							<form:input id="element_3" path="surName" cssClass="element text medium" />
						</div></li>
					<li><form:label path="identities[0].idValue" for="element_4" cssClass="description must">NIC</form:label>
						<div>
							<form:input id="element_4" path="identities[0].idValue" required="required" />
							<form:hidden path="identities[0].idType" value="NIC" />
						</div></li>
					<li><form:label cssClass="description must" path="dob" for="element_5">Date of birth
                     </form:label>
						<div>
							<form:input id="element_5" path="dob" cssClass="element text medium" required="required" />
						</div></li>
					<li><label class="description must" for="element_6">Address</label>
						<div>
							<form:label for="element_6_2" path="address[0].address">Home Address</form:label>
							<form:input id="element_6_2" path="address[0].address" cssClass="element text large" />
						</div>
						<div class="left">
							<form:label path="address[0].town" for="element_6_3">Town</form:label>
							<form:input id="element_6_3" path="address[0].town" cssClass="element text medium" />
						</div>
						<div class="right">
							<form:label path="address[0].city" for="element_6_4">City</form:label>
							<form:input id="element_6_4" path="address[0].city" cssClass="element text medium" />
						</div> <!--  
						<div class="left">
							<form:label for="element_6_6" path="address[0].country">Country</form:label>
							<form:select path="address[0].country" cssClass="element select medium" id="element_6_6">
								<form:option value="Sri Lanka">Sri Lanka</form:option>
							</form:select>
						</div> 
						--> <form:hidden path="address[0].country" value="Sri Lanka" /> <form:hidden path="address[0].ContactType" for="element_4" value="HOME" /></li>
					<li><form:label path="contactnumbers[0].value" cssClass="description" for="element_7">Mobile Number </form:label>
						<div>
							<form:input path="contactnumbers[0].value" id="element_7" cssClass="element text medium" />
							<form:hidden path="contactnumbers[0].contactType" value="MOBILE" />
						</div></li>
					<li><form:label path="contactnumbers[1].value" cssClass="description" for="element_8">Home Phone Number </form:label>
						<div>
							<form:input path="contactnumbers[1].value" id="element_8" cssClass="element text medium" />
							<form:hidden path="contactnumbers[1].contactType" value="HOME" />
						</div></li>
					<li class="buttons"><input type="hidden" name="form_id" value="1099064" /> <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" /></li>
				</ul>
			</form:form>
			<div id="footer"></div>
		</div>
		<img id="bottom" src="
         <c:url value="/images/bottom.png" />
         " alt="">
	</div>
	<img id="bottom" src="
      <c:url value="/images/bottom.png" />
      " alt="">

	<div class="alert alert-success">
		<strong>Success!</strong> Indicates a successful or positive action.
	</div>
</body>
</html>