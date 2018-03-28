<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
<script src="<c:url value="/resources/bootstrap/css/bootstrap.min.js" />"></script>
</head>
<body>
<div class="card">
		<form name="recoverPasswordForm" action="<c:url value="/ManagePasswordController/sendNewPassword" />" method="post" class="align-middle">
  				 <!--Header-->
			<div>
            	<h3>Generate new password:</h3>
            </div>
            
            <div>
                <input type="text" id="username" class="form-control" name="username">
                <label for="username">Your username</label>
            </div>
            
            <div>
            	<span class="error-message">${errorMessage}</span>
            </div>                                 
                                      
            <div class="text-center">
            	<button type="submit">Reset Password</button>
            </div>
            
                            <!--Footer-->
            <div class="modal-footer">
            	<div>
                    <a href="<c:url value="/" />">Go Back</a>
                </div>
            </div>                                                                         
		</form>           
	</div>
</body>
</html>