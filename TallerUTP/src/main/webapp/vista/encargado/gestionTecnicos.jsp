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
    <link rel="icon" href="img/Logo.png" type="${context}/image/png">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    
    <title>Taller-UTP</title>
</head>

<body>
	<div class="contenido">
	    <div class="tabla">
	        <div class="tabla__tools">
	            <ul>
					<li><button class="fa-solid fa-plus-square icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"></button></li>
	                <li><button class="fa-solid fa-pen icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></li>
	                <li><button class="fa-solid fa-trash icono"></button></li>
	            </ul>
	            <input class="tabla_buscar" type="text" placeholder="Filtrar">
	        </div>
	        <div class="tabla__contenido">
	            <table id="tabla__Tecnico" >
	                <thead class="tabla__titulo">
	                    <tr>
	                        <th>ID</th>
							<th>NOMBRES Y APELLIDOS</th>
							<th>ESPECIALIDAD</th>
							<th>TELEFONO</th>
							<th>DISTRITO</th>
							<th>DIRECCION</th>
							<th>EMAIL</th>
	                    </tr>
	                </thead>
	                <tbody class="tabla__info">
	                	<c:forEach items="${lstConsultaTecnicos}" var="t">
	                    <tr id="tabla__filas" onclick="location.href='ServletGestionarTecnico?accion=editar&id=${t.getIdPersona()}'">
	                   		<td> <c:out value="${t.getIdUsuarioTecnico()}"></c:out> </td>
							<td> <c:out value="${t.getNombreCompleto()}"></c:out> </td>
							<td> <c:out value="${t.getEspecialidad()}"></c:out> </td>
							<td> <c:out value="${t.getTelefono()}"></c:out> </td>
							<td> <c:out value="${t.getDistrito()}"></c:out> </td>
							<td> <c:out value="${t.getDireccion()}"></c:out> </td>
							<td> <c:out value="${t.getEmail()}"></c:out> </td>			
	                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	        <div class="tabla__especificacion">
	        </div>
	    </div>

	<!-- ===== MODAL INSERTAR ===== -->
	<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="padding-right: 350px;">
	  <div class="modal-dialog" >
	    <div class="modal-content text-center" style="width: 800px; height: 550px;">
	                 
	      <div class="modal-body">
	        	<!-- ===== DATOS DEL NUEVO T�CNICO ===== -->
				<form  class="formulario needs-validation" action="<%=request.getContextPath()%>/ServletGestionarTecnico" method="post" novalidate>
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
			        <div class="form__contenedor pt-3">
			        	
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " required>
			                <label for="name" class="form__label">Primer nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control"  placeholder=" ">
			                <label for="name" class="form__label">Segundo nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " required>
			                <label for="name" class="form__label">Primer apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " required>
			                <label for="" class="form__label">Segundo Apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="cbx_tipodoc">
			                <option class="form__opcion" value=1  ${tec.getTipoDocumento() == 1 ? 'selected' : ''}>DNI</option>
			                <option class="form__opcion" value=2  ${tec.getTipoDocumento() == 2 ? 'selected' : ''}>Carne de Extranjer�a</option>
			                <option class="form__opcion" value=3  ${tec.getTipoDocumento() == 3 ? 'selected' : ''}>Otros</option>
			            </select>
			            <div class="form__grupo">
			                <input type="number" id="num-doc2" class="form__input form-control" placeholder=" " required>
			                <label for="name" class="form__label">N�mero de Documento:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="especialidad">
							<c:forEach items="${lstEspecialidades}" var="e">
				                <option class="form__opcion" value="${e.getIdEspecialidad()}">${e.getNomEsp()}</option>
							</c:forEach>
			            </select>
			            <div class="form__grupo">
			                <input type="number" id="tel-2" class="form__input form-control" placeholder=" " required>
			                <label for="name" class="form__label">Tel�fono:</label>
			                <span class="form__line"></span>
						</div>
						<select class="form__seleccion" name="cbx_distritos">
							<c:forEach items="${lstDistritos}" var="d">
								<option class="form__opcion" value="${d.getIdDistrito()}">${d.getNombreDistrito()}</option>
							</c:forEach>
						</select>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " required>
			                <label for="" class="form__label">Direccion:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <input type="number" id="an-exp2" class="form__input form-control" placeholder=" " required>
			                <label for="" class="form__label">A�os de Experiencia:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <input type="email" class="form__input form-control" placeholder=" " required>
			                <label for="" class="form__label">Correo Electronico:</label>
			                <span class="form__line"></span>
			            </div>
			        </div>
					<div class="row align-items-center pt-4">
						<div class="form__grupo col-12">
							<input name="accion" value="insertar"  class="btn__insertar" type="submit" >INSERTAR     
						</div>
					</div>
				</form>
				<!-- =====  FIN DATOS ===== -->
			</div><!-- /.modal-body -->
		</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal-fade -->
	
	<!-- ===== FINAL MODAL INSERTAR ===== -->   
	    
	<!-- ===== MODAL MODIFICAR ===== -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="padding-right: 350px;">
	  <div class="modal-dialog" >
	    <div class="modal-content text-center" style="width: 800px; height: 550px;">
	                 
	      <div class="modal-body">
	        	<!-- ===== DATOS DEL T�CNICO MODIFICAR ===== -->
				<form  class="formulario needs-validation" action="<%=request.getContextPath()%>/ServletGestionarTecnico" method="post" novalidate>
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
			        <div class="form__contenedor pt-3">
			        	
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${tec.getNombrePrin()}" name="" required>
			                <label for="name" class="form__label">Primer nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control"  placeholder=" " value="${tec.getNombreSec()}">
			                <label for="name" class="form__label">Segundo nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${tec.getApePrin()}" required>
			                <label for="name" class="form__label">Primer apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${tec.getApeSec()}" required>
			                <label for="" class="form__label">Segundo Apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="cbx_tipodoc">
			                <option class="form__opcion" value=1  ${tec.getTipoDocumento() == 1 ? 'selected' : ''}>DNI</option>
			                <option class="form__opcion" value=2  ${tec.getTipoDocumento() == 2 ? 'selected' : ''}>Carne de Extranjer�a</option>
			                <option class="form__opcion" value=3  ${tec.getTipoDocumento() == 3 ? 'selected' : ''}>Otros</option>
			            </select>
			            <div class="form__grupo">
			                <input type="number" id="num-doc1" class="form__input form-control" placeholder=" " value="${tec.getNroDocumento()}" required>
			                <label for="name" class="form__label">N�mero de Documento:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="especialidad">
				            <c:forEach items="${lstEspecialidades}" var="e">
				                <option class="form__opcion" value="${e.getIdEspecialidad()}"  ${tec.getIdEspecialidad()==e.getIdEspecialidad() ? 'selected' : ''}>${e.getNomEsp()}</option>
							</c:forEach>
			            </select>
			            <div class="form__grupo">
			                <input type="number" id="tel-1" class="form__input form-control" placeholder=" " value="${tec.getTelefono()}" required>
			                <label for="name" class="form__label">Tel�fono:</label>
			                <span class="form__line"></span>
			            </div>
			           <select class="form__seleccion" name="distrito">
			                <c:forEach items="${lstDistritos}" var="d">
			               	 <option class="form__opcion" value="${d.getIdDistrito()}"  ${cli.getIdDistrito()==d.getIdDistrito() ? 'selected' : ''}>${d.getNombreDistrito()}</option>
							</c:forEach>
			            </select>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${tec.getDireccion()}" required>
			                <label for="" class="form__label">Direccion:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <input type="number" id="an-exp1" class="form__input form-control" placeholder=" " value="${tec.getAniosExperiencia()}" required>
			                <label for="" class="form__label">A�os de Experiencia:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo" align="center">
			                <input type="email" class="form__input form-control" placeholder=" " value="${tec.getEmail()}" required>
			                <label for="" class="form__label">Correo Electronico:</label>
			                <span class="form__line"></span>
			            </div>
			        </div>
			        <div class="row align-items-center pt-4">
			            <div class="form__grupo col-12">
			                <input name="accion" value="actualizar" class="btn__modificar" type="submit" >MODIFICAR
			            </div>
			        </div>
			    </form>
				<!-- =====  FIN DATOS ===== -->
	      </div><!-- /.modal-body -->
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal-fade -->
	
	<!-- ===== FINAL MODAL MODIFICAR ===== -->    
	
	</div><!-- /.contenido -->
	
	<script src="${context}/js/validForm.js"></script>
	<script type="text/javascript" src="${context}/js/ValidacionMonto.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	
	 <!-- ===== JS BOOSTRAP ===== -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
    <script>
       $(document).ready(function () {
            $('#tabla__Tecnico').DataTable({
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
    	     if($(this).hasClass('row-selected')){
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
 
    </script>

</body>

</html>