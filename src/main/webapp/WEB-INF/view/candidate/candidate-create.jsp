<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Create Candidates</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style>
.error {
    color:red;
}
</style>
</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center">
        <div class="col col-lg-8 ">
          <header>
          </header>
          <h3>Create Candidate</h3>
          <form:form action="createdCandidate" modelAttribute="candidate" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
           <div class="form-group">
                <label for="username">Username: </label>
                <form:input type="text" id="username" path="username"   placeholder="enter an Username" class="form-control"/>
                <form:errors path="username" cssClass="error" />
            </div>
             <div class="form-group">
                <label for="email">Email: </label>
                <form:input type="text" id="email" path="email"   placeholder="enter an Email" class="form-control"/>
                <form:errors path="email" cssClass="error" />
            </div>
             <div class="form-group">
                <label for="doc">Doc: </label>
                <form:input type="text" id="doc" path="doc"   placeholder="enter an Doc" class="form-control"/>
                 <form:errors path="doc" cssClass="error" />
            </div>
             <div class="form-group">
                <label for="roles">Roles: </label>
               <select  class="form-control"  name="roleId">
                        <c:forEach var="tempRole" items="${candidate.roles}">
                          <option id="roles" value="${tempRole.id}">${tempRole.name}</option>
                        </c:forEach>
                      </select>
              </div>

            <div class="form-group">
                <label for="portfolio">Portfolio Link: </label>
                <form:input type="text" id="portfolio" path="portfolio"   placeholder="enter a Portfolio Link" class="form-control"/>
                 <form:errors path="portfolio" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="statecode">State Code: </label>
               <select  class="form-control" name="stateCodeId">
                        <c:forEach var="tempStateCode" items="${candidate.stateCodes}">
                          <option id="statecode" value="${tempStateCode.id}">${tempStateCode.initials}</option>
                        </c:forEach>
                      </select>
              </div>

        <div class="form-group flex-row">
                <input type="submit" value="Create" class="btn btn-primary"/> |
                 <a href="${pageContext.request.contextPath}/" class="ml-2">Back to list</a>
        </div>
        </form:form>
        </form>
        </div>
    </div>
</div>
</body>
</html>