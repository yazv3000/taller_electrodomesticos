<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${context}/css/tecnico-horario.css">
    <title>Document</title>
</head>

<body>
	
    <h1 class="titulo-horario">Horario de la <span>Semana</span></h1>
    <div class="cuadricula">
        
        <div class="contenedor">
            <div class="controles">
                <button class="boton btn-anterior"><i class="fa-solid fa-chevron-left icon"></i></button>
                <button class="boton btn-siguiente"><i class="fa-solid fa-chevron-right icon"></i></button>
            </div>
            <ul class="carrusel">
            	 <c:forEach items="${horarios}" var="horario">
            	   <li class="carrusel__panel">
	                    <div class="carrusel__overflow">
	                        <table class="tabla-1" class="Horario">
	                            <tr class="columna">
	                            	<c:forEach var="dia" items="${horario}">
	                                <td >
	                                    <table class="tabla-2">
	                                        <thead>
	                                            <tr>
	                                                <th class="tabla-2__fecha">
	                                                    <span class="fecha"><c:out value="${dia.key}"/></span>
	                                                </th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                        	<c:forEach var="hora" items="${dia.value}">
	                                            <tr>
	                                                <td class="tabla-2__hora">
	                                                    <span class="hora"><c:out value="${hora.getHoraInicio()}"/></span>
	                                                </td>
	                                            </tr>
	                                            </c:forEach> 
	                                        </tbody>
	                                    </table>
	                                </td>
	                                </c:forEach> 
	                            </tr>
	                        </table>
	                    </div>
	                </li>
	              </c:forEach>
            </ul>
        </div>
    </div>
    <script src="${context}/js/tecnico-horario.js"></script>
</body>

</html>