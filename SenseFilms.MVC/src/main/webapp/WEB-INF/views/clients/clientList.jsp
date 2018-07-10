<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../partialViews/shared/header.jsp" />
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Clients</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Client</span></a>
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>First Name</th>
                        <th>Last Name</th>
						<th>ClientType</th>
						<th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="clientsData">
                	<c:forEach var="client" items="${clientsList}">
	                    <tr>
							<td>
								<span class="custom-checkbox">
									<input type="checkbox" name="options[]" value="1">
									<label for="checkbox1"></label>
								</span>
							</td>
							<td name="clientId"><c:out value="${client.id}"/></td>
	                        <td><c:out value="${client.name}"/></td>
	                        <td><c:out value="${client.lastName}"/></td>
	                        <td><c:out value="${client.clientType}"/></td>
	                        <td><c:out value="${client.email}"/></td>
	                        <td>
	                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
	                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
	                        </td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
			<div class="clearfix">
                <div class="hint-text">Showing <b>CurrentPageNumber</b> out of <b>TotalPages</b> pages</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
    
    <section>
    	<jsp:include page="../clients/editClientPopUp.jsp" />
    </section>
    <section>
    	<jsp:include page="../clients/deleteClientPopUp.jsp" />
    </section>
    
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Add Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Phone</label>
							<input type="text" class="form-control" required>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
		<script type="text/javascript">
	var deleteClientEndpoint = '<c:url value="/ManageClientsController/deleteClients" />';
	
	function onClientsDelete(){		
		var clientsToDelete = getSelectedIds('clientsData', 'clientId');

		$.ajax({ 
			type : 'DELETE',
			contentType : 'application/json',
			url : deleteClientEndpoint,
			data: JSON.stringify(clientsToDelete),
			success : function(data) {
				console.log('Success');
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
		});
	}
	
	function getSelectedIds(tblId, columnName){
		var selectedIds = new Array();
		var clientsRows = $("tbody#" + tblId);
		
		clientsRows.find('tr').each(function(i, row){	
			var checkbox = $(this).find("input[type='checkbox']");
			if(checkbox.prop('checked')){
				var id = $(this).find('td[name=' + columnName + ']').text();
				selectedIds.push(id);
			}
		});		
		return selectedIds;
	}
	</script>
</body>
</html>