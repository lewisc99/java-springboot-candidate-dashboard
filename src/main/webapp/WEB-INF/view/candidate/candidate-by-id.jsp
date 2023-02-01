<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Candidates</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<style>
li.list-group-item
{
    width: 50%;
}
</style>
<body>
<div class="container flex">
    <div class="row flex-row d-flex">
     <div class="col">
      <header class="align-center mb-5">
             <div id="header">
                <img src='<c:url value="/files/layout_set_logo.png"></c:url>' />
              	<h3 class="justify-content-center text-center d-flex">Candidate SEA Solutions <em style="color:#007bff;" class="ml-2">${candidate.username}</em></h3></div>
           </header>
      <ul class="list-group  list-group-horizontal justify-content-center d-flex ">
                <li class="list-group-item">Username</li>
                <li class="list-group-item">${candidate.username}</li>
              </ul>
              <ul class="list-group  list-group-horizontal justify-content-center d-flex ">
                <li class="list-group-item">Doc</li>
                <li class="list-group-item">${candidate.doc}</li>
              </ul>
              <ul class="list-group  list-group-horizontal justify-content-center d-flex ">
                <li class="list-group-item">Email</li>
                <li class="list-group-item">${candidate.email}</li>
              </ul>
              <ul class="list-group  list-group-horizontal justify-content-center d-flex ">
                 <li class="list-group-item">Role</li>
                 <li class="list-group-item">${candidate.role.name}</li>
               </ul>
               <ul class="list-group  list-group-horizontal justify-content-center d-flex ">
                   <li class="list-group-item">Portfolio</li>
                   <li class="list-group-item">${candidate.portfolio}</li>
                 </ul>
           <ul class="list-group  list-group-horizontal justify-content-center d-flex ">
                 <li class="list-group-item">State Code</li>
                 <li class="list-group-item">${candidate.stateCode.initials}</li>
               </ul>
            </div>
        </div>
         <div class="row">
                <div class="col mt-3">
                    <div class="justify-content-center align-items-center d-flex">
                        <a class="btn btn-primary mr-3" href="/../update?id=${candidate.id}" class="btn btn-primary">Update</a>
                        <a href="/..">Back to list</a>
                      </div>
                </div>
            </div>
</div>
</body>
</html>