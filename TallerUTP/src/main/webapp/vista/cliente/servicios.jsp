<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${context}/css/servicios-2.css">
    <title>Document</title>
</head>
<body>
    <h1 class="titulo">Nuestros <span>Servicios</span></h1>
    <div class="contenedor">
        <div class="cont__servicio">
             <!-- ==== TARJETA 1 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo">
                    <div class="hex__img">
                        <img src="${context}/img/instalacion.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Instalaciones</h3>
                    <p class="serv__descripcion">Deja la instalacion de tus artefactos en manos de expertos.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0001&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>
                </div>
            </div>
             <!-- ==== TARJETA 2 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/ave.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Reparaciones</h3>
                    <p class="serv__descripcion">Soluciona las averias de tus artefactos con repuestos originales.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0002&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 3 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/conversiones.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Conversiones</h3>
                    <p class="serv__descripcion">Realiza la conversion de tu cocina a gas.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0003&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 4 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/mantenimiento.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Mantenimiento</h3>
                    <p class="serv__descripcion">Prolonga la vida ï¿½til de tus artefactos con cuidados preventivos.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0004&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 5 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/diagnostico.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Diagnostico tecnico</h3>
                    <p class="serv__descripcion">Si tu artefacto presenta averï¿½as, solicita evaluaciï¿½n tï¿½cnica del equipo.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0005&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 6 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/auricular.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Asesoría Técnica</h3>
                    <p class="serv__descripcion">Deja la instalacion de tus artefactos en manos de expertos</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0006&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 7 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/ave.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Venta de accesorios</h3>
                    <p class="serv__descripcion">Encuentra los accesorios originales que necesitas para tus artefactos.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0007&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 8 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/factibilidad.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Estudio de factibilidad</h3>
                    <p class="serv__descripcion">Verifica si el espacio donde se instalarï¿½ el artefacto cuenta con las condiciones tï¿½cnicas, elï¿½ctricas y de gasfiterï¿½a necesarias, para el ï¿½ptimo funcionamiento del producto.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0008&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
            <!-- ==== TARJETA 9 ===== -->
            <div class="servicio">
                <div class="serv__img"><div class="hex__fondo hex-1">
                    <div class="hex__img">
                        <img src="${context}/img/auricular.png" alt="" >
                    </div>
                </div></div>
                <div class="serv__info">
                    <h3 class="serv__titulo">Visitas tï¿½cnicas</h3>
                    <p class="serv__descripcion">Solicita la visita ténicanica de nuestros expertos para realizar el diagnóstico o reparación del artefacto en tu hogar.</p>
                    <a class="serv__link" href="<%=request.getContextPath()%>/ServletGestionarHorario?accion=listar&servicio=SERV-0009&idPersona=${dtoUsuario.getIdPersona()}">Solicitar</a>

                </div>
            </div>
        </div>
    </div>
</body>
</html>