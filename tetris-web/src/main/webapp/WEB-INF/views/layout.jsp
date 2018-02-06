<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="/tetris-web/css/bootstrap.min.css"/>

<body>

	<div class="container">
		<h1>
			<tiles:insertAttribute name="title1" />
		</h1>
	
		<nav>
			<tiles:insertAttribute name="navigation" />
		</nav>
		
		<tiles:insertAttribute name="content" />
	</div>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>