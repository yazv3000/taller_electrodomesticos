<%@ page language="java"	contentType="text/html; charset=ISO-8859-1"		pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="context" value="${pageContext.request.contextPath}" /> 

<!DOCTYPE html>
<html lang="es-PE">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${context}/css/index.css">
    <link rel="icon" type="image/png" href="${context}/img/Logoa.png">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Taller - UTP</title>
</head>
<body>
    <!-- ===== IMAGEN DE FONDO ===== -->
    <img class="inicio_fondo" src="${context}/img/fondo.png" alt="Logotipo de HTML5"  />

    <!-- ===== BARRA DE NAVEGACION ===== -->
    <div class="menu">
        <nav class="navi">
            <div class="logo">
                <img src="${context}/img/Logoa.png" alt="">
                <h2>U<span>T</span>P</h2>
            </div>
            <ul>
                <li><a href="#">Inicio</a></li>
                <li><a href="#">Servicio</a></li>
                <li><a href="#">Nosotros</a></li>
                <li><a class="nav__sesion" href="#">Sesion</a></li>
                <li><a href="#">Contacto</a></li>
            </ul>
        </nav>
    </div>
    <!-- ===== ANIMACION ===== -->
    <div class="contenedor" >
        <div class="hex">
            <div class="hex__fondo hex-1">
                <div class="hex__img">
                    <img src="img/auricular.png" alt="" >
                </div>
            </div>
            <div class="hex__fondo hex-2">
                <div class="hex__img">
                    <img src="img/usuario.png" alt="" >
                </div>
            </div>
            <div class="hex__fondo hex-3">
                <div class="hex__img">
                    <img src="img/info.png" alt="" >
                </div>
            </div>
            <div class="hex__fondo hex-4">
                <div class="hex__img">
                    <img src="img/servicio.png" alt="" >
                </div>
            </div>
            <div class="hex__fondo hex-5">
                <div class="hex__img">
                    <img src="img/telefono.png" alt="" >
                </div>
            </div>
            <div class="hex__fondo hex-6">
                <div class="hex__img">
                    <img src="img/auricular.png" alt="" >
                </div>
            </div>
            <div class="hex__fondo hex-7">
                <div class="hex__img">
                    <img src="img/mundo.png" alt="" >
                </div>
            </div>
        </div>

    </div>


    <!-- ===== MODAL INICIAR SESION ===== -->
    <section class="modal__sesion">
        <div class="modal__contenedor">
            <div class="modal__cont__cerrar">
                <button class="modal__cerrar">x</button>
            </div>
            <form class="modal__formulario needs-validation" action="<%=request.getContextPath()%>/ServletIniciarSesion" method="post" novalidate>
                <h3 class="form__titulo">Iniciar Sesión</h3>
                <img  class="form__logo" src="img/Logo.png" alt="">
                <input type="email" class="correo form-control" placeholder="Email" name="txt_user" required>
                <input type="password" class="pass form-control" placeholder="Contraseña" name="txt_pass" required>
                <select class="form__selector" name="cbx_rol" id="" >
                    <option value="1">Cliente</option>
                    <option value="2">Encargado</option>
                    <option value="3">Técnico</option>
                </select>
                <input type="submit" class="btn__ingresar" name="accion" value="Ingresar"></input>
                <a style="color:aqua;">¿No tiene cuenta?</a>
            </form>
        </div>
    </section>
    <script src="${context}/js/index.js"></script>  
    <script src="${context}/js/validForm.js"></script> 
    
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
</body>
</html>