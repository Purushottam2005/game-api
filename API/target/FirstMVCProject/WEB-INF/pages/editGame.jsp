<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="comp" tagdir="/WEB-INF/tags/components" %>
<h2 class="col-lg-12">${titleAttr}</h2>
<form:form modelAttribute="game" method="POST" cssClass="" action="${pageContext.request.contextPath}/${actionUrl}">
	<comp:formgroup path="name" label="Name" />
	<comp:formgroup path="price" label="Price" type="number" />
	<comp:formgroup path="year" label="Release Year" type="number" />
	<form:hidden path="id" />
	<div class="form-group">
		<div>
			<button id="submit" class="btn btn-default">Save</button>
			<a href="${pageContext.request.contextPath}/index">
				<button type="button" class="btn btn-default">List</button>
			</a>
		</div>
	</div>
	<comp:feedback cssClass="feedback"></comp:feedback>
</form:form>
