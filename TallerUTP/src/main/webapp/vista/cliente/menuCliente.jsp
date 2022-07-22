<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page session="true" %>
<c:set var="context" value="${pageContext.request.contextPath}" /> 

<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="icon" href="${context}/img/Logoa.png" type="image/png" >
    <link rel="stylesheet" href="${context}/css/menu-tecnico.css">
    <title>Taller-UTP</title>
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
                        <a href="${context}/ServletCitasCliente" class="nav__link" target="marco">Citas</a>
                        <div class="nav__linea"></div>
                    </li>   
					
                    <li class="nav__item">
                        <a href="${context}/ServletServicios" class="nav__link" target="marco">Servicios</a>
                        <div class="nav__linea"></div>
                    </li>   
                    
                    <li class="nav__item">
                        <a href="${context}/ServletServicios" class="nav__link" target="marco">Presupuesto</a>
                        <div class="nav__linea"></div>
                    </li>   
                </ul>
                
                <!--===== DATOS DEL USUARIO =====-->
                <div class="nav__user">
                	 <c:set var="foto_perfil" value="${sessionScope.dtoUsuario.getProfilePic()}" />
              	     <c:choose>
                       <c:when test="${foto_perfil==null}">
                       	<img class="nav__img" src="${context}/img/personas/default.jpg" alt="">
                       </c:when>
                       <c:otherwise>
				        <img class="nav__img" src="${context}/${foto_perfil}" alt="">
				    </c:otherwise>
                      </c:choose>
                    
                    <a class="nav__name" href="#"><c:out value="${sessionScope.dtoUsuario.getUsername()}"/></a>
                    <a class="cerrar" href="${context}/ServletLogout" class="nav__link"><i class="fa-solid fa-arrow-right-from-bracket icono"></i></a>
                    
                </div>
                <!--====FIN DATOS DEL USUARIO ====-->
                <div class="nav__barras">
                    <i class="fa-solid fa-bars icono"></i>
                </div>
            </div>
        </div>
    </nav>
   
    <iframe src="${context}/ServletServicios" class="marco" name="marco" frameborder="0"></iframe>
    <script src="${context}/js/menu-tec.js"></script>
</body>
</html>