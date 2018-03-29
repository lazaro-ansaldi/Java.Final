<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New Password</title>
	<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/bootstrap/css/bootstrap.min.js" />"></script>
</head>
<body>



<div class="card">
		<form name="recoverPasswordForm" action="<c:url value="/ManagePasswordController/updateNewPassword/${usernameParam}" />" method="post" class="align-middle">  			
			<div>
            	<h3>Change password</h3>
            </div>
            
            <div>
                <input type="password" id="currentPassword" class="form-control" name="currentPassword">
                <label for="currentPassword">Current password</label>
            </div>
            
            <div>
                <input type="password" id="newPassword" class="form-control" name="newPassword">
                <label for="newPassword">New password</label>
            </div>
            
            <div>
                <input type="password" id="confirmPassword" class="form-control" name="confirmPassword">
                <label for="confirmPassword">Current password</label>
            </div>
            
            <div>
            	<span class="error-message">${errorMessage}</span>
            </div>                                 
                                      
            <div class="text-center">
            	<button type="submit">Update password</button>
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