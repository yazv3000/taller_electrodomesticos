<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page session="true" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es-PE">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${context}/css/servicios-2.css">
</head>

<body>
    <h1 class="titulo">Nuestros <span>Servicios</span></h1>
    <div class="contenedor">
        <div class="cont__servicio">
        
             <c:forEach items="${lstServicios}" var="s">          
             <!-- ==== TARJETA ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo">
                    <div class="hex__img">
                        <c:choose>
                        <c:when test="${s.getRutaImgServicio()==null}">
                        	<img src="${context}/img/servicios/default.png" alt="" >
                        </c:when>
                        <c:otherwise>
					        <img src="${context}/${s.getRutaImgServicio()}" alt="" >
					    </c:otherwise>
                        </c:choose>
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo"><c:out value="${s.getNomServicio()}"></c:out> </h3>
                    <p class="serv__descripcion"><c:out value="${s.getDescripcion()}"></c:out></p>
                    <form action="${context}/ServletHorariosDisponibles" method="post" novalidate>
                    	<input type="hidden" name="id_servicio" value="${s.getIdServicio()}" />
                    	<button class="serv__link" type="submit" name="accion" value="listar">Solicitar</button>
                	</form>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>