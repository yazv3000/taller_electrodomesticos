<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html lang="es-PE">
<head>
	<meta charset="ISO-8859-1">
     <link rel="stylesheet" type="text/css" href="${context}/css/tabla.css">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
</head>

<body>
	<div class="contenido">
		<h1 class="titulo">CITAS <span>RESERVADAS</span></h1>
	    <div class="tabla" id="myTable">
	        <div class="tabla__tools">
	            <ul>
	            	<li><button class="fa-solid fa-plus-square icono" onclick="location.href='ServletServicios'"></button></li>
	            </ul>
	        </div>
	        <div class="tabla__contenido">
	            <table>
	                <thead class="tabla__titulo">
	                    <tr>
	                        <th>ID</th>
							<th>Técnico</th>
	                        <th>Fecha</th>
	                        <th>Hora</th>
	                        <th>Servicio</th>
	                        <th>Electrodomestico</th>
	                    </tr>
	                </thead>
	                <tbody class="tabla__info">
	                	<c:forEach items="${lstCitasCliente}" var="ci">
	                    <tr id="tabla__filas" class="now-selected">
	                    	  <td class="tabla__columna"><c:out value="${ci.getIdAtencion()}"></c:out></td>
	                    	<td class="tabla__columna"><c:out value="${ci.getNombreTecnico()}"></c:out></td>
							<td class="tabla__columna"><c:out value="${ci.getFechaAtencion()}"></c:out></td>
	                        <td class="tabla__columna"><c:out value="${ci.getHoraAtencion()}"></c:out></td>
	                        <td class="tabla__columna">Reparacion</td>
	                        <td class="tabla__columna"><c:out value="${ci.getTipoElectrodomestico()}"></c:out></td>
						</tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	    </div>
	</div>
</body>
</html>