<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page session="true" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="es-PE">
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${context}/css/horario.css">
	<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>

</head>
<body>

    <h1 class="titulo">Horario de <span>Técnicos</span></h1>
    <div class="contenedor">
        <div class="cuadricula">
            <!-- ===== Tarjeta Horario del Técnico ===== -->
            <c:forEach items="${lsthorario}" var="horarios" >
            <div class="tecnico">
                <div class="tecnico__datos">
                    <div class="tecnico__img">
                    <c:set var="foto_tecnico" value="${horarios.key.getRutaFoto()}" />
                     <c:choose>
                       <c:when test="${foto_tecnico==null}">
                       <img class="nav__img" src="${context}/default.jpg" alt="">
                       </c:when>
                       <c:otherwise>
				        <img class="nav__img" src="${context}/${foto_tecnico}" alt="">
				    </c:otherwise>
                      </c:choose>
                    </div>
                    <h3><c:out value="${horarios.key.getNombreCompleto()}"/></h3>
                    <p class="tecnico__nombre"><c:out value="${horarios.key.getEspecialidad()}"/></p>
                    <p class="tecnico__telefono">Telefono: <c:out value="${horarios.key.getTelefono()}"/></p>
                </div>
                
                <div class="tecnico__horario">
                    <div class="tecnico__controles">
                        <button class="btn__anterior"><i class="fa-solid fa-chevron-left"></i></button>
                        <button class="btn__siguiente"><i class="fa-solid fa-chevron-right"></i></button>
                    </div>
                    <div class="overflow">
	                    <ul class="carrusel">
	                    <c:forEach items="${horarios.value}" var="horario">
	                        <li class="carrusel__contenido">
	                            <div class="carrusel__espacio">
	                                <table class="tabla-1">
	                                    <tr class="tabla-dia">
	                                    <c:forEach var="dia" items="${horario}"> 
	                                        <td class="tabla1__columna">
	                                            <table class="tabla-2">
	                                                <thead class="tabla-2__barra">
	                                                    <tr>
	                                                        <th class="tabla-2__cabecera">
	                                                            <c:out value="${dia.key}"/>
	                                                        </th>
	                                                    </tr>
	                                                </thead>
	                                                <tbody>
	                                                <c:forEach var="hora" items="${dia.value}"> 
	                                                    <tr>
	                                                        <td class="tabla-2__hora">
	                                                        <form action="${context}/ServletNuevaCita" method="post">
										                    	<input type="hidden" name="horario" value="${hora.getIdHorario()}" />
										                    	<!--  Desabilita el boton de horario dependiendo de si este está disponible o no -->
										                    	<button class="serv__link ${hora.getEstado() ne 'Disponible' ? 'desactivado':''}"  ${hora.getEstado() ne 'Disponible' ? 'disabled':''} type="submit" name="accion" value="cita_domicilio"><c:out value="${hora.getHoraInicio()}"/></button>
										                    	
										                	</form>
	                                                        </td>
	                                                    </tr>
													</c:forEach>
	                                                </tbody>
	                                            </table>
	                                        <td>
	                                    </c:forEach>
	                                    </tr>
	                                </table>
	                            </div>
	                        </li>
	                    </c:forEach>
	                    </ul>
                    </div>
                    <button class="mostrar__horas">Mostrar más Horas</button>
                </div>       
            </div>
            </c:forEach>
        </div>
    </div>
	<script src="${context}/js/horarios.js"></script>
</body>
</html>