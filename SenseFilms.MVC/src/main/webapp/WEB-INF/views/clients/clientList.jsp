<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../partialViews/shared/header.jsp" />
    <div class="container" id="clientComponent">
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
                <tbody id="clientsTable">           
	                    <tr v-for="client in clientsData.data">
							<td>
								<span class="custom-checkbox">
									<input type="checkbox" name="options[]" value="1">
									<label for="checkbox1"></label>
								</span>
							</td>
							<td name="clientId" class="hidden">{{ client.id }</td>
	                        <td>{{ client.name }}</td>
	                        <td>{{ client.lastName }}</td>
	                        <td>{{ client.clientType }}</td>
	                        <td>{{ client.email }}</td>
	                        <td>
	                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
	                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
	                        </td>
	                    </tr>
                </tbody>
            </table>
			<div class="clearfix">
                <div class="hint-text">Showing <b>{{ clientsData.currentPage }}</b> out of <b>{{ clientsData.totalPages }}</b> pages</div>
                <ul class="pagination">
                    <li class="page-item" v-show="clientsData.previousPage"><a v-on:click="previousPage" class="page-link">Previous</a></li>
                    <li class="page-item" v-for="(url, pageNumber) in clientsData.previousPagesNumbers"> <a v-on:click="loadPage(url)">{{ pageNumber }}</a></li>
                    <li class="page-item active"> <a>{{ clientsData.currentPage }}</a></li>
                    <li class="page-item" v-for="(url, pageNumber) in clientsData.nextPagesNumbers"> <a v-on:click="loadPage(url)">{{ pageNumber }}</a></li>
                    <li class="page-item" v-show="clientsData.nextPage"><a v-on:click="nextPage" class="page-link">Next</a></li>
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
		var urlClients = '<c:url value="/ManageClientsController/pagedClients?pageSize=2&currentPage=1" />';

		function getClientsUrl(){
			return urlClients;
		}		
		
		function onClientsDelete(){		
			var clientsToDelete = getSelectedIds('clientsData', 'clientId');
			if(clientsToDelete.length === 0){
				showMessage('Please, select at least one client.');
				return;
			}
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
		
		function showMessage(message){
			alert(message);
		}
		</script>

	<script src="<c:url value="/resources/vuejs/components/clientList.js" />"></script>
</body>
</html>