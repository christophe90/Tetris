<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title1" value="Bienvenue sur l'interface administrateur" />
	<tiles:putAttribute name="content">
 		Bonjour ${login} !
	</tiles:putAttribute>
</tiles:insertDefinition>