<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="${context}/css/ResumenAtencion.css">
<title>Insert title here</title>
</head>
<body>
	<h3 class="cliente">Cliente</h3>
        <div class="grid__seccion">
            <div class="grid__items"><i class="fa-solid fa-user icono"></i><span>Juan Perez</span></div>
            <div class="grid__items"><i class="fa-solid fa-location-dot"></i><span>Cerro Colorado</span></div>
            <div class="grid__items"><i class="fa-solid fa-mobile-screen-button"></i><span>990154585</span></div>
            
        </div>
    <h3 class="cliente">Cita</h3>
        <div class="grid__seccion">
            <div class="grid__items"><i class="fa-solid fa-calendar"></i><span>Reparacion</span></div>
            <div class="grid__items"><i class="fa-solid fa-calendar"></i><span> Fecha Reserva:31 de Mayo del 2022</span></div>
            <div class="grid__items"><i class="fa-solid fa-user icono"></i><span>Fecha Cita:02 de Junio del 2022</span></div>
            <div class="grid__items"><i class="fa-solid fa-location-dot"></i><span>08:00</span></div>
            <div class="grid__items"><i class="fa-solid fa-mobile-screen-button"></i><span>Pendiente</span></div>
            
        </div>
    <h3 class="cliente">Electrodomestico</h3>
        <div class="grid__seccion">
            <div class="grid__items"><i class="fa-solid fa-calendar"></i><span>Licuadora</span></div>
            <div class="grid__items"><i class="fa-solid fa-user icono"></i><span>Oster</span></div>
            <div class="grid__items"><i class="fa-solid fa-location-dot"></i><span>02546684</span></div>
            <div class="grid__items"><i class="fa-solid fa-mobile-screen-button"></i><span>TZ-3000</span></div>
            <div class="grid__items"><i class="fa-solid fa-mobile-screen-button"></i><span>FALLA DE MOTOR</span></div>
        </div>
	<h1><c:out value="${ate.getIdCita()}"></c:out></h1>
	<h1><c:out value="${ate.getCliente().getNombreCompleto()}"></c:out></h1>
	<h1><c:out value="${ate.getElectrodomestico().getModelo()}"></c:out></h1>
</body>
</html>