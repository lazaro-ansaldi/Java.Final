<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<c:url value="/resources/css/core.css" />" rel="stylesheet">
<!-- Loading Bootstrap -->
<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<!-- Loading Font Awesome Icons -->
<link href="<c:url value="/resources/css/font-awesome.min.css" />"	rel="stylesheet">
<!-- Loading Drunken Parrot UI -->
<link href="<c:url value="/resources/css/drunken-parrot.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/demo.css" />" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <a class="navbar-brand" href="<c:url value="/HomeController/index" />">Sense Films</a>
  </div>
  

  <ul id="mainMenuNode" class="nav navbar-nav">   
 
    <li class="dropdown">    
      <ul id="childMenuNode" class="dropdown-menu">
      </ul>        
    </li>
  </ul>
  <ul class="nav navbar-nav navbar-right navbar-icons">
	  <li class="dropdown">
	     <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
	     	<span class="fa fa-user"></span>	     
	     </a>
	       
	       <ul class="dropdown-menu">
	       		<li> 
	       			<a href="<c:url value="/AccountController/changePassword" />">
	       				<span>Change Password</span> 
	       			</a>
	       		</li>
	       </ul>	     
	  </li>
	   
	  <li>
      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <span class="fa fa-cog"></span>
      </a>
    </li> 
  </ul>
  <p class="navbar-text navbar-right"><a href="#" class="navbar-link">${userCompleteName}</a></p>
</nav>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/checkbox.js" />"></script>
	<script src="<c:url value="/resources/js/radio.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-switch.js" />"></script>
	<script src="<c:url value="/resources/js/toolbar.js" />"></script>
	<script src="<c:url value="/resources/js/application.js" />"></script>

<script type="text/javascript">
	$(document).ready(function($) {
		populateMenu();
	});
	
	function populateMenu() {
		$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url : '<c:url value="/HomeController/getMenuItems" />',
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					buildMenu(data);
				},
				error : function(e) {
					console.log("ERROR: ", e);
				},
			});
		}
	
	function buildMenu(data){
		var mainMenuNode = $('#mainMenuNode');
		
		$.each(data, function() {
			var parentElement = '<li class="dropdown">'
			+ '<a href="' + this.itemUrl + ' class="dropdown-toggle" data-toggle="dropdown"> ' + this.description + '<span class="fa fa-chevrondown"></span></a>'       
			+ '<ul class="dropdown-menu">';					
				
			$.each(this.subItemsCollection, function(){	
				var childElement = '<li><a href="<c:url value = "' + this.itemUrl + '"/>">' + this.description + '</a></li>';							
				parentElement += childElement;
			});
			
			mainMenuNode.append(parentElement);
		});		
	}
</script>
</body>
</html>