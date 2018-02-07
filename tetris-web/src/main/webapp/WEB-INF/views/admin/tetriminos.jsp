<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Liste des tetriminos" />
	<tiles:putAttribute name="content">
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Couleur</th>
					<th>String</th>
				</tr>
				<c:forEach items="${tetriminos}" var="tetri">
					<tr>
						<td>${tetri.id}</td>
						<td>${tetri.nom}</td>
						<td>${tetri.couleur}</td>
						<td>${tetri.str}</td>
					</tr>
				</c:forEach>
			</table>
	</tiles:putAttribute>
</tiles:insertDefinition>