<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

<!-- Bootstrat Core -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Material Design -->
<link href="css/mdb.min.css" rel="stylesheet" />

<!-- Application Core Styles -->
<link href="css/coreStyles.css" rel="sylesheet"/>
</head>

<body>
	<div class="card" style="width: 28rem;">
		<form name="loginForm" action="Login" method="post">
  				 <!--Header-->
			<div class="form-header default-color">
            	<h3><i class="fa fa-lock"></i> Login:</h3>
            </div>
            
                        <!--Body-->
            <div class="md-form">
            	<i class="fa fa-envelope prefix grey-text"></i>
                <input type="text" id="defaultForm-email" class="form-control" name="username">
                <label for="defaultForm-email">Your username</label>
            </div>
            
            <div class="md-form">
            	<i class="fa fa-lock prefix grey-text"></i>
                <input type="password" id="defaultForm-pass" class="form-control" name="password">
                <label for="defaultForm-pass">Your password</label>
            </div>
            
            <div>
            	<label>${errorMessage}</label>
            	<%session.removeAttribute("errorMessage");%>
            </div>                                 
                                      
            <div class="text-center">
            	<button type="submit" class="btn btn-default waves-effect waves-light">Login</button>
            </div>
            
                            <!--Footer-->
            <div class="modal-footer">
            	<div class="options">
                	<p>Not a member? <a href="#">Sign Up</a></p>
                    <p>Forgot <a href="#">Password?</a></p>
                </div>
            </div>                                                                         
		</form>           
	</div>
        
        <!-- JQuery -->
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        
        <!-- Bootstrap -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        
        <!-- Popper -->
        <script type="text/javascript" src="js/popper.min.js"></script>
</body>
</html>