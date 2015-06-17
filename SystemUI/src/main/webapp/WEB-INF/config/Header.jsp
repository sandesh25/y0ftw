<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WIT Solapur</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Staff <span class="caret"></span></a>
          <ul class="dropdown-menu">
          	<li><a href="#">Staff</a></li>
            <li><a href="#">Add new</a></li>
            <li><a href="#">Update</a></li>
            <li><a href="#">Delete</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Student<span class="caret"></span></a>
          <ul class="dropdown-menu">
          	<li><a href="#">Students</a></li>
            <li><a href="addNewStudent">Add new</a></li>
            <li><a href="#">Update</a></li>
            <li><a href="#">Delete</a></li>
          </ul>
        </li>
        <li><a href="#">Settings</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
</body>
</html>
