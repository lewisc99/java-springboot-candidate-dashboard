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
   		onclick="window.location.href='candidate/create';return false;"
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
   		<th></th>
   	</tr>
   	</thead>
   	<tbody>
   	<c:forEach var="tempCandidate" items="${candidates}">
   	<tr class="">
   	<td> ${tempCandidate.username }</td>
   	<td> ${tempCandidate.email }</td>
   	<td> ${tempCandidate.doc }</td>
   	<td> ${tempCandidate.role.name }</td>
   	<td>
     	<a href="candidate/${tempCandidate.id}">Details</a>
     	|
   		<a href="showFormForUpdate?id=${tempCandidate.id}">Update</a>
   		|
   		<a href="candidate/${tempCandidate.id}/delete"
   		onclick="if (!(confirm('Are your sure you want to delete this Candidate?'))) return false">Delete</a>
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