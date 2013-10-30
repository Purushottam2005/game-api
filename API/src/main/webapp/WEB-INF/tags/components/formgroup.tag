<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag dynamic-attributes="true"  %>
<%@attribute name="path" required="true" %>
<%@attribute name="label" required="true" %>
<%@attribute name="type" required="false" %>

<c:set var="errors"><form:errors path="${path}"/></c:set>

<div class="form-group ${empty errors?'':' has-error'}">
	<form:label path="${path}" cssClass="control-label">${label}:</form:label>
	<div>
		<form:input type="${not empty type?type:'text' }" placeholder="${label}" path="${path}" cssClass="form-control"/>
	</div>
	<form:errors cssClass="error" path="${path}" />
</div>