<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${context}/css/electro.css">
	<c:set var="context" value="${pageContext.request.contextPath}" /> 
	<link rel="stylesheet" href="${context}/css/electro.css">
    <link rel="icon" type="image/png" href="${context}/img/Logoa.png">
	<!-- PRUEBA CONTRASEÑA -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Taller - UTP</title>
</head>
<body>
	
<%-- 	<h1>Cliente: <c:out value="${cliente.getNombreCompleto()}"/></h1>
	<h2>Servicio: <c:out value="${servicio}"/></h2>
	<h2>Nombre del Técnico: <c:out value="${hora.getNombres()}"/></h2>
	<h2>Fecha de la cita Técnica: <c:out value="${hora.getFormatoFecha()}"/></h2>
	<h2>Hora de la cita Técnica: A las<c:out value="${hora.getHora()}"/> horas</h2> --%>
	
	<h1 class="titulo">Información del <span>Electrodoméstico</span></h1>
    <div class="contenedor-electro">
        <div class="cont-electro">
            <div class="electro" action="">
                <div class="electro-1 formato">
                    <select class="electro__tipo" name="" id="">
                    	<c:forEach items="${lstMarcas}" var="marca">	
                        	<option value=""><c:out value="${marca.getNombre()}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="electro-2 formato">                
                    <input class="electro__serie" type="number" placeholder=" ">
                    <label class="nombre" for="">Numero de serie: </label>
                </div>
                <div class="electro-3 formato">
                    <select class="electro__Marca" name="" id="">
                    	<c:forEach items="${lstTipos}" var="tipo">	
                        <option value=""><c:out value="${tipo.getNombre()}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="electro-4 formato">
                    <input class="electro__modelo" type="text" placeholder=" ">
                    <label class="nombre" for="">Modelo: </label>       
                </div>
                <div class="electro-5 formato">
                    <textarea name="" id="" cols="30" rows="10" placeholder=" "></textarea>
                    <label class="nombre" for="">Descripcion de la falla: </label>
                </div>
            </div>
			<!--   	===== MODAL RESUMEN ===== -->
			<!-- Boton del Modal -->
			<button class="boton-modal" type="button" data-bs-toggle="modal"
				data-bs-target="#exampleModal">Aceptar</button>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered contenedor"
					id="contededor">
					<div class="modal-content contenido-modal ">
						<h3 class="titulo-modal">DATOS GENERALES</h3>
						<div class="cita">
							<label class="etiqueta-1" for="">Solicitante:</label> 
							<label class="etiqueta-2" for="">************</label> 
							<label class="etiqueta-1" for="">Tecnico:</label> 
							<label class="etiqueta-2" for="">************</label> 
							<label class="etiqueta-1" for="">Direccion:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">Telefono:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">Servicio:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">Fecha:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">Hora:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">E. tipo:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">E. Marca:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">Numero de serie:</label> 
								<label
								class="etiqueta-2" for="">************</label> 
								<label
								class="etiqueta-1" for="">Modelo:</label> 
								<label
								class="etiqueta-2" for="">************</label>

						</div>
						<div class="controles">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancelar</button>
							<button type="button" class="btn btn-primary">Confirmar</button>
						</div>

					</div>

				</div>
			</div>
			<!--   	===== FIN MODAL ===== -->
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Aceptar</button>
		</div>
  	</div>
  	


	
	

	<!-- ===== JS BOOSTRAP ===== -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${context}/js/PruebaPermanenciavariable.js"></script>
	
</body>
</html>