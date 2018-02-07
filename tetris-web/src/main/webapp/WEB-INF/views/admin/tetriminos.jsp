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
					<th> </th>
					<th> </th>
				</tr>
				<c:forEach items="${tetriminos}" var="tetri">
					<tr>
						<td>${tetri.id}</td>
						<td>${tetri.nom}</td>
						<td>${tetri.couleur}</td>
						<td>
							<table>
								<c:forTokens items = "${tetri.str}" delims = "/" var="ligne">
									<tr>
									<c:forTokens items = "${ligne}" delims = "," var="carac">
										<c:if test="${carac == 1}">
											<td class="bg-warning"></td>
										</c:if>
										<c:if test="${carac == 0}">
											<td class="table-light"></td>
										</c:if>
									</c:forTokens>
									</tr>
								</c:forTokens>
							</table>
						</td>
						<td><a href="/tetris-web/admin/tetrimino/${login}/activerTetri?id=${tetri.id}" class="btn btn-outline-primary" value="Activer"> Activer</a>
						<a href="/tetris-web/admin/tetrimino/${login}/desactiverTetri?id=${tetri.id}" class="btn btn-outline-danger" value="Désactiver"> Désactiver</a></td>
						<td><button href="/tetris-web/admin/tetrimino/${login}/modifierTetri?id=${tetri.id}" type="button" class="btn btn-outline-secondary">Modifier</button></td>
					</tr>
				</c:forEach>
			</table>
			
			<a  href="/projetSpringMVC/produits/ajoutTetri" class="btn btn-outline-success" value="Ajouter"> Ajouter un tetrimino</a>
	</tiles:putAttribute>
</tiles:insertDefinition>