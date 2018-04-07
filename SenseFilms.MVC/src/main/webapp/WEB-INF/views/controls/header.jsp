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
  

  <ul class="nav navbar-nav">   
   <c:forEach var="item" items="${menuItems}">
 
    <li class="dropdown">
      <a href="<c:url value="${item.itemUrl}" />" class="dropdown-toggle" data-toggle="dropdown"><c:out value="${item.description}"/><span class="fa fa-chevrondown"></span></a>
      <c:forEach var="subItem" items="${item.subItemsCollection}">     
      <ul class="dropdown-menu">
        <li><a href="<c:url value="${subItem.itemUrl}" />"><c:out value="${subItem.description}"/></a></li>
      </ul>
      </c:forEach>    
    </li>
    
    </c:forEach>
  </ul>
  <ul class="nav navbar-nav navbar-right navbar-icons">
	  <li>
	     <a href="<c:url value="/AccountController/changePassword" />">
	       <span class="fa fa-user"></span><span class="hidden-lg">My Account</span>
	     </a>
	  </li> 
	  <li>
      <a href="<c:url value="/ManageUsersController/newUser" />">
        <span class="fa fa-cog"></span><span class="hidden-lg">Settings</span>
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
	
</body>
</html>