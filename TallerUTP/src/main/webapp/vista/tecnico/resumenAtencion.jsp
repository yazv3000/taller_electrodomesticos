<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="${context}/css/resumenAtencion.css">
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
        
        <button type="button"  class="actualizar" onclick="location.href='ServletPresupuesto?accion=listar'">Actualizar</button>
       <h3 class="cliente" style="text-align:left;">Actividades</h3>
	
	<form action="<%=request.getContextPath()%>/ServletPresupuesto" method="post">
	<c:if test="${lstActividadesOfrecidas!=null}">
	<div class="contenedor-act">
		<div class="bordes">
			<h2 class="sub-titulo">Actividades ofrecidas</h2>
			<table class="tabla">
				<thead>
					<tr class="titulo-col">
						<th>ACTIVAD</th>
						<th>PRECIO</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lstActividadesOfrecidas}" var="ac1">
						<tr>
							<td><label class="etiqueta"><c:out value="${ac1.getNombre()}"></c:out></label></td>
							<td><label class="etiqueta"><c:out value="${ac1.getPrecio()}"></c:out></label></td>
							<td><a class="etiqueta"href="${context}/ServletPresupuesto?accion=agregar&idActividad=${ac1.getIdActividad()}"><i
									class="fa-solid fa-circle-plus"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="bordes">
			<h2 class="sub-titulo">Actividades Seleccionadas</h2>
			<table class="tabla">
				<thead>
					<tr class="titulo-col">
						<th>ACTIVAD</th>
						<th>PRECIO</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lstActividadesSeleccionadas}" var="ac2">
						<tr>
							<td><label class="etiqueta"><c:out value="${ac2.getNombre()}"></c:out></label></td>
							<td><label class="etiqueta"><c:out value="${ac2.getPrecio()}"></c:out></label></td>
							<td><a class="etiqueta"
								href="${context}/ServletPresupuesto?accion=quitar&idActividad=${ac2.getIdActividad()}"><i
									class="fa-solid fa-circle-minus"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</c:if>
	<div class="cont-total">
		<label class="etq-total">Precio acumulado (S/.)</label>
	    <input class="total" name="txtPreciActividades" value="${presupuesto}" disabled>
	</div>
	
	
	
	<h3 class="cliente" style="text-align:left;">Piezas</h3>
	<button type="button"  class="actualizar" onclick="location.href='ServletPresupuesto?accion=listarPi'">Actualizar</button>
    
    <c:if test="${lstPiezasOfrecidas!=null}">
    <div class="contenedor-act">
    	<div class="bordes">
			<h2 class="sub-titulo">Piezas ofrecidas</h2>
			<table class="tabla">
				<thead>
					<tr class="titulo-col">
						<th> PIEZA </th>
						<th> PRECIO</th>
						<th> STOCK </th>
						<th> ACCION </th>
					</tr>
				</thead>
			<tbody>
				    <c:forEach items="${lstPiezasOfrecidas}" var="pi1">
				    <tr> 
				            <td><label class="etiqueta"><c:out value="${pi1.getNomPieza()}"></c:out></label></td>
				            <td><label class="etiqueta"><c:out value="${pi1.getPrecio()}"></c:out></label></td>
				            <td><label class="etiqueta"><c:out value="${pi1.getStock()}"></c:out></label></td>
				            <td>
				                <a class="etiqueta" href="${context}/ServletPresupuesto?accion=agregarPi&idPieza=${pi1.getIdPieza()}"><i class="fa-solid fa-circle-plus"></i></a>
			                </td>
				     </tr>
				    </c:forEach>
	    		</tbody>
			</table>
		</div>
	 	<div class="bordes">
			<h2 class="sub-titulo">Actividades Seleccionadas</h2>
			<table class="tabla">
				<thead>
					<tr class="titulo-col">
						<th> ACTIVAD </th>
						<th> PRECIO</th>
						<th> CANT </th>
						<th> ACCION </th>
					</tr>
				</thead>
			<tbody>
				    <c:forEach items="${lstPiezasSeleccionadas}" var="pi2">
				    <tr> 
			            <td><label class="etiqueta"><c:out value="${pi2.getNomPieza()}"></c:out></label></td>
			            <td><label class="etiqueta"><c:out value="${pi2.getPrecio()}"></c:out></label></td>
			            <td><label class="etiqueta"><c:out value="${pi2.getCantidadComprar()}"></c:out></label></td>
			            <td >
			                <a class="etiqueta" href="${context}/ServletPresupuesto?accion=quitarPi&idPieza=${pi2.getIdPieza()}"><i class="fa-solid fa-circle-minus"></i></a>
			            </td>
				     </tr>
				    </c:forEach>
	    		</tbody>
			</table>
		</div>
	</div>
	</c:if>
	<div class="cont-total">
		<label class="etq-total">Precio acumulado (S/.)</label>
	    <input class="total" name="txtPrecioPieza" value="${sessionScope.presupuesto2}" disabled>
	</div>
	<input type="hidden" name="id_atencion" value="${ate.getIdAtencion()}" />
	<input type="hidden" name="id_serv" value="${ate.getServicio().getIdServicio()}" />
	<a href="" class="actualizar" type="submit" name="accion"  style="margin: 0 calc(45% - 0px);">Confirmar</a>
	</form>
</body>
</html>