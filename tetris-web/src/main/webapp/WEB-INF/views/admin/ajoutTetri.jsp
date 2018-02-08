<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Ajout d'un tetrimino" />
	<tiles:putAttribute name="content">
		
		<form:form method="post" modelAttribute="tetrimino">
			<!-- <div class="form-group">
				<label for="largeur">Largeur</label> 
				<input id="largeur" class="form-control" name="largeur" type="text" value="${ largeur }" /> 
			</div>
			<div class="form-group">
				<label for="hauteur">Hauteur</label> 
				<input id="hauteur" class="form-control" name="hauteur" type="text" value="${ hauteur }" />
			</div>  -->
			
			<div class="form-group">
				<label for="nom">Nom</label> 
				<input id="nom" class="form-control" name="nom" type="text" value="${ tetrimino.nom }" />
			</div>
			<div class="form-group">
				<label for="couleur">Couleur</label> 
				<input id="couleur" class="form-control" name="couleur" type="text" value="${ tetrimino.couleur }" />
			</div>
		
			<div>
				<table>
					
				<c:forEach var="i" begin="0" end="2" step="1">
					<tr>
						<c:forEach var="j" begin="0" end="2" step="1">
							<td><input type="checkbox" name="checkbox-${i}-${j}" class="btn btn-primary"><td>
						</c:forEach>
					</tr>
				</c:forEach>
				</table>
			</div>

			<div>
				<button type="submit" class="btn btn-primary">Soumettre</button>
			</div>
		</form:form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>