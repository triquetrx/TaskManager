<%@ include file="common/head.jspf" %>
<%@ include file="common/navbar.jspf" %>
	<div class="container">
		<form:form method="POST" modelAttribute="todo">
			<div class="form-group">			
				<label for="desc">Description</label>
				<form:input cssClass="form-control" type="text" id="desc" path="desc"/>
				<form:errors path="desc"/>
			</div>
			<div class="form-group">			
				<label for="todoDate">Date</label>
				<form:input cssClass="form-control" type="date" id="todoDate" path="todoDate"/>
				<form:errors path="todoDate"/>
			</div>
			<br/>
			<input type="submit" class="btn btn-danger" value="Update"/>
		</form:form>
	</div>
<%@include file="common/end.jspf" %>