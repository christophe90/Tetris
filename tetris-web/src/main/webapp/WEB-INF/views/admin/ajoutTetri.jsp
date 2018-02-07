<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Ajout d'un tetrimino" />
	<tiles:putAttribute name="content">
		
		<form:form method="post" modelAttribute="tetrimino">
			<table>
				<tr>
					<td><form:label path="nom">Nom</form:label></td>
				    <td><form:input path="nom" /></td>
			    </tr>
				<tr>
				    <td><form:label path="couleur">Couleur</form:label></td>
				    <td><form:input path="couleur" /></td>
			    </tr>
			    <tr>
				    <td><form:label path="str">Forme</form:label></td>
				    <td><form:input path="str" /></td>
			    </tr>
			</table>
		    
		    <button type="submit" class="btn btn-outline-success" value="Valider">Valider</button>
		</form:form>
		
		
	</tiles:putAttribute>
</tiles:insertDefinition>