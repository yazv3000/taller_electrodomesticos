<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
 <c:set var="ate" value="${sessionScope.dtoAtencion}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="${context}/css/resumenAtencion.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
</head>
<body>
	<h2 class="titulo-1">Detalles de la <span>Hoja de Servicio</span></h2>
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
            <div class="grid__items largo"><i class="fa-solid fa-triangle-exclamation"></i><span>Falla: <c:out value="${ate.getFallaDescrita()}"></c:out></span></div>
        </div>
       
        <button type="button"  class="actualizar" onclick="location.href='ServletPresupuesto?accion=listar&id_servicio=${ate.getServicio().getIdServicio()}'">En progreso</button>
    
	<form action="${context}/ServletPresupuesto" method="get">
	<h3 class="cliente" style="text-align:left;">Actividades</h3>
	<c:if test="${lstActividadesOfrecidas!=null}">
	<div class="contenedor-act">
		<div class="bordes">
			<h2 class="sub-titulo">Actividades ofrecidas</h2>
			<table class="tabla" id="tabla_Servicios">
				<thead>
					<tr class="titulo-col" id="tabla__fila">
						<th>ACTIVAD</th>
						<th>PRECIO</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lstActividadesOfrecidas}" var="ac1">
						<tr id="tabla__fila">
							<td><label class="etiqueta"><c:out value="${ac1.getNombre()}"></c:out></label></td>
							<td><label class="etiqueta"><c:out value="${ac1.getPrecio()}"></c:out></label></td>
							<td><a class="etiqueta" href="${context}/ServletPresupuesto?accion=agregar&idActividad=${ac1.getIdActividad()}"><i
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
	
	<div class="cont-total">
		<label class="etq-total">Precio acumulado (S/.)</label>
	    <input class="total" name="txtPreciActividades" value="${presupuesto}" disabled>
	</div>
	</c:if>
	
	<button type="button"  class="actualizar" onclick="location.href='ServletPresupuesto?accion=listarPi'">Venta Piezas</button>
	
	    <c:if test="${lstPiezasOfrecidas!=null}">
	<h3 class="cliente" style="text-align:left;">Piezas</h3>

    <div class="contenedor-act">
    	<div class="bordes">
			<h2 class="sub-titulo">Piezas ofrecidas</h2>
			<table class="tabla" id="tabla_Piezas">
				<thead>
					<tr class="titulo-col" id="tabla__fila">
						<th> PIEZA </th>
						<th> PRECIO</th>
						<th> STOCK </th>
						<th> ACCION </th>
					</tr>
				</thead>
			<tbody>
				    <c:forEach items="${lstPiezasOfrecidas}" var="pi1">
				    <tr id="tabla__fila"> 
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
	<div class="cont-total">
		<label class="etq-total">Precio acumulado (S/.)</label>
	    <input class="total" name="txtPrecioPieza" value="${sessionScope.presupuesto2}" disabled>
	</div>
	</c:if>
	<input type="hidden" name="generarPDF" value="hojaServicio">
	<div class="contendedorBotones" align="center">
		<button class="botonabajito" type="submit" name="accion" value="Presupuesto" style="margin: 0 calc(45% - 0px);">Presupuesto</button>
		<button class="botonabajito" type="submit" name="accion" value="Cancelar" style="margin: 0 calc(45% - 0px);">Cancelar</button>
		<button class="botonabajito" type="submit" name="accion" value="confirmar" style="margin: 0 calc(45% - 0px);">Confirmar</button>
	</div>
	
	
	</form>
	<!-- LIBRERIA DATATABLE -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script>
	
		$(document).ready(function () {
	        $('#tabla_Servicios').DataTable({
	            "language": {
	            	"sSearch":"Buscar",
	            	"oPaginate":{
	            		"sPrevious": "Anterior",
	                	"sNext": "Siguiente"
	            	}	
	            }
	        });
	    }); 
		$(document).ready(function () {
	        $('#tabla_Piezas').DataTable({
	            "language": {
	            	"sSearch":"Buscar",
	            	"oPaginate":{
	            		"sPrevious": "Anterior",
	                	"sNext": "Siguiente"
	            	}	
	            }
	        });
	    }); 
    </script>
</body>
</html>