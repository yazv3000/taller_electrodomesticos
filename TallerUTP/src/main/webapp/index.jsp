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
    <link rel="stylesheet" type="text/css" href="${context}/css/tabla.css">
	<!-- PRUEBA CONTRASEÑA -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Taller - UTP</title>
</head>
<body>
	
	<%@ page import="utp.taller.entidades.*"%>
	<%@ page import="java.util.List"%>
	<%@ page import="utp.taller.dao.*"%>
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
                <li><a class="nav__sesion" data-bs-toggle="modal" data-bs-target="#staticBackdrop1" >Sesion</a></li>
                <li><a href="<%=request.getContextPath()%>/ServletIniciarSesion?accion=listarDis" data-bs-target="#staticBackdrop2">Contacto</a></li>
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
    <div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" >
	  <div class="modal-dialog" >
	    <div class="modal-content text-center" style="width: 440px; height: 650px;">
	                 
	      <div class="modal-body">
            <form class="modal__formulario needs-validation" action="<%=request.getContextPath()%>/ServletIniciarSesion" method="post" novalidate>
                <div class="row align-items-center pt-1">
				      	<div class="form__grupo">
			            	<input class="modal__cerrar " type="button" data-bs-dismiss="modal" value="X" required>
			            </div>
			            <div class="form__grupo col-12">
				      		<div class="formTituloLogin">
				                <p>INICIAR SESIÓN</p>
				            </div>
			            </div>
			    </div>
                <img  class="form__logo" src="img/Logo.png" alt="">
                <input type="email" class="correo form-control" placeholder="Email" name="txt_user" required>
                <div class="input-group">
			      <input ID="txtPassword" type="Password" Class="pass form-control" placeholder="Contraseña" name="txt_pass" required>
			      <div class="input-group-append">
			            <button style="color: white; height: 40px;" id="show_password" class="btn btn__cerrar" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
			      </div>
			    </div>
                <select class="form__selector" name="cbx_rol" id="" >
                    <option value="1">Cliente</option>
                    <option value="2">Encargado</option>
                    <option value="3">Técnico</option>
                </select>
                <div class="col-12">
                <input type="submit" class="btn__ingresar" name="accion" value="Ingresar">
                </div>
                <div class="col-12 pt-3">
                <a  href="<%=request.getContextPath()%>/ServletIniciarSesion" class="btn__sinCuenta" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#staticBackdrop2" type="submit">¿No tiene cuenta?</a>
                </div>
            </form>
        </div>
    	</div>
      </div>
    </div>
    
    
    <!-- ===== MODAL INSERTAR ===== -->
	<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="padding-right: 340px;">
	  <div class="modal-dialog" >
	    <div class="modal-content text-center" style="width: 800px; height: 550px;">
	                 
	      <div class="modal-body">
	        	<!-- ===== DATOS DEL NUEVO CLIENTE===== -->
				<form class="formulario needs-validation" name="accion" action="<%=request.getContextPath()%>/ServletIniciarSesion" method="post" novalidate>
					<div class="row align-items-center pt-1">
				      	<div class="form__grupo col-11">
				      		<div class="form__titulo">
				                <p>INFORMACION DEL CLIENTE</p>
				            </div>
			            </div>
			            <div class="form__grupo col-1">
			            	<input class="btn__cerrar" type="button" data-bs-dismiss="modal" value="X" required>
			            </div>
			        </div>
			        <div class="form__contenedor pt-3">
			        	
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " name="txt_nom1" required>
			                <label for="name" class="form__label">Primer nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control"  placeholder=" " name="txt_nom2">
			                <label for="name" class="form__label">Segundo nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " name="txt_ape1" required>
			                <label for="name" class="form__label">Primer apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " name="txt_ape2">
			                <label for="" class="form__label">Segundo Apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion"  name="cbx_tipodoc">
			                <option class="form__opcion" value="1">DNI</option>
			                <option class="form__opcion" value="2">Carne de Extranjería</option>
			                <option class="form__opcion" value="3">Otros</option>
			            </select>
			            <div class="form__grupo">
			                <input type="number" id="num-doc1" class="form__input form-control" placeholder=" " name="num_doc" required>
			                <label for="name" class="form__label">Número de Documento:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="number" id="tel-1" class="form__input form-control" placeholder=" " name="num_telef" required>
			                <label for="name" class="form__label">Teléfono:</label>
			                <span class="form__line"></span>
			            </div>
						<select class="form__seleccion" name="cbx_distritos" >
						
						<%
						DaoDistrito daoDistr = new DaoDistrito();
						List<Distrito> lst = daoDistr.listar();
						%>
						<%
				        for(Distrito d : lst) {
				        %>
			                <option class="form__opcion" value="<%=d.getIdDistrito()%>"><%=d.getNombreDistrito()%></option>
						<%
				        }
						%>
						</select>
			            <div class="form__grupo" >
			                <input type="text" class="form__input form-control" placeholder=" " name="txt_direcc" required>
			                <label for="" class="form__label">Direccion:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <input type="email" class="form__input form-control" placeholder=" " name="txt_correo" required>
			                <label for="" class="form__label">Correo Electronico:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <div class="input-group">
			                	<script type="text/javascript" src="${context}/js/contrase.js"></script>
						      <input ID="txtPassword2" type="Password" Class="form__input form-control" placeholder="Contraseña" name="txt_pass" required>
						      <div class="input-group-append">
				              <button style="color: white;" id="show_password2" class="btn btn__cerrar" type="button" onclick="mostrarPassword2()"> <span class="fa fa-eye-slash icon"></span> </button>
				          	  </div>
			    			</div>
			            </div>
			        </div>
			        <div class="row align-items-center pt-4">
				      	<div class="form__grupo col-12 align-items-center">
			                <input name="accion" value="registrar"  class="btn__insertar" type="submit" >   
			            </div>
			        </div>
			    </form>
				<!-- =====  FIN DATOS ===== -->
	      </div><!-- /.modal-body -->
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal-fade -->
	
	<!-- ===== FINAL MODAL INSERTAR ===== -->
    <form action="">
    	<button></button>
    </form>
    <script type="text/javascript" src="${context}/js/contrase.js"></script>
    <script type="text/javascript" src="${context}/js/contrasena.js"></script>
    <script src="${context}/js/index.js"></script>   
    
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>  
</body>
</html>