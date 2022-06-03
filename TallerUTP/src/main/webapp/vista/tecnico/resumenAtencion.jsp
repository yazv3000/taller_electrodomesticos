<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="${context}/css/ResumenAtencion.css">
<title>Insert title here</title>
</head>
<body>
	<h3 class="cliente" style="text-align:left;">Cliente</h3>
        <div class="grid__seccion">
            <div class="grid__items"><i class="fa-solid fa-user icono"></i><span>Cliente: <c:out value="${ate.getCliente().getNombreCompleto()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-location-dot"></i><span>Distrito: <c:out value="${ate.getCliente().getDistrito()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-mobile-screen-button"></i><span>Telefono: <c:out value="${ate.getCliente().getTelefono()}"></c:out></span></div>
            
        </div>
    <h3 class="cliente" style="text-align:left;">Cita</h3>
        <div class="grid__seccion">
            <div class="grid__items"><i class="fa-solid fa-blender-phone"></i><span>Servicio: <c:out value="${ate.getServicio().getNomServicio()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-calendar"></i><span> Fecha Reserva: <c:out value="${ate.getFechaReservaCita()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-calendar"></i><span>Fecha Cita: <c:out value="${ate.getFechaCita()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-clock"></i><span>Hora Cita: <c:out value="${ate.getHoraCita()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-battery-half"></i><span>Estado Cita: <c:out value="${ate.getEstado()}"></c:out></span></div>
            
        </div>
    <h3 class="cliente" style="text-align:left;">Electrodomestico</h3>
        <div class="grid__seccion">
            <div class="grid__items"><i class="fa-solid fa-blender"></i><span>Electrodomestico: <c:out value="${ate.getElectrodomesticoTipo().getNombre()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-check-to-slot"></i><span>Marca: <c:out value="${ate.getElectrodomesticoMarca().getNombre()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-arrow-down-1-9"></i><span>Número de Serie: <c:out value="${ate.getElectrodomestico().getNroSerie()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-check-to-slot"></i><span>Modelo: <c:out value="${ate.getElectrodomestico().getModelo()}"></c:out></span></div>
            <div class="grid__items"><i class="fa-solid fa-triangle-exclamation"></i><span>Falla: <c:out value="${ate.getFallaDescrita()}"></c:out></span></div>
        </div>
        
        <button type="button"  class="btn btn-info" onclick="location.href='ServletPresupuesto?accion=listar'">Actualizar</button>
       <h3 class="cliente" style="text-align:left;">Actividades</h3>

       <h2>Actividades ofrecidas</h2>
       <c:if test="${lstActividadesOfrecidas!=null}">
	    <table border=1>
		<thead>
		<tr> 
			<th> ACTIVAD </th>
			<th> PRECIO</th>
			<th> ACCION </th>
		</tr>
		</thead>
		<tbody>
	    <c:forEach items="${lstActividadesOfrecidas}" var="ac1">
	    <tr> 
	            <td><c:out value="${ac1.getNombre()}"></c:out></td>
	            <td><c:out value="${ac1.getPrecio()}"></c:out></td>
	            <td >
	                <a href="${context}/ServletPresupuesto?accion=agregar&idActividad=${ac1.getIdActividad()}"><i class="fa-solid fa-circle-plus"></i></a>
                </td>
	     </tr>
	    </c:forEach>
	    </tbody>
	</table>
	
	 <h2>Actividades Seleccionadas</h2>
	<table border=1>
		<thead>
		<tr> 
			<th> ACTIVAD </th>
			<th> PRECIO</th>
			<th> ACCION </th>
		</tr>
		</thead>
		<tbody>
	    <c:forEach items="${lstActividadesSeleccionadas}" var="ac2">
	    <tr> 
	            <td><c:out value="${ac2.getNombre()}"></c:out></td>
	            <td><c:out value="${ac2.getPrecio()}"></c:out></td>
	            <td >
	                <a href="${context}/ServletPresupuesto?accion=quitar&idActividad=${ac2.getIdActividad()}"><i class="fa-solid fa-circle-minus"></i></a>
                </td>
	     </tr>
	    </c:forEach>
	    </tbody>
	</table>
	
	</c:if>
       	<h2>Precio acumulado</h2>
       	<input  value="${sessionScope.presupuesto}" disabled>
        <h3 class="cliente" style="text-align:left;">Piezas</h3>
</body>
</html>