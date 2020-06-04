<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>

		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
		<meta charset="UTF-8">
	</head>
	
	<body>
	<div class="container-fluid">

    
     <nav class="navbar  navbar-dark bg-dark navbar-expand-lg">
  <a class="navbar-brand" href="#">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

			<ul class="navbar-nav mr-auto">
			  <li class="nav-item mr-auto"><a class="nav-link" href="#"></a></li>
			  <li class="nav-item mr-auto"><a class="nav-link" href=" <c:url value='/home/index'/> ">Home</a></li>
			  <li class="nav-item mr-auto"><a class="nav-link" href=" <c:url value='/tienda/todas'/> ">Tiendas</a></li>
			   <li class="nav-item mr-auto"><a class="nav-link" href=" <c:url value='/perfil/cargar-foto'/> ">Actualizar foto de perfil</a></li>
			</ul>
			<span>
				<c:choose>
					<c:when test="${not empty sessionScope.EMAIL}">						

						<span class="glyphicon glyphicon-user"></span> <span class="text-white nav-item">${sessionScope.EMAIL} </span>
						<a class="nav item text-white" href=" <c:url value='/logout'/> "><span class="glyphicon glyphicon-log-out"></span> Salir</a>

					</c:when>
					<c:otherwise>
						<span><a class="nav-link text-white" href=" <c:url value='/login'/> "><span class="glyphicon glyphicon-log-out"></span> Iniciar sesi&oacute;n</a></span>
					</c:otherwise>
				</c:choose>
			<span>
		</div>
	</nav>