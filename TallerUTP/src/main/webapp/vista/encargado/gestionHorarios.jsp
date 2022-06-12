<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="context" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${context}/css/asignacion-horarios.css">
<title>Insert title here</title>
</head>
<body>
    <h1 class="titulo">Programacion de <span>Horarios</span></h1>
    <form class="formulario" action="<%=request.getContextPath()%>/ServletGestionarHorario" method="post" novalidate>
            <h3 class="titulo-panel">Control de Horarios</h3>
            <div class="fecha">
                <h4 class="subtitulo">Mes de Horarios</h4>
                <label for="" class="etq">Mes: </label>
                <select class="entrada selector" name="mes" id="" class="mes">
                    <option value="1" ${mes==1 ? 'selected' : '' }>Enero</option>
                    <option value="2" ${mes==2 ? 'selected' : '' }>Febrero</option>
                    <option value="3" ${mes==3 ? 'selected' : '' }>Marzo</option>
                    <option value="4" ${mes==4 ? 'selected' : '' }>Abril</option>
                    <option value="5" ${mes==5 ? 'selected' : '' }>Mayo</option>
                    <option value="6" ${mes==6 ? 'selected' : '' }>Junio</option>
                    <option value="7" ${mes==7 ? 'selected' : '' }>Julio</option>
                    <option value="8" ${mes==8 ? 'selected' : '' }>Agosto</option>
                    <option value="9" ${mes==9 ? 'selected' : '' }>Setiembre</option>
                    <option value="10" ${mes==10 ? 'selected' : '' }>Octubre</option>
                    <option value="11" ${mes==11 ? 'selected' : '' }>Noviembre</option>
                    <option value="12" ${mes==12 ? 'selected' : '' }>Diciembre</option>
                </select><br>
                <label for="" class="etq"> anyo: </label>
                <input class="entrada" type="number" min="2022" value="2022">
                <input class="boton" type="submit" name="accion" value="listar">
                
            </div>
            
            <div class="hora">
                <h4 class="subtitulo">Horas Disponibles</h4>
                <label class="etq" for="">Hora Inicio: </label>
                <input class="entrada" type="time" name="hInicio"><br>
                <label class="etq" for="">Hora Final: </label>
                <input class="entrada" type="time" name="hFinal">
                <input class="boton"  type="submit" name="accion" value="generar">
            </div>

    
        <div class="tablas">
            <!-- Tabla 1 -->
            <h3 class="titulo-panel">Seleccion de Tecnicos</h3>
            <div class="tabla-1">
            	<div class="titulo-all">
            		<button class="boton  sub-posicion boton-check" type="button">All</button>
                	<h4 class="subtitulo">Tecnicos sin horario</h4>
            	</div>
           		
                <table class="tabla">
                    <thead>
                        <tr class="tabla__titulo">
                            <th>id</th>
                            <th>Nombre</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lstSH}" var="tec1">
                            <tr class="tabla__fila">
                                <td>
                                    <c:out value="${tec1.getId()}"></c:out>
                                </td>
                                <td style="text-align-last: center;">
                                    <c:out value="${tec1.getNombre()}"></c:out>
                                </td>
                                <td><input class="tecnico-check" name="tecnico" value="${tec1.getId()}" type="checkbox"></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <!-- Tabla 2  -->
            <div class="tabla-2">
                <h4 class="subtitulo titulo-top">Tecnicos con horario</h4>
                <table class="tabla">
                    <thead>
                        <tr class="tabla__titulo">
                            <th>id</th>
                            <th>nombre</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lstCH}" var="tec2">
                        <tr class="tabla__fila">
                            <td><c:out value="${tec2.getId()}"></c:out></td>
                            <td style="text-align-last: center;"><c:out value="${tec2.getNombre()}"></c:out></td>
                        </tr>
                    
                        </c:forEach>     
                    </tbody>
                </table>
            </div>
        </div>
    </form>	
   	<script src="${context}/js/asignacion-horarios.js"></script> 
</body>
</html>