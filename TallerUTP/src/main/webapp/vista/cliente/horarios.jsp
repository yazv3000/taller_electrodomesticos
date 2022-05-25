<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="context" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${context}/css/horarios.css">
<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>

<title>Insert title here</title>
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
                        <img src="${context}/img/tony.jpg" alt="" >
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
	                                                        <td class="tabla-2__hora"><Button><c:out value="${hora.getHoraInicio()}"/></Button></td>
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
                    <button class="mostrar__horas">Mostrar mas Horas</button>
                </div>       
            </div>
            </c:forEach>
        </div>
    </div>
	<script src="${context}/js/horarios.js"></script>
</body>
</html>