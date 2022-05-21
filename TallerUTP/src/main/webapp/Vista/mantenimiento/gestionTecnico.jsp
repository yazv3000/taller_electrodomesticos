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
	    <div class="tabla">
	        <div class="tabla__tools">
	            <ul>
	                <li><button class="fa-solid fa-pen icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></li>
	                <li><button class="fa-solid fa-trash icono"></button></li>
	                <li><button class="fa-solid fa-arrows-rotate icono"  data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></li>
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
	                   		<td> <c:out value="${t.getIdTecnico()}"></c:out> </td>
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
	
	<!-- Button trigger modal -->
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="width:600px">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        	<!-- ===== DATOS ===== -->
		<div class="card col-sm-12"  id="formServPrest" style="width: 100%">
			<div class="card-body">
				<form class="justify-content-center needs-validation"  align="center" action="Validar" novalidate>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">NOMBRES</label>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<input type="text" value="${tec.getNombrePrin()}" name="txt_nom1Tec" class="form-control" placeholder="Principal" required>
						</div>
						<div style="float:right; width: 190px;">
						<input type="text" value="${tec.getNombreSec()}" name="txt_nom2Tec" class="form-control" placeholder="Secundario" required>
						</div>
						<div style="clear:both"></div>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">APELLIDOS</label>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<input type="text" value="${tec.getApePrin()}" name="txt_ape1Tec" class="form-control" placeholder="Principal" required>
						</div>
						<div style="float:right; width: 190px;">
						<input type="text" value="${tec.getApeSec()}" name="txt_ape2Tec" class="form-control" placeholder="Secundario" required>
						</div>
						<div style="clear:both"></div>
					</div>

					<div class="form-group pt-2">
						<label class="formuTecTit" style="padding: 10px">DOCUMENTO DE IDENTIDAD</label>
						<select class="form-control" name="tipo_docid" style="color:black; padding: 10px;">
							<option value=1  ${tec.getTipo_doc() == 1 ? 'selected' : ''}>DNI</option>
							<option value=2  ${tec.getTipo_doc() == 2 ? 'selected' : ''}>Carne de Extranjería</option>
							<option value=3  ${tec.getTipo_doc() == 3 ? 'selected' : ''}>Otros</option>
						</select>
						<input type="text" value="${tec.getNro_doc()}"  name="txt_docCli" class="form-control" required>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">TELEFONO</label>
					</div>
					<div class="form-group pt-1">
						<input id="phone"  value="${tec.getTelefono()}" name="txt_telefCli" class="form-control" required>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">DIRECCION</label>
						<input type="text" value="${tec.getDireccion()}"  name="txt_direcCli" class="form-control" placeholder="Direccion" required>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">EXPERIENCIA</label>
						<input id="campo-numerico" type="number" value="${tec.getAnios_experiencia()}" class="form-control" name="txt_anios_experiencia" placeholder="Experiencia" required>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">CORREO ELECTRONICO</label>
						<input type="email" value="${tec.getEmail()}" name="txt_emailCli" class="form-control" placeholder="Correo Electronico" required>
					</div>
							
					<!--  BOTONES -->
					<div class="form-group text-center pt-2">
						<button type="submit" class="btn btn-warning"><b>Agregar</b></button>
						<button type="submit" class="btn btn-info"><b>Modificar</b></button>
					</div>
					
				</form>
			</div><!--  /.card-body -->
		</div>
	<!-- =====  FIN DATOS ===== -->
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Salir</button>
	        <button type="button" class="btn btn-primary">Understood</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- ===== FINAL MODAL ===== -->
	    
	    
	    
	    
	    
	</div>
	
	

	
		

	
	
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