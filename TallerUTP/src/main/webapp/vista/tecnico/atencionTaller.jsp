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

    <link rel="stylesheet" type="text/css" href="${context}/css/tabla.css">
    <link rel="icon" href="img/Logo.png" type="image/png">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Taller-UTP</title>
</head>

<body>
	
	<div class="contenido">
		<h1 class="titulo">ATENCION EN <span>EL TALLER</span></h1>
	        	<!-- ===== DATOS DEL NUEVO CLIENTE===== -->
				<form class="col-11 formulario needs-validation" action="<%=request.getContextPath()%>/ServletAtencionTaller" method="post" novalidate>
			      	<div class="form__grupo col-12">
			      		<div class="form__titulo">
			                <p>INFORMACION DEL CLIENTE</p>
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
						<select class="form__seleccion" name="cbx_distritos">
						<c:forEach items="${lstDistritos}" var="d">
			                <option class="form__opcion" value="${d.getIdDistrito()}">${d.getNombreDistrito()}</option>
						</c:forEach>
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
						      <input id="txtPassword" type="password" class="form__input form-control" placeholder="Contraseña" name="txt_pass" required>
						      <div class="input-group-append">
				              <button style="color: white;" id="show_password" class="btn btn__cerrar" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
				          	  </div>
			    			</div>
			            </div>
			            </div>
			            <div class="form__grupo col-12">
				      		<div class="form__titulo">
				                <p>INFORMACION DEL ELECTRODOMESTICO</p>
				            </div>
			            </div>
			             <div class="form__contenedor pt-3">
				            <div class="form__grupo">
				                <input type="text" class="form__input form-control" placeholder=" " name="txt_numSer" required>
				                <label for="name" class="form__label">Número de Serie:</label>
				                <span class="form__line"></span>
				            </div>
				           	<select class="form__seleccion" name="cbx_tipos">
							<c:forEach items="${lstTipos}" var="t">
				                <option class="form__opcion" value="${t.getId()}">${t.getNombre()}</option>
							</c:forEach>
							</select>
							<div class="form__grupo">
				                <input type="text" class="form__input form-control" placeholder=" " name="txt_modelo" required>
				                <label for="name" class="form__label">Modelo:</label>
				                <span class="form__line"></span>
				            </div>
							<select class="form__seleccion" name="cbx_marcas">
							<c:forEach items="${lstMarcas}" var="m">
				                <option class="form__opcion" value="${m.getId()}">${m.getNombre()}</option>
							</c:forEach>
							</select>
							<select class="form__seleccion" name="cbx_tipos_Serv" style="height: 40px;">
								<c:forEach items="${lstServicios}" var="s">
					                <option class="form__opcion" value="${s.getIdServicio()}">${s.getNomServicio()}</option>
								</c:forEach>
							</select>
							<div class="form__grupo">
								<textarea class="form__input form-control" name="txt_falla" id="" cols="30" rows="5"
									placeholder=" "></textarea>
								<label for="name" class="form__label" >Descripcion de la falla</label>
							</div>
				        </div>
				        <div class="row align-items-center pt-4">
					      	<div class="form__grupo col-12">
				                <input name="accion" value="insertar"  class="btn__insertar" type="submit" >INSERTAR      
				            </div>
				        </div>
			   	 </form>
				<!-- =====  FIN DATOS ===== -->
	</div>    
	<script src="${context}/js/validForm.js"></script> 
	<script type="text/javascript" src="${context}/js/contrase.js"></script>
	<script type="text/javascript" src="${context}/js/ValidacionMonto.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<!-- ESTILOS PARA VALIDAR FORM -->
	
	 <!-- ===== JS BOOSTRAP ===== -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${context}/js/PruebaPermanenciavariable.js"></script>
 
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
        
		
       $(function(){
    	   $('tr').click(function(e){
    	     if($(this).hasClass('.row-selected')){
    	       $(this).addClass('other-clic')
    	     }else{
    	       cleanTr()
    	       $(this).addClass('row-selected')
    	     }
    	   })
    	   
    	   
    	   function cleanTr(){
    	     $('.row-selected').each(function(index, element){
    	       $(element).removeClass('row-selected')
    	       $(element).removeClass('other-clic')
    	     })
    	   }
    	 })
    var ashu = document.querySelectorAll("tr");

		for (let i = 0; i < contenido.length; i++) {
			ashu[i].addEventListener("click", () => {
				ashu[i].style.backgroundColor="red";
			});
		
		}
    </script>

</body>

</html>