<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Student</title>
</head>
<body>
	
<div class="container">

<div class="page-header">
    <h2>Registration form</h2>
</div>

<!-- Registration form - START -->
<div class="container">
    <div class="row">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Enter First Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Enter Last Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                  <div class="radio">
				      <label><input type="radio" name="gender">Male</label>
				    </div>
				    <div class="radio">
				      <label><input type="radio" name="gender">Female</label>
			    </div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                 <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Enter Mobile" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <textarea name="InputMessage" id="address" class="form-control" rows="5" placeholder="Enter Address" required></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <input type="button" name="submit" id="submit" value="Submit" class="btn btn-info pull-right" onclick="sendData()">
            </div>
        
        <div class="col-lg-5 col-md-push-1">
            <div class="col-md-12">
                <div class="alert alert-success">
                    <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
                </div>
                <div class="alert alert-danger">
                    <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Registration form - END -->

</div>
</body>
<script>
function sendData() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:9090/Server/restServices/UserService/create',
        data: formToJSON(),
        dataType: "json",
        contentType: 'application/json',
        success : function(data) {
            alert("success saveRule: " + data);
        },
        error : function(request, status, error) {
            alert("error saveRule: " + request.responseText + status + error);
        }
    });
}

function formToJSON() {
    return JSON.stringify({
        "firstname": $('#firstname').val(),
        "lastname": $('#lastname').val(),
        "gender": $('#gender').val(),
        "email": $('#email').val(),
        "mobile": $('#mobile').val()
        });
}
</script>
</html>