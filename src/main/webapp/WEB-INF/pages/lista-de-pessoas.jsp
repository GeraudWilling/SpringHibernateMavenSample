<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Lista de Pessoas - Sprg+Hbrt+Mvn</title>
</head>
<body>
	<h1>Lista de Pessoas</h1>
	<table border="1px" cellpadding="0" cellspacing="0" >
		<thead>
		<tr>
			<th width="10%">id</th><th width="15%">nome</th><th width="10%">país</th><th width="10%">acoes</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="pessoa" items="${pessoas}">
				<tr>
					<td>${pessoa.id}</td>
					<td>${pessoa.name}</td>
					<td>${pessoa.country}</td>
					<td>
						<a href="${pageContext.request.contextPath}/pessoa/edit/${pessoa.id}.html">editar</a><br/>
						<a href="${pageContext.request.contextPath}/pessoa/delete/${pessoa.id}.html">excluir</a><br/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>