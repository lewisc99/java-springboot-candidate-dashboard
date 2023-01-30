<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>List Candidates</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
thead.table-primary {
       background-color: blue;
}
</style>
</head>
<body>
<div class="container">
<div class="row d-flex flex-column">
  <div class="col  col-xxl">
      <header class="align-center mb-5">
        <div id="header">
         <img src="http://www.seasolutions.io/image/layout_set_logo?img_id=90106&t=1643032726158"/>
      </header>
   	    <title>Bootstrap 5 404 Error Page</title>
            <div class="text-center">
                <h1 class="display-1 fw-bold">404</h1>
                <p class="fs-3"> <span class="text-danger">Opps!</span> Page not found.</p>
                <p class="lead">
                    The page you are looking for doesnt exist.
                    </p>
                 <a href="${pageContext.request.contextPath}/" class="ml-2 btn btn-primary">Back to list</a>
        </div>
</div>
</div>
</div>


</body>
</html>