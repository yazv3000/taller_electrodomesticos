<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es-PE">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link rel="stylesheet" href="${context}/css/tecnico-citas.css">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
</head>

<body>
    <h2 class="titulo-1">Citas <span>Actuales</span></h2>
    <div class="tabla__contenido">
        <h3>Tabla de Citas</h3>
        <div class="tabla__overflow">
            <table id="tabla-citas"">
                <thead class="tabla__titulo">
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Electrodomestico</th>
                        <th>Direccion</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Tipo Atencion</th>
                        <th>Servicio</th>
                        <th>Detalle</th>
                    </tr>
                </thead>
                <tbody class="tabla__info">
                     <c:forEach items="${lstConsultaCitas}" var="ci">      
                    <tr id="tabla__fila">
                        <td class="tabla__columna"><c:out value="${ci.getIdAtencion()}"></c:out></td>
                        <td  class="tabla__columna"><c:out value="${ci.getNombreCliente()}"></c:out></td>
                        <td class="tabla__columna"><c:out value="${ci.getTipoElectrodomestico()}"></c:out></td>
                        <td class="tabla__columna"><c:out value="${ci.getDistritoYdireccion()}"></c:out></td>
                        <td class="tabla__columna"><c:out value="${ci.getFechaAtencion()}"></c:out></td>
                        <td class="tabla__columna"><c:out value="${ci.getHoraAtencion()}"></c:out></td>
                        <td class="tabla__columna"><c:out value="${ci.getLugar()}"></c:out></td>
                        <td>
                        	<table>
                        	<tbody class="tabla__info">
	                        	<c:forEach items="${ci.getServicios()}" var="s">       
	                        	 <tr id="tabla__fila">
	                        	 	<td class="tabla__columna"><c:out value="${s.getNomServicio()}"></c:out></td>
	                        	 	<td class="tabla__columna">
	                        	 	<c:choose>
				                       <c:when test="${s.isEstadoCompleto()}">
				                       <i class="fa fa-check-square" aria-hidden="true"></i>
				                       </c:when>
				                       <c:otherwise>
								       <i class="fa fa-spinner" aria-hidden="true"></i>
								    </c:otherwise>
				                      </c:choose>
	                        	 	</td>
	                        	 </tr>
	                        	 </c:forEach>
                        	</tbody>
                        	</table>
                        </td>
                        <td  class="tabla__columna">
                        	<a class="informacion" href="${context}/ServletResumenAtencion?id=${ci.getIdAtencion()}" target="marco-atencion"><i class="fa-solid fa-file-pen icon"></i></a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <h2 class="titulo-1">Detalles de la <span>Cita Seleccionada</span></h2>
    <div class="contenedor-iframe">
        <iframe src="" class="marco-atencion" name="marco-atencion" src="" frameborder="0"></iframe>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#tabla-citas').DataTable({
                "language": {
                    "sSearch": "Buscar",
                    "oPaginate": {
                        "sPrevious": "Anterior",
                        "sNext": "Siguiente"
                    }
                }
            });
        });
    </script>
</body>

</html>