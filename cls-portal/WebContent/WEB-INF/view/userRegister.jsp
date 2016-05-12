<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:attribute name="yako">
     <legend>Register Staff</legend>
		<c:url var="userActionUrl" value="/users/" />

		<form:form cssClass="form-horizontal" method="post" action="${userActionUrl}">
			<fieldset>
				<div class="col-md-6 column ui-sortable">

					<div class="form-group">
						<div class="col-md-12">
							<label for="textinput" class="must">First Name</label>
							<form:input id="textinput" path="firstName" name="textinput" type="text" class="form-control" required="required" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12">
							<label for="textinput">Second Name</label> 
							<form:input id="textinput" path="secondName" name="textinput" type="text" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12">
							<label for="textinput" class="must">Surname</label> 
							<form:input id="textinput" path="surName" name="textinput" type="text" class="form-control" required="required" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-12">
							<label for="textinput" class="must">NIC</label> 
							<form:input id="textinput" path="identities[0].idValue" name="textinput" type="text" class="form-control" required="required" />
							<form:hidden path="identities[0].idType" value="NIC" />
						</div>
					</div>

					<div class="row" >
						<div class="col-md-6 column ui-sortable">
							<div class="form-group">
								<div class="col-md-12">
									<label for="textinput" class="must">Date of Birth</label> 					
									<form:input id="element_5" path="dob" name="element_5" type="date" class="form-control" required="required" />
								</div>
							</div>
						</div>
						<div class="col-md-6 column ui-sortable">
							<div class="form-group">
							  <label for="radios">Gender</label> 					
							  <div class="col-md-12"> 
							    <label  for="radios-0">
							      <form:radiobutton path="gender" name="radios" id="radios-0" value="MALE" checked="checked" />
							      Male
							    </label> 
							    <label  for="radios-1">
							      <form:radiobutton path="gender" id="radios-1" value="FEMALE" />
							      Female
							    </label>
							  </div>
							</div>
						</div>
					</div>
					
					
				</div>
				<div class="col-md-6 column ui-sortable">
					<div class="form-group">
						<div class="col-md-12">
							<label for="textinput" class="must">Home Address</label> 
							<form:input id="textinput" path="address[0].address" name="textinput" type="text" class="form-control" required="required" />
							<form:hidden path="address[0].country" value="Sri Lanka" /> 
							<form:hidden path="address[0].ContactType" value="HOME" />
						</div>
					</div>
					
					<div class="row">

						<div class="col-md-6 column ui-sortable">
							<div class="form-group">
								<div class="col-md-12">
									<label for="textinput">City</label> 
									<form:input id="textinput" path="address[0].city" name="textinput" type="text" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6 column ui-sortable">
							<div class="form-group">
								<div class="col-md-12">
									<label for="textinput">Town</label> 
									<form:input id="textinput" path="address[0].town" name="textinput" type="text" class="form-control" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 column ui-sortable">
							<div class="form-group">
								<div class="col-md-12">
									<label for="textinput">Home Telephone</label> 
									<form:input path="contactnumbers[0].value" id="textinput" class="form-control" />
									<form:hidden path="contactnumbers[0].contactType" value="MOBILE" />
									
								</div>
							</div>
						</div>
						<div class="col-md-6 column ui-sortable">
							<div class="form-group">
								<div class="col-md-12">
									<label for="textinput" class="must">Mobile</label>							
									<form:input path="contactnumbers[1].value" id="textinput" class="form-control" required="required" />
									<form:hidden path="contactnumbers[1].contactType" value="HOME" />			
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
			</fieldset>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton" class="btn btn-primary">Save User</button>
			</div>
		</form:form>
    </jsp:attribute>
</t:template>

