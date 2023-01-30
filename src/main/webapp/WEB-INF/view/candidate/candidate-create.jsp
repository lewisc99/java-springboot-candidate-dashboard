<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Create Candidates</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center">
        <div class="col col-lg-8 ">
          <header>
          </header>
          <h3>Create Candidate</h3>
          <form:form action="saveCustomer" modelAttribute="candidate" method="POST">
            <form:hidden path="id" />
           <div class="form-group">
                <label for="username">Username: </label>
                <form:input type="text" id="username" path="username"   placeholder="enter an Username" class="form-control"/>
            </div>
             <div class="form-group">
                <label for="email">Email: </label>
                <form:input type="text" id="email" path="email"   placeholder="enter an Email" class="form-control"/>
            </div>
             <div class="form-group">
                <label for="doc">Doc: </label>
                <form:input type="text" id="doc" path="doc"   placeholder="enter an Doc" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="portfolio">Portfolio Link: </label>
                <form:input type="text" id="portfolio" path="portfolio"   placeholder="enter a Portfolio Link" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="Role">Role: </label>
                <select class="form-control" id="role">
                 <c:forEach var="tempRole" items="${candidate.role}">
                  <option  path="role">
                     ${tempRole.name}
                </option>
                </c:forEach>
                </select>
              </div>

        </form:form>
        <div class="md-3">
        <p> <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>

        </form>
        </div>
    </div>
</div>
</body>
</html>