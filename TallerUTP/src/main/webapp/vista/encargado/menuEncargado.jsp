<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
    <link rel="stylesheet" href="${context}/css/menu.css">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
	<link rel="icon" href="${context}/img/Logoa.png" type="image/png" >
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    <!-- ===== ACTUALIZAR CSS SIN GUARDAR EN CACHE ===== -->
    <meta http-equiv="Expires" content="0">
	<meta http-equiv="Last-Modified" content="0">
	<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
  	<meta http-equiv="Pragma" content="no-cache">
    
    
    <title>Taller-UTP</title>
</head>

<body>
    <div class="contenedor">
        <!-- ====== MENÚ ====== -->
        <div class="menu">
            <nav class="navi">
                <div>
                     <!-- ===== LOGO ===== -->
                     <div class="logo">
                        <i class="fa-solid fa-bars  logo__icono"></i>
                        <div class="logo__img">
                            <img src="${context}/img/Logoa.png" alt="">
                        </div>
                        <h2>U<span>T</span>P</h2>
                    </div>
                    <!-- ===== LINK ===== -->
                    <div class="nav__lista">
                        <a href="<%=request.getContextPath()%>/ServletGestionarCliente?accion=listar" class="nav__link" target="marco">
                            <i class="fa-solid fa-user nav__icono"></i>
                            <span class="nav__nombre">Clientes</span>
                        </a>
                        <a href="<%=request.getContextPath()%>/ServletGestionarTecnico?accion=listar" class="nav__link" target="marco">
                            <i class="fa-solid fa-screwdriver-wrench nav__icono"></i>
                            <span class="nav__nombre">Tecnicos</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fas fa-calendar-check nav__icono"></i>
                            <span class="nav__nombre">Citas</span>
                        </a>
                        <a href="<%=request.getContextPath()%>/ServletGestionarElectrodomestico?accion=listar" class="nav__link" target="marco">
                            <i class="fas fa-blender nav__icono"></i>
                            <span class="nav__nombre">Electrodomesticos</span>
                        </a>
                        <a href="<%=request.getContextPath()%>/ServletGestionarElectrodomestico?accion=listar" class="nav__link">
                            <i class="fa-solid fa-calendar-days nav__icono"></i>
                            <span class="nav__nombre">Horarios</span>
                        </a>
                        <a href="<%=request.getContextPath()%>/ServletGestionarPieza?accion=listar" class="nav__link" target="marco">
                            <i class="fa-solid fa-bag-shopping nav__icono"></i>
                            <span class="nav__nombre">Piezas</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-arrow-trend-up nav__icono"></i>
                            <span class="nav__nombre">Reportes</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-gear nav__icono"></i>
                            <span class="nav__nombre">Configuraciones</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-arrow-right-from-bracket nav__icono"></i>
                            <span class="nav__nombre">Salir</span>
                        </a>
                        
                    </div>
                </div>
            </nav>
        </div>

        <!-- ===== CONTENIDO ===== -->
        <div class="asunto">
            <div class="barra">
                <input class="buscar" type="text" placeholder="Buscar">
                <span class="usuario__img"></span>
            </div>
			
			<div class="ventana">
            <iframe src="<%=request.getContextPath()%>/ServletGestionarCliente?accion=listar" id="ventana__contenido" name="marco"></iframe>
			</div>
        </div>

    </div>
    <!-- ===== JAVASCRIPT ===== -->

    <script src="${context}/js/menu.js"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#example').DataTable({
                // responsive: true
            });
        });
    </script>

</body>

</html>