<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Editer une question" />
	<tiles:putAttribute name="content">

		<form:form method="POST" modelAttribute="faq">
			<div class="form-group">
				<label for="questions">Question</label> 
				<input id="questions" class="form-control" name="questions" type="text" value="${ faq.questions }" />
			</div>
			<div class="form-group">
				<label for="reponse">Reponse</label> 
				<input id="reponse" class="form-control" name="reponse" type="text" value="${ faq.reponse }" />
			</div>
			<form:errors path="questions" element="div" cssClass="alert alert-danger" />
			<form:errors path="reponse" element="div" cssClass="alert alert-danger" />
			<div>
				<button type="submit" class="btn btn-primary">Soumettre</button>
			</div>
		</form:form>

	</tiles:putAttribute>
</tiles:insertDefinition>