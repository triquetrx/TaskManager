<%@ include file="common/head.jspf" %>
<%@ include file="common/navbar.jspf" %>
	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<div class="form-group">
				<label for="desc">Task Name</label> 
				<form:input type="text" class="form-control" id="desc" path="desc" required="required"/>
				<form:errors cssClass="text-warning" path="desc"/>
			</div>
			<div class="form-group">
				<label for="tododate">Task End Date</label> 
				<form:input type="date" class="form-control" id="date" path="todoDate" required="required"/>
				<form:errors path="todoDate" cssClass="text-warning"/>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Add Task" name="add" required />
			</div>
		</form:form>
	</div>
<%@include file="common/end.jspf" %>