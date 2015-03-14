<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Editar - Sprg+Hbrt+Mvn</title>
</head>
<body>
	<h1>Editar Pessoa</h1>
	<p>${mensagem}</p>
	<form:form method="POST" commandName="pessoa" action="${pageContext.request.contextPath}/pessoa/edit/${pessoa.id}.html">
		<table>
			<tbody>
				<tr>
					<td>Nome:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>País:</td>
					<td><form:input path="country" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Editar" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p><a href="${pageContext.request.contextPath}/index.html">voltar</a></p>
</body>
</html>