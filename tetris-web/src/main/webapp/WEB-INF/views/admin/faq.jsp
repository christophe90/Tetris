<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="app.layout">
<tiles:putAttribute name="title" value="Foire aux question" />
<tiles:putAttribute name="content">


	<p>Test Christophe</p>
	
	<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"> Liste des questions </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ produits }" var="produits">
						<tr>
							<td>${ faq.question }</td>
							<td><a class="btn btn-secondary" href="/tetris-web/admin/faq/editer/${produits.id}" role="button">Modifier</a></td>
							<td><a class="btn btn-danger" href="/tetris-web/admin/faq/supprimer/${produits.id}"role="button">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	
			<div>
				<a class="btn btn-primary" href="/tetris-web/admin/faq/ajouter" role="button">Ajouter une nouvelle question</a>
			</div>

</tiles:putAttribute>
</tiles:insertDefinition>