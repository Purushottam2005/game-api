<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>Games</h2>
<table class="table table-striped table-bordered col-lg-12">
	<thead>
	<tr>
		<th>
			Name:
		</th>
		<th class="width-1">
			Year:
		</th>
		<th class="number-cell width-1">
			Price:
		</th>
		<th>
		</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${games}" var="game">
		<tr class="hoverable">
			<td><a class="table-anchor"
				   href="${pageContext.request.contextPath}/game/edit/${game.id}">${game.name}</a></td>
			<td class="width-1">${game.year}</td>
			<td class="number-cell">${game.price}</td>
			<td class="width-1">
				<c:set value="${game}" scope="request" var="game"/>
				<form:form id="delete-game-${game.id}" action="${pageContext.request.contextPath}/game/delete/${game.id}"
						   cssClass="button-group delete-form form-inline btn-group" method="DELETE">
					<button class="btn btn-default btn-sm" type="submit"><span class="glyphicon glyphicon-remove"/>
					</button>
				</form:form>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath}/addGame">
	<button class="btn btn-default">Add Game</button>
</a>