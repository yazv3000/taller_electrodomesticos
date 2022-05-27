<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/horarios.css">

<!-- ===== ACTUALIZAR CSS SIN GUARDAR EN CACHE ===== -->
    <meta http-equiv="Expires" content="0">
	<meta http-equiv="Last-Modified" content="0">
	<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
  	<meta http-equiv="Pragma" content="no-cache">
  	<c:set var="context" value="${pageContext.request.contextPath}" />

</head>
<body>
	<h1>HORARIO DE TECNICOS</h1>
	


<%--><c:forEach items="${lsthorario}" var="horario" >
<button>Anterior</button><button>Siguiente</button>
<table border="1" class="tecnico-horario">	
	<tr>
		<c:forEach var="dia" items="${horario}"> 	
			<td class="contenedor">
				<table border="1" class="horario">
					<thead>
								<tr><th style="text-transform: lowercase;"><c:out value="${dia.key}"/></th></tr>
						</thead>
						<tbody>
							<c:forEach var="hora" items="${dia.value}"> 
								<tr><td><c:out value="${hora.getHoraInicio()}"/></td></tr>
			
								</c:forEach>
						</tbody>
					</table>
				<td>	
				    
		</c:forEach>
	</tr>
</table>
</c:forEach>--%>





<c:forEach items="${lsthorario}" var="horarios" >

<div style="background-color: purple">
	<c:out value="${horarios.key.getNombreCompleto()}"/>
	<c:out value="${horarios.key.getEspecialidad()}"/>
	<c:out value="${horarios.key.getTelefono()}"/>
</div>	


<div class="contenedor" style="background:green; overflow: hidden;width:600px">
	<div>
		<button class="btn__anterior">Anterior</button>
		<button class="btn__siguiente">Siguiente</button>
	</div>	
	<ul style="display: flex;padding:0;transition: .6s" class="cont"> <%-- TAbla --%>
	<c:forEach items="${horarios.value}" var="horario">
		<li style="list-style:none">
		<div>
		
			<table border="1" class="tecnico-horario" style="width: 600px">	
				<tr>
					<c:forEach var="dia" items="${horario}"> 	
						<td class="contenedor">
							<table border="1" class="horario">
								<thead>
											<tr><th style="text-transform: lowercase;"><c:out value="${dia.key}"/></th></tr>
									</thead>
									<tbody>
										<c:forEach var="hora" items="${dia.value}"> 
											<tr>
											<td><c:out value="${hora.getHoraInicio()}"/></td>
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

</c:forEach>

<script src="${context}/js/horarios.js"></script>




</body>
</html>