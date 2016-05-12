<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bootstrap 3, from LayoutIt!</title>

<meta name="description" content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link href="<c:url value="/dist/css/bootstrap.min.css" /> " rel="stylesheet">
<link href="<c:url value="/dist/css/style.css" /> " rel="stylesheet">

<%@ page isELIgnored="false" %>
</head>
<body>


<c:out value="${msg}"></c:out>
<c:out value="${css}"></c:out>


	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>









	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<div class="row">
									<div class="col-md-12">
										<div class="row">
											<div class="col-md-12"></div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<nav class="navbar navbar-default" role="navigation">


													<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
														<ul class="nav navbar-nav">

															<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">User<strong class="caret"></strong></a>
																<ul class="dropdown-menu">
																	<li><a href="#">search</a></li>
																	<li class="divider"></li>
																	<li><a href="#">create</a></li>

																</ul></li>

															<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Pay<strong class="caret"></strong></a>
																<ul class="dropdown-menu">
																	<li><a href="#">Collect</a></li>
																	<li class="divider"></li>
																	<li><a href="#">pay back</a></li>

																</ul></li>

														</ul>

														<ul class="nav navbar-nav navbar-right">
															<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dimuthu Senanayaka<strong class="caret"></strong></a>
																<ul class="dropdown-menu">
																	<li><a href="#">logout</a></li>
																</ul></li>
														</ul>
													</div>

												</nav>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">

												<!--start body-->

												<layout:block name="yako">

												</layout:block>


												<legend>Register Staff</legend>
												<c:url var="userActionUrl" value="/users/" />

												<form:form cssClass="form-horizontal" method="post" action="${userActionUrl}">
													<fieldset>
														<div class="col-md-6 column ui-sortable">



															<div class="form-group">
																<div class="col-md-12">
																	<label for="textinput">First Name</label>
																	<form:input id="textinput" path="firstName" name="textinput" type="text" class="form-control" />
																</div>
															</div>

															<div class="form-group">
																<div class="col-md-12">
																	<label for="textinput">Second Name</label> <input id="textinput" name="textinput" type="text" class="form-control">
																</div>
															</div>

															<div class="form-group">
																<div class="col-md-12">
																	<label for="textinput">Surname</label> <input id="textinput" name="textinput" type="text" class="form-control">
																</div>
															</div>



															<div class="form-group">
																<div class="col-md-6">
																	<label for="textinput">Date of Birth</label> <input id="textinput" name="textinput" type="date" class="form-control">
																</div>
															</div>
														</div>
														<div class="col-md-6 column ui-sortable">


															<div class="form-group">
																<div class="col-md-12">
																	<label for="textinput">Address</label> <input id="textinput" name="textinput" type="text" class="form-control">
																</div>
															</div>

															<div class="row">

																<div class="col-md-6 column ui-sortable">
																	<div class="form-group">
																		<div class="col-md-12">
																			<label for="textinput">Home Telephone</label> <input id="textinput" name="textinput" type="text" class="form-control">
																		</div>
																	</div>
																</div>
																<div class="col-md-6 column ui-sortable">
																	<div class="form-group">
																		<div class="col-md-12">
																			<label for="textinput">Mobile</label> <input id="textinput" name="textinput" type="text" class="form-control">
																		</div>
																	</div>
																</div>

															</div>

															<div class="form-group">
																<div class="col-md-12">
																	<label for="textinput">Email</label> <input id="textinput" name="textinput" type="email" class="form-control">
																</div>
															</div>

														</div>


														<!--end body-->
													</fieldset>


													<div class="col-md-4">
														<button id="singlebutton" name="singlebutton" class="btn btn-primary">Save User</button>
													</div>


												</form:form>

											</div>


										</div>
										<div class="row">
											<div class="col-md-12"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-1"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12"></div>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value="/dist/js/jquery.min.js" />"></script>
	<script src="<c:url value="/dist/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/dist/js/scripts.js" />"></script>

</body>
</html>