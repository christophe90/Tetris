<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="app.layout">
<tiles:putAttribute name="title1" value="Foire aux question" />
<tiles:putAttribute name="content">


	<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Liste des questions </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ faq }" var="faq">
						<tr>
							<td>${ faq.questions }</td>
							<td><a class="btn btn-secondary" href="/tetris-web/admin/faq/editer/${faq.id}" role="button">Modifier</a>
							<a class="btn btn-danger" href="/tetris-web/admin/faq/supprimer/${faq.id}"role="button">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
			<div>
				<a class="btn btn-primary" href="/tetris-web/admin/faq/editer" role="button">Ajouter une nouvelle question</a>
			</div>

</tiles:putAttribute>
</tiles:insertDefinition>