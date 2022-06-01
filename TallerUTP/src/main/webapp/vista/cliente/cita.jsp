<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${context}/css/electro.css">
<c:set var="context" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${context}/css/cita.css">
<link rel="icon" type="image/png" href="${context}/img/Logoa.png">
<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
<!-- PRUEBA CONTRASEÑA -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Taller - UTP</title>
</head>
<body>

	<h1 class="titulo-cita">
		Reserva <span>Cita Tecnica</span>
	</h1>
	<div class="cuadricula">
		<div class="resumen">
			<div class="tecnico__datos">
				<div class="tecnico__img">
					<img src="${context}/img/tony.jpg" alt="">
				</div>
				<h3>${dtoCita.getNombres()}</h3>
				<p class="tecnico__nombre">${dtoCita.getEspecialidad()}</p>
				<p class="tecnico__telefono">Telefono: ${dtoCita.getTelefono()}</p>
			</div>
			<div class="servicio">
				<h2 class="serv__cita">Cita Tecnica</h2>
				<div class="serv serv__nombre">
					<i class="fa-solid fa-screwdriver-wrench"></i> <span>${dtoCita.getServicio()}</span>
				</div>
				<div class="serv serv__fecha">
					<i class="fa-solid fa-calendar-days"></i> <span>${dtoCita.getFormatoFecha()}</span>
				</div>
				<div class="serv serv__hora">
					<i class="fa-solid fa-clock"></i> <span>${dtoCita.getHora()}</span>
				</div>
				<div class="serv serv__estado">
					<i class="fa-solid fa-location-dot"></i> <span>${dtoCita.getLugar()}</span>
				</div>
				<div class="serv serv__estado">
					<i class="fa-solid fa-circle-info"></i><span>Estado: ${dtoCita.getEstado()}</span>
				</div>
			</div>
		</div>
		<form class="electrodomestico" action="<%=request.getContextPath()%>/ServletCita?idServicio=${dtoCita.getIdHorario()}&idPersona=${dtoUsuario.getIdPersona()}&idHorario=${dtoCita.getIdHorario()}" method="post" novalidate="novalidate">
			<h2 class="electro__titulo">Datos del Electrodomestico</h2>
			<div class="electro">
				<select class="electro__tipo electro__setup" name="tipo" id="">
					<c:forEach items="${lstTipos}" var="tipo">	
                        <option value="${tipo.getId()}"><c:out value="${tipo.getNombre()}"></c:out></option>
                  	</c:forEach>	
				</select> <label for="" class="etq">Electrodomestico</label>
			</div>
			<div class="electro">
				<select class="electro__Marca electro__setup" name="marca" id="">
					<c:forEach items="${lstMarcas}" var="marca">
						<option value="${marca.getId()}"><c:out value="${marca.getNombre()}"></c:out></option>
					</c:forEach>
				</select> <label for="" class="etq">Marca</label>
			</div>
			<div class="electro">
				<input class="electro__serie electro__setup" type="number" name="serie">
				<label for="" class="etq" placeholder=" ">Numero de serie</label>
			</div>
			<div class="electro">
				<input class="electro__modelo electro__setup" type="text" name="modelo"> <label
					for="" class="etq" placeholder=" ">Modelo</label>
			</div>
			<div class="electro electro__falla">
				<textarea class="falla" name="falla" id="" cols="30" rows="10"
					placeholder="Ingrese la falla de su electrodomestico..."></textarea>
				<label for="" class="etq" placeholder=" ">Descripcion de la falla</label>
			</div>
			<div class="electro__boton">
				<input name="accion" class="electro__confirmar" type="submit" value="confirmar">
			</div>
		</form>
	</div>

</body>
</html>