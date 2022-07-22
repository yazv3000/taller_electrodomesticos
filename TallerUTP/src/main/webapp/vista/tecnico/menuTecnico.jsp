<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
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
                        <a href="${context}/ServletActualizarAtencion" class="nav__link" target="marco">Atenciones</a>
                        <div class="nav__linea"></div>
                    </li>
                    <li class="nav__item">
                        <a href="${context}/ActualizarPresupuesto" class="nav__link" target="marco">Presupuestos</a>
                        <div class="nav__linea"></div>
                    </li>
                    <li class="nav__item">
                        <a href="${context}/ServletHorariosDisponibles?accion=listarTecnico" class="nav__link" target="marco">Horarios</a>
                        <div class="nav__linea"></div>
                    </li>  
                    <li class="nav__item">
                        <a href="${context}/ServletAtencionTaller?accion=tan&&id=<c:out value="${sessionScope.dtoUsuario.getIdPersona()}"/>" class="nav__link" target="marco">Taller</a>
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
                	 <a class="cerrar" href="${context}/ServletLogout"  class="cerrar"><i class="fa-solid fa-arrow-right-from-bracket icono"></i></a>
                	
                </div>
                <!--====FIN DATOS DEL USUARIO ====-->
                <div class="nav__barras">
                    <i class="fa-solid fa-bars icono"></i>
                </div>
            </div>
        </div>
    </nav>

    <iframe src="${context}/ServletActualizarAtencion" class="marco" name="marco" frameborder="0"></iframe>
    <script src="${context}/js/menu-tec.js"></script>
	<!-- LIBRERIA DATATABLE -->
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script>
	$(document).ready(function () {
        $('#tabla__Cliente').DataTable({
            "language": {
            	"sSearch":"Buscar",
            	"oPaginate":{
            		"sPrevious": "Anterior",
                	"sNext": "Siguiente"
            	}	
            }
        });
    });  
    </script>
</body>
</html>