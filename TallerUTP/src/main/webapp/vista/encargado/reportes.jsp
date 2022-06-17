<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
    <link rel="stylesheet" type="text/css" href="${context}/css/tabla.css">
    <link rel="stylesheet" type="text/css" href="${context}/css/reportes.css">
    <link rel="icon" href="img/Logo.png" type="${context}/image/png">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    
    <title>Taller-UTP</title>
</head>

<body>
	<div class="contenido">
		<h1 class="titulo">REPORTES DE <span>ATENCIÓN</span></h1>
	    
		<c:choose>

	    <c:when test="${por_persona=='tecnico'}">
	    
	    <div class="filtro">
	    	<h5 class="filtro__titulo">Filtrar por Tecnico</h5>
		    <div class="filtro__contenedor">
			    <form method="get" action="${context}/ServletReportes" class="justify-content-center needs-validation">
					<input  class="filtro__input" type="text" name="nombre_tec" placeholder="Ingrese el Nombre" required/>
					<input class="filtro__boton" type="date" name="fecha1" required/>
					<input  class="filtro__boton" type="date" name="fecha2" required/>
					<button class="filtro__boton" type="submit"  name="accion" value="buscar_tecnico">Buscar</button>
				</form>
			</div>
		</div>
		</c:when>
		
	    <c:when test="${por_persona=='cliente'}">
	    <div class="filtro">
	    	<h5 class="filtro__titulo">Filtrar por Cliente</h5>
		    <div class="">
			    <form method="get" action="${context}/ServletReportes" class="justify-content-center needs-validation">
						<input class="filtro__input" type="text" name="nombre_cli" placeholder="Ingrese el Nombre" required/>
						<input class="filtro__boton" type="date" name="fecha1" required/>
						<input class="filtro__boton" type="date" name="fecha2" required/>
						<input class="filtro__input" type="number" name="monto1" placeholder="Monto Inicial S/." required/>
						<input class="filtro__input" type="number" name="monto2" placeholder="Monto Final S/." required/>
						
					<button class="btn__insertar" type="submit"  name="accion" value="buscar_cliente">Buscar</button>
				</form>
			</div>
		</div>
		</c:when>
		</c:choose>

		<div class="tabla">
			<div class="tabla__tools">
				<ul>
					<c:choose>
						<c:when test="${sessionScope.por_persona=='tecnico' && estado_reporte=='listo'}">
								<li><button class="fa-solid fa-print icono"  onclick="location.href='ServletGenerarPDF?generarPDF=reporteTecnico'"></button></li>	
						</c:when>
						<c:when test="${sessionScope.por_persona=='cliente' && estado_reporte=='listo'}">
								<li><button class="fa-solid fa-print icono"  onclick="location.href='ServletGenerarPDF?generarPDF=reporteCliente'"></button></li>	
						</c:when>
					</c:choose>
					<li><button type="button" class="btn btn-danger" onclick="location.href='ServletReportes?accion=listar&lista=todos'">Todos</button><li>
	                <li><button type="button" class="btn btn-primary" onclick="location.href='ServletReportes?accion=seleccionar&persona=tecnico'" >Por Tecnico</button></li>
	                <li><button type="button" class="btn btn-success" onclick="location.href='ServletReportes?accion=seleccionar&persona=cliente'" >Por Cliente</button><li>
	            </ul>
	        </div>
	        <div class="tabla__contenido">
	            <table id="tabla__Tecnico" >
	                <thead class="tabla__titulo">
	                    <tr>
	                        <th>ID</th>
							<th>FECHA</th>
							<th>HORA</th>
							<th>TÉCNICO</th>
							<th>CLIENTE</th>
							<th>ELECTRODOMÉSTICO</th>
							<th>MARCA</th>
							<th>SERVICIOS</th>
							<th>MONTO TOTAL</th>
							<th>HOJA DE SERVICIO</th>
	                    </tr>
	                </thead>
	                <tbody class="tabla__info">
	                	<c:forEach items="${sessionScope.lstReportes}" var="r">
	                    <tr id="tabla__filas"">
	                   		<td> <c:out value="${r.getIdAtencion()}"></c:out> </td>
							<td> <c:out value="${r.getFecha()}"></c:out> </td>
							<td> <c:out value="${r.getHora()}"></c:out> </td>
							<td> <c:out value="${r.getNombreTecnico()}"></c:out> </td>
							<td> <c:out value="${r.getNombreCliente()}"></c:out> </td>
							<td> <c:out value="${r.getElectrodomestico()}"></c:out> </td>
							<td> <c:out value="${r.getMarca()}"></c:out> </td>
							<td> <c:out value="${r.getServicio()}"></c:out> </td>	
							<td>S/. <c:out value="${r.getMonto()}"></c:out> </td>	
							<td><button class="fa-solid fa-file icono"></button></td>		
	                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	        <div class="tabla__especificacion">
	        </div>
	    </div>

	
	</div><!-- /.contenido -->
	
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	
	 <!-- ===== JS BOOSTRAP ===== -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
    <script>
       $(document).ready(function () {
            $('#tabla__Tecnico').DataTable({
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