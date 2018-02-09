<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Ajout d'un tetrimino" />
	<tiles:putAttribute name="content">
		
		
		<form:form method="post" modelAttribute="tetrimino" action="/tetris-web/admin/ajoutTetri/taille">
			<div class="form-group">
				<label for="hauteur">Hauteur du tetrimino</label> 
				<input id="hauteur" class="form-control" name="hauteur" type="text" value="${ hauteur }" />
			</div>
			<div class="form-group">
				<label for="largeur">Largeur du tetrimino</label> 
				<input id="largeur" class="form-control" name="largeur" type="text" value="${ largeur }" /> 
			</div>
			<div>
				<button type="submit" class="btn btn-primary">afficher le tetrimino</button>
			</div>
		</form:form>
		
		<form:form method="post" modelAttribute="tetrimino" action="/tetris-web/admin/ajoutTetri/soumettre"  accept-charset="ISO-8859-1">
			
			<div class="form-group">
				<label for="nom">Nom</label> 
				<input id="nom" class="form-control" name="nom" type="text" value="${ tetrimino.nom }" />
			</div>
			<div class="form-group">
				<label for="couleur">Couleur</label> 
				<form:select path="couleur" items="${ tetrimino.couleur }" itemLabel="couleur" itemValue="id" cssClass="form-control" >
   				 	<option>bleu</option>
  				</form:select>
			</div>
			
				<div class="form-group row">
					<label for="couleur" class="col-sm-2 col-form-label">Couleur</label>
				<div class="col-sm-10>">
					<form:select path="${ couleur }" items="${tetrimino.couleur}"
						itemLabel="couleur" itemValue="id" cssClass="form-control" />
				</div>
				</div>

			<div>
			
				<c:if test="${ hauteur>0 }" >
				<c:if test="${ largeur>0 }" >
				<table>
				<c:forEach var="i" begin="0" end="${ hauteur-1 }" step="1">
					<tr>
						<c:forEach var="j" begin="0" end="${ largeur-1 }" step="1">
							<td><input type="checkbox" name="checkbox-${i}-${j}" class="btn btn-primary"><td>
						</c:forEach>
					</tr>
				</c:forEach>
				</table>
				
				</c:if>
				</c:if>
				
			</div>
			
			<div>
				<input type="hidden" name="hauteur" value="${ hauteur }" />
				<input type="hidden" name="largeur" value="${ largeur }" />
			</div>

			<div>
				<button type="submit" class="btn btn-primary">Soumettre</button>
			</div>
		</form:form>
		
	</tiles:putAttribute>
</tiles:insertDefinition>