<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es-PE">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" href="${context}/css/cita.css">
	<link rel="icon" type="image/png" href="${context}/img/Logoa.png">
	<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
	
	<!-- PRUEBA CONTRASEÑA -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

	<h1 class="titulo-cita">Reserva <span>Cita Tecnica</span>
	</h1>
	<div class="cuadricula">
		<div class="resumen">
			<div class="tecnico__datos">
				<div class="tecnico__img">
					<c:set var="foto_tecnico" value="${dtoCita.getDtoHora().getFotoTecnico()}" />
					<c:choose>
						<c:when test="${foto_tecnico==null}">
							<img class="nav__img" src="${context}/img/personas/default2.jpeg" alt="">
						</c:when>
						<c:otherwise>
							<img class="nav__img" src="${context}/${foto_tecnico}" alt="">
						</c:otherwise>
					</c:choose>
				</div>
				<h3>${dtoCita.getDtoHora().getNombreTecnico()}</h3>
				<p class="tecnico__nombre">${dtoCita.getDtoHora().getEspecialidad()}</p>
				<p class="tecnico__telefono">Telefono: ${dtoCita.getDtoHora().getTelefonoTecnico()}</p>
			</div>
			<div class="servicio">
				<h2 class="serv__cita">Cita Tecnica</h2>
				<div class="serv serv__nombre">
					<i class="fa-solid fa-screwdriver-wrench"></i> <span>${dtoCita.getServicio().getNomServicio()}</span>
				</div>
				<div class="serv serv__fecha">
					<i class="fa-solid fa-calendar-days"></i> <span>${dtoCita.getDtoHora().getFormatoFecha()}</span>
				</div>
				<div class="serv serv__hora">
					<i class="fa-solid fa-clock"></i> <span>${dtoCita.getDtoHora().getHora()}</span>
				</div>
				<div class="serv serv__estado">
					<i class="fa-solid fa-location-dot"></i> <span>${dtoCita.getLugar()}</span>
				</div>
			</div>
		</div>
		<!-- CHOOSE -->
		<c:choose>
			<c:when test="${lstElectro.size() != 0 && contenido ne 'nuevo' && entrada ne 'bloquear' }">

				<form class="tablaElectro" action="<%=request.getContextPath()%>/ServletNuevaCita" method="post" novalidate="novalidate">
					<button name="accion" value="agregarElectro" class="fa-solid fa-plus-square icono3"></button>
					<h2 class="electro__titulo">Selecciona uno de sus electrodomésticos</h2>
					<table class="tabla" id="tabla">
						<thead class="tabla__titulo">
							<tr class="titulo-col titulo" id="tabla__fila">
								<th>ID</th>
								<th>Nº SERIE</th>
								<th>TIPO</th>
								<th>MODELO</th>
								<th>MARCA</th>
								<th>ACCION</th>
							</tr>
						</thead>
						<tbody class="tabla__info">
							<c:forEach items="${lstElectro}" var="e">
								<tr class="titulo-col tabla__letra" id="tabla__fila">
									<td><c:out value="${e.getIdElectrodomestico()}"></c:out></td>
									<td><c:out value="${e.getNroSerie()}"></c:out></td>
									<td><c:out value="${e.getTipo()}"></c:out></td>
									<td><c:out value="${e.getModelo()}"></c:out></td>
									<td><c:out value="${e.getMarca()}"></c:out></td>
									<td><a href="${context}/ServletNuevaCita?accion=seleccionarElectro&id=${e.getIdElectrodomestico()}"><i class="fa-solid fa-square-check icono2"></i></a></td>
								</tr>
							</c:forEach>
							
							<!-- PRUEBA ENTRADA EN LINEA -->
							
<%-- 							<c:choose> --%>
<%-- 								<c:when test="${contenido ne 'nuevo'}"> --%>
<!-- 								<tr class="titulo-col" id="tabla__fila"> -->
<!-- 									<td style="opacity: 0">a</td> -->
<!-- 									<td> -->
<!-- 										<input class="electro__serie electro__setup" type="number" name="serie"> -->
<!-- 									</td> -->
<!-- 									<td> -->
<%-- 										<select class="electro__tipo electro__setup" name="tipo" id="" ${entrada eq 'bloquear'? 'disabled':''}> --%>
<%-- 											<c:forEach items="${lstTipos}" var="tipo"> --%>
<%-- 												<option value="${tipo.getId()}"><c:out value="${tipo.getNombre()}"></c:out></option> --%>
<%-- 											</c:forEach> --%>
<!-- 										</select> -->
<!-- 									</td> -->
<!-- 									<td> -->
<!-- 										<input class="electro__modelo electro__setup" type="text" name="modelo"> -->
<!-- 									</td> -->
<!-- 									<td> -->
<%-- 										<select class="electro__Marca electro__setup" name="marca" id="" ${entrada eq 'bloquear'? 'disabled':''}> --%>
<%-- 											<c:forEach items="${lstMarcas}" var="marca"> --%>
<%-- 												<option value="${marca.getId()}"><c:out value="${marca.getNombre()}"></c:out></option> --%>
<%-- 											</c:forEach> --%>
<!-- 										</select> -->
<!-- 									</td> -->
<!-- 									<td> -->
<!-- 										<a href="#" style="margin-right: 10px"><i class="fa-solid fa-floppy-disk icono2"></i></a> -->
<!-- 										<a href="#"><i class="fa-solid fa-xmark icono2"></i></a> -->
<!-- 									</td> -->
<!-- 								</tr> -->
<%-- 								</c:when> --%>
<%-- 							</c:choose> --%>

							<!-- PRUEBA ENTRADA EN LINEA -->
						</tbody>
					</table>
				</form>
			</c:when>

			<c:when test="${lstElectro.size() == 0 || contenido eq 'nuevo' || entrada eq 'bloquear'}">
				<form class="electrodomestico" action="<%=request.getContextPath()%>/ServletNuevaCita" method="post" novalidate="novalidate">
					<h2 class="electro__titulo">Datos del Electrodomestico</h2>
					<div class="electro">
						<select class="electro__tipo electro__setup" name="tipo" id=""  ${entrada eq 'bloquear'? 'disabled':''}>
							<c:forEach items="${lstTipos}" var="tipo">
								<option value="${tipo.getId()}" ${tipo.getNombre() eq dtoElectro.getTipo()? 'selected':''}><c:out value="${tipo.getNombre()}"></c:out></option>
							</c:forEach>
						</select>
						<label for="" class="etq">Electrodomestico</label>
					</div>
					<div class="electro">
						<select class="electro__Marca electro__setup" name="marca" id="" ${entrada eq 'bloquear'? 'disabled':''}>
							<c:forEach items="${lstMarcas}" var="marca">
								<option value="${marca.getId()}" ${marca.getNombre() eq dtoElectro.getMarca()? 'selected':''}><c:out value="${marca.getNombre()}"></c:out></option>
							</c:forEach>
						</select>
						<label for="" class="etq">Marca</label>
					</div>
					<div class="electro">
						<input class="electro__serie electro__setup" type="number" name="serie" value="${entrada eq 'bloquear'? dtoElectro.getNroSerie():''}" ${entrada eq 'bloquear'? 'readonly':''}>
						<label for="" class="etq" placeholder=" ">Numero de serie</label>
					</div>
					<div class="electro">
						<input class="electro__modelo electro__setup" type="text" name="modelo" value="${entrada eq 'bloquear'? dtoElectro.getModelo():''}" ${entrada eq 'bloquear'? 'readonly':''}>
						<label for="" class="etq" placeholder=" ">Modelo</label>
					</div>
					<div class="electro electro__falla">
						<textarea maxlength="500" class="falla" name="txt_falla" id="" cols="30" rows="10" placeholder="Ingrese la falla de su electrodomestico..."></textarea>
						<label for="" class="etq" placeholder=" ">Descripcion de la falla</label>
					</div>

					<div class="electro__boton">
						<input type="hidden" name="generarPDF" value="citaTecnica">
						<input type="submit" value="cancelar" name="accion" class="electro__confirmar">
						<input name="accion" class="electro__confirmar" type="submit" value="confirmar">
					</div>

				</form>
			</c:when>
		</c:choose>


	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#tabla').DataTable({
				"language" : {
					"sSearch" : "Buscar",
					"oPaginate" : {
						"sPrevious" : "Anterior",
						"sNext" : "Siguiente"
					}
				}
			});
		});
	</script>

</body>
</html>