<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
	<link rel="icon" href="../img/ico.png" type="image/png" >
	<title>ADMINISTRACION - TALLER UTP</title>
	
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- ESTILOS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/menu.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    
</head>

<body>
    <div class="contenedor">
        <!-- ====== MEN� ====== -->
        <div class="menu">
            <nav class="navi">
                <div>
                     <!-- ===== LOGO ===== -->
                     <div class="logo">
                        <i class="fa-solid fa-bars  logo__icono"></i>
                        <img src="../img/Logoa.png" alt="">
                        <h2>U <span>T</span> P</h2>
                    </div>
                    <!-- ===== LINK ===== -->
                    <div class="nav__lista">
                        <a href="<%=request.getContextPath()%>/ServletGestionarCliente?accion=listar" class="nav__link" target="myFrame">
                            <i class="fa-solid fa-user nav__icono"></i>
                            <span class="nav__nombre">Clientes</span>
                        </a>
                        <a href="<%=request.getContextPath()%>/ServletGestionarTecnico?accion=listar" class="nav__link" target="myFrame">
                            <i class="fa-solid fa-screwdriver-wrench nav__icono"></i>
                            <span class="nav__nombre">Tecnicos</span>
                        </a>
                        <a href="Cita.jsp" class="nav__link" target="myFrame">
                            <i class="fas fa-calendar-check nav__icono"></i>
                            <span class="nav__nombre">Citas</span>
                        </a>
                        <a href="Horario.jsp" class="nav__link" target="myFrame">
                            <i class="fa-solid fa-calendar-days nav__icono"></i>
                            <span class="nav__nombre">Horarios</span>
                        </a>
                        <a href="<%=request.getContextPath()%>/ServletGestionarPieza?accion=listar" class="nav__link" target="myFrame">
                            <i class="fa-solid fa-bag-shopping nav__icono"></i>
                            <span class="nav__nombre">Piezas</span>
                        </a>
                        <a href="Reportes.jsp" class="nav__link" target="myFrame">
                            <i class="fa-solid fa-arrow-trend-up nav__icono"></i>
                            <span class="nav__nombre">Reportes</span>
                        </a>
                        <a href="Tecnico.jsp" class="nav__link" target="myFrame">
                            <i class="fa-solid fa-gear nav__icono"></i>
                            <span class="nav__nombre">Configuraciones</span>
                        </a>
                        <a href="Login.jsp" class="nav__link">
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
            <div class="tamano">
                <iframe class="tamano2" name="myFrame"></iframe>
            </div>
        </div>
    </div>
    <!-- ===== JAVASCRIPT ===== -->
    <script src="../js/menu.js"></script>
    
</body>

</html>