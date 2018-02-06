<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Edition du produit" />
	<tiles:putAttribute name="content">
	
		<form:form method="post" modelAttribute="produit">
			<table>
				<tr>
					<td><form:label path="adminName">Nom</form:label></td>
				    <td><form:input path="adminName" /></td>
			    </tr>
				<tr>
				    <td><form:label path="password">Mot de passe</form:label></td>
				    <td><form:input path="password" /></td>
			    </tr>
			</table>
		    
		    <button type="submit" class="btn btn-outline-success" value="Se connecter"> </button>
		</form:form>	
	</tiles:putAttribute>
</tiles:insertDefinition>