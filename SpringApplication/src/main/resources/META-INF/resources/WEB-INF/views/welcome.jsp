<%@ include file="common/head.jspf" %>
<%@ include file="common/navbar.jspf" %>
	<div class="container">
		
		<h5 class="text-secondary">Your List:</h5>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Update</th>
					<th>Done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todoList}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.desc}</td>
						<td>${todo.todoDate}</td>
						<td><a href="/edit?id=${todo.id}">Edit</a></td>
						<td><c:if test="${not todo.isDone}">
								<a href="/done?id=${todo.id}">Yes</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@include file="common/end.jspf" %>