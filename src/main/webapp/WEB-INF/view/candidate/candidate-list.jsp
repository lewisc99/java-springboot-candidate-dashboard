<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Candidates</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header class="align-center">
	<div id="header">
	<h2>Candidates SEA Solutions</h2></div>
</header>
<div class="container">
<div class="row">
<div class="col-md-5">
   	<input type="button" value="Add Candidates"
   		onclick="window.location.href='showFormForAdd';return false;"
   		class="btn btn-primary"/>
   		<br>
   		<br>

   	<table class="table table-hover table-striped">
   	<thead class="table-dark">
   	<tr class="table-dark">
   		<th>Username</th>
   		<th>Email</th>
   		<th>Doc</th>
   		<th>Role</th>
   	</tr>
   	</thead>
   	<tbody>
   	<c:forEach var="tempCandidates" items="${candidates}">
   	<tr class="">
   	<c:url var="updateLink" value="/customer/showFormForUpdate">
   		<c:param name="CustomerId" value="${tempCandidates.id }" />
   	</c:url>

   	<td> ${tempCandidates.username }</td>
   	<td> ${tempCandidates.email }</td>
   	<td> ${tempCandidates.doc }</td>
   	<td> ${tempCandidates.role.name }</td>
   	<td>
   	<!-- display the update link -->
   		<a href="showFormForUpdate?id=${tempCustomer.id}">Update</a>
   		|
   		<a href="delete?id=${tempCustomer.id}"
   		onclick="if (!(confirm('Are your sure you want to delete this customer?'))) return false">Delete</a>
   	</td>
   	</tr>
   	</c:forEach>
   	</tbody>
   	</table>
</div>
</div>
</div>


</body>
</html>