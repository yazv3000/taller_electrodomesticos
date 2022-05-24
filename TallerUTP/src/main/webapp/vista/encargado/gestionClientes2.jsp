<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:set var="context" value="${pageContext.request.contextPath}" /> 
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
	    <div class="tabla" id="myTable">
	        <div class="tabla__tools">
	            <ul>
	            	<li><button class="fa-solid fa-plus-square icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"></button></li>
	                <li><button class="fa-solid fa-pen icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></li>
	                <li><button class="fa-solid fa-trash icono"></button></li>
	            </ul>
	            <input class="tabla_buscar" type="text" placeholder="Filtrar">
	        </div>
	        <div class="tabla__contenido">
	            <table id="tabla__Cliente" >
	                <thead class="tabla__titulo">
	                    <tr>
	                        <th>ID</th>
							<th>NOMBRES Y APELLIDOS</th>
							<th>TELEFONO</th>
							<th>DISTRITO</th>
							<th>DIRECCION</th>
							<th>EMAIL</th>
	                    </tr>
	                </thead>
	                <tbody class="tabla__info">
	                	<c:forEach items="${lstConsultaClientes}" var="c">
	                    <tr id="tabla__filas" class="now-selected" onclick="location.href='ServletGestionarCliente?accion=editar&id=${c.getIdPersona()}'">
	                        <td> <c:out value="${c.getIdUsuarioCliente()}"></c:out> </td>
							<td> <c:out value="${c.getNombreCompleto()}"></c:out> </td>
							<td> <c:out value="${c.getTelefono()}"></c:out> </td>
							<td> <c:out value="${c.getDistrito()}"></c:out> </td>
							<td> <c:out value="${c.getDireccion()}"></c:out> </td>
							<td> <c:out value="${c.getEmail()}"></c:out> </td>		
	                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	        <div class="tabla__especificacion">
	        </div>
	    </div>
	    
	    <!-- ===== MODAL INSERTAR ===== -->
	
	<!-- Button trigger modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="padding-right: 350px;">
	  <div class="modal-dialog" >
	    <div class="modal-content text-center" style="width: 800px; height: 550px;">
	                 
	      <div class="modal-body">
	        	<!-- ===== DATOS ===== -->
				<form  class="formulario needs-validation" action="<%=request.getContextPath()%>/ServletGestionarCliente?accion=" method="post" novalidate>
					<div class="row align-items-center pt-1">
				      	<div class="form__grupo col-11">
				      		<div class="form__titulo">
				                <p>INFORMACION DEL TECNICO</p>
				            </div>
			            </div>
			            <div class="form__grupo col-1">
			            	<input class="btn__cerrar" type="button" data-bs-dismiss="modal" value="X">
			            </div>
			        </div>
			        <div class="form__contenedor">
			        	
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" "  value="${cli.getNombrePrin()}" name="txt_nom1" required>
			                <label for="name" class="form__label" >Primer nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            
			            <div class="form__grupo">
			                <input type="text" class="form__input"  placeholder=" " value="${cli.getNombreSec()}" name="txt_nom2" required>
			                <label for="name" class="form__label">Segundo nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="${cli.getApePrin()}" name="txt_ape1" required>
			                <label for="name" class="form__label">Primer apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="${cli.getApeSec()}" name="txt_ape2" required>
			                <label for="" class="form__label">Segundo Apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="cbx_tipodoc">
			                <option class="form__opcion" value=1  ${cli.getTipoDocumento() == 1 ? 'selected' : ''}>DNI</option>
			                <option class="form__opcion" value=2  ${cli.getTipoDocumento() == 2 ? 'selected' : ''}>Carne de Extranjería</option>
			                <option class="form__opcion" value=3  ${cli.getTipoDocumento() == 3 ? 'selected' : ''}>Otros</option>
			            </select>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="${cli.getNroDocumento()}" name="num_doc" required>
			                <label for="name" class="form__label">Número de Documento:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="${cli.getTelefono()}" name="num_telef" required>
			                <label for="name" class="form__label">Teléfono:</label>
			                <span class="form__line"></span>
			            </div>
						<select class="form__seleccion" name="cbx_distritos">
						<c:forEach items="${lstDistritos}" var="d">
			                <option class="form__opcion" value="${d.getIdDistrito()}"  ${cli.getIdDistrito()==d.getIdDistrito() ? 'selected' : ''}>${d.getNombreDistrito()}</option>
						</c:forEach>
						</select>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="${cli.getDireccion()}" name="txt_direcc" required>
			                <label for="" class="form__label">Direccion:</label>
			                <span class="form__line"></span>
			            </div>

			            <select class="form__seleccion" name="estado">
			                <option class="form__opcion" value=true  ${cli.isEstadoActivo() ? 'selected' : ''}>Activo</option>
			                <option class="form__opcion" value=false  ${!cli.isEstadoActivo() ? 'selected' : ''}>Inactivo</option>
			            </select>
			            
			            <div class="form__grupo" align="center">
			                <input type="text" class="form__input" placeholder=" " value="${cli.getEmail()}" name="txt_correo" required>
			                <label for="" class="form__label">Correo Electronico:</label>
			                <span class="form__line"></span>
			            </div>
			        </div>
			        <div class="row align-items-center pt-4">
			            <div class="form__grupo col-12">
			                <a href="<%=request.getContextPath()%>/ServletGestionarCliente?accion=actualizar"  class="btn__modificar" type="submit" >MODIFICAR</a>
			            </div>
			        </div>
			    </form>
			
	<!-- =====  FIN DATOS ===== -->
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- ===== FINAL MODAL ===== -->


	<!-- Modal2 -->
	<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="padding-right: 350px;">
	  <div class="modal-dialog" >
	    <div class="modal-content text-center" style="width: 800px; height: 550px;">
	                 
	      <div class="modal-body">
	        	<!-- ===== DATOS ===== -->
				<form  class="formulario" >
					<div class="row align-items-center pt-1">
				      	<div class="form__grupo col-11">
				      		<div class="form__titulo">
				                <p>INFORMACION DEL TECNICO</p>
				            </div>
			            </div>
			            <div class="form__grupo col-1">
			            	<input class="btn__cerrar" type="button" data-bs-dismiss="modal" value="X" required>
			            </div>
			        </div>
			        <div class="form__contenedor">
			        	
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="" name="txt_nom1" required>
			                <label for="name" class="form__label">Primer nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            
			            <div class="form__grupo">
			                <input type="text" class="form__input"  placeholder=" " value="" name="txt_nom2" required>
			                <label for="name" class="form__label">Segundo nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="" name="txt_ape1" required>
			                <label for="name" class="form__label">Primer apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="" name="txt_ape2" required>
			                <label for="" class="form__label">Segundo Apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="tipo_docid" name="cbx_tipoDoc">
			                <option class="form__opcion" >DNI</option>
			                <option class="form__opcion" >Carne de Extranjería</option>
			                <option class="form__opcion" >Otros</option>
			            </select>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " name="nro_Doc" required>
			                <label for="name" class="form__label">Número de Documento:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " name="num_telef" required>
			                <label for="name" class="form__label">Teléfono:</label>
			                <span class="form__line"></span>
			            </div>
						<select class="form__seleccion" name="cbx_distritos">
						<c:forEach items="${lstDistritos}" var="d">
			                <option class="form__opcion" value="${d.getIdDistrito()}">${d.getNombreDistrito()}</option>
						</c:forEach>
						</select>
			            <div class="form__grupo" >
			                <input type="text" class="form__input" placeholder=" " name="txt_direcc" required>
			                <label for="" class="form__label">Direccion:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <input type="text" class="form__input" placeholder=" " name="txt_correo" required>
			                <label for="" class="form__label">Correo Electronico:</label>
			                <span class="form__line"></span>
			            </div>
			        </div>
			        <div class="row align-items-center pt-4">
				      	<div class="form__grupo col-12">
			                <input class="btn__insertar" type="submit" value="INSERTAR">           
			            </div>
			        </div>
			    </form>
			
	<!-- =====  FIN DATOS ===== -->
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- ===== FINAL MODAL2 ===== -->    


	</div>
	
	

	
		

	
	
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<!-- ESTILOS PARA VALIDAR FORM -->
	<script type="text/javascript" src="${context}/validForm.js"></script>
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