<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag dynamic-attributes="true"  %>
<%@attribute name="cssClass" required="false" %>

<c:if test="${not empty messageCode }">
	<div class="${cssClass}">
		<spring:message code="${messageCode}" arguments="${messageArguments}" argumentSeparator="," />
	</div>
</c:if>