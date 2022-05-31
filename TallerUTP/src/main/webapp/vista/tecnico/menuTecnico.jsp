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
    <link rel="icon" href="${context}/img/Logoa.png" type="image/png" >
    <link rel="stylesheet" href="${context}/css/menu-tecnico.css">
    <title>Document</title>
</head>
<body>
    <nav class="navegador">
        <div class="nav__contenido">
            <div class="nav__logo">
                <img src="${context}/img/Logo.png" alt="">
                <p>U<span>T</span>P</p>
            </div>

            <div class="nav__control">

                <ul class="nav__lista nav__lista--ocultar">
                    <li class="nav__item">
                        <a href="${context}/tecnico-citas.jsp" class="nav__link" target="marco">Citas</a>
                        <div class="nav__linea"></div>
                    </li>
                    <li class="nav__item">
                        <a href="${context}/ServletGestionarHorario?accion=listarTecnico" class="nav__link" target="marco">Horario</a>
                        <div class="nav__linea"></div>
                    </li>  
                    <li class="nav__item">
                        <a href="#" class="nav__link" target="">Nuevo</a>
                        <div class="nav__linea"></div>
                    </li>      
                </ul>
                
                <div class="nav__user">
                    <img class="nav__img" src="${context}/img/tony.jpg" alt="">
                    <a class="nav__name" href="#">Tony Stark</a>
                </div>
                <div class="nav__barras">
                    <i class="fa-solid fa-bars icono"></i>
                </div>
            </div>
        </div>
    </nav>

    <iframe src="${context}/tecnico-citas.jsp" class="marco" name="marco" src="" frameborder="0"></iframe>
    <script src="${context}/js/menu-tec.js"></script>
</body>
</html>