<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Mes de Horarios</h3>

    <form  class="formulario" action="<%=request.getContextPath()%>/ServletGestionarHorario" method="post" novalidate>
	    <label for="" class="etq-mes">Mes</label>
	    <select name="mes" id="" class="mes">
	        <option value="01" ${mes eq 1?selected:""}>Enero</option>
	        <option value="02" ${mes eq 2?selected:""}>Febrero</option>
	        <option value="03" ${mes eq 3?selected:""}>Marzo</option>
	        <option value="04" ${mes eq 4?selected:""}>Abril</option>
	        <option value="05" ${mes eq 5?selected:""}>Mayo</option>
	        <option value="06" ${mes eq 6?selected:""}>Junio</option>
	        <option value="07" ${mes eq 7?selected:""}>Julio</option>
	        <option value="08" ${mes eq 8?selected:""}>Agosto</option>
	        <option value="09" ${mes eq 9?selected:""}>Setiembre</option>
	        <option value="10" ${mes eq 10?selected:""}>Octubre</option>
	        <option value="11" ${mes eq 11?selected:""} >Noviembre</option>
	        <option value="12" ${mes eq 12?selected:""}>Diciembre</option>
	    </select>
	    <label for="" class="etq-mes"> del 2022</label>
	    <input type="submit" name="accion" value="listar">

<!--     </form> -->

    
    <br><br>
<!--     <form action=""> -->
        <label for="">Hora Inicio </label>
        <input type="time" name="hInicio">
        <label for="">HoraFinal </label>
        <input type="time" name="hFinal">
        <input type="submit" name="accion" value="generar">
    </form>

    <h3>Tecnicos sin horario</h3>
    <button>Todos</button>
    
    <br>
    <br>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${lstSH}" var="tec1">
            <tr>
                <td><c:out value="${tec1.getId()}"></c:out></td>
                <td><c:out value="${tec1.getNombre()}"></c:out></td>
                <td><input name="${t.id()}" value="1" type="checkbox"></td>
            </tr>  
            </c:forEach>     
        </tbody>
    </table>

    <h3>Tecnicos con horario</h3>
    <table class="tabla">
        <thead>
            <tr>
                <th>id</th>
                <th>nombre</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${lstCH}" var="tec2">
            <tr>
                <td><c:out value="${tec2.getId()}"></c:out></td>
                <td><c:out value="${tec2.getNombre()}"></c:out></td>
            </tr>
            </c:forEach>     
        </tbody>
    </table>
</body>
</html>