<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="contenido">
	    <div class="tabla" id="myTable">
	        <div class="tabla__tools">
	            <ul>
	            	<li><button class="fa-solid fa-plus-square icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"></button></li>
	                <li><button class="fa-solid fa-pen icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></li>
	                <li><button type="button" class="btn btn-primary" onclick="location.href='ServletGestionarCliente?accion=listar'" >Todos</button></li>
	                <li><button type="button" class="btn btn-success" onclick="location.href='ServletGestionarCliente?accion=listar&lista=activos'" >Activos</button><li>
	                <li><button type="button" class="btn btn-danger" onclick="location.href='ServletGestionarCliente?accion=listar&lista=inactivos'">Inactivos</button><li>
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
							<th>ESTADO</th>
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
							<td>
									<c:if  test="${c.isEstadoActivo()}">
										<a class="fa-solid fa-toggle-on icono" href="${context}/ServletGestionarCliente?accion=desactivar&id=${c.getIdPersona()}"></a>									
									</c:if>
									<c:if test="${!c.isEstadoActivo()}">
										<a class="fa-solid fa-toggle-off icono" href="${context}/ServletGestionarCliente?accion=activar&id=${c.getIdPersona()}"></a>	
									</c:if>
							</td>
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
	        	<!-- ===== DATOS DEL NUEVO CLIENTE===== -->
				<form class="formulario needs-validation" action="<%=request.getContextPath()%>/ServletGestionarCliente" method="post" novalidate>
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
						      <input ID="txtPassword" type="Password" Class="form__input form-control" placeholder="Contraseña" name="txt_pass" required>
						      <div class="input-group-append">
				              <button style="color: white;" id="show_password" class="btn modal__cerrar" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
				          	  </div>
			    			</div>
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
	        	<!-- ===== DATOS DEL CLIENTE A MODIFICAR ===== -->
				<form  class="formulario needs-validation"  action="<%=request.getContextPath()%>/ServletGestionarCliente" method="post" novalidate>
					<div class="row align-items-center pt-1">
				      	<div class="form__grupo col-11">
				      		<div class="form__titulo">
				                <p>INFORMACION DEL CLIENTE</p>
				            </div>
			            </div>
			            <div class="form__grupo col-1">
			            	<input class="btn__cerrar" type="button" data-bs-dismiss="modal" value="X">
			            </div>
			        </div>
			        <div class="form__contenedor pt-3">
			        	
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" "  value="${cli.getNombrePrin()}" name="txt_nom1" required>
			                <label for="name" class="form__label" >Primer nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control"  placeholder=" " value="${cli.getNombreSec()}" name="txt_nom2">
			                <label for="name" class="form__label">Segundo nombre:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${cli.getApePrin()}" name="txt_ape1" required>
			                <label for="name" class="form__label">Primer apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${cli.getApeSec()}" name="txt_ape2">
			                <label for="" class="form__label">Segundo Apellido:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="cbx_tipodoc">
			                <option class="form__opcion" value=1  ${cli.getTipoDocumento() == 1 ? 'selected' : ''}>DNI</option>
			                <option class="form__opcion" value=2  ${cli.getTipoDocumento() == 2 ? 'selected' : ''}>Carne de Extranjería</option>
			                <option class="form__opcion" value=3  ${cli.getTipoDocumento() == 3 ? 'selected' : ''}>Otros</option>
			            </select>
			            <div class="form__grupo">
			                <input type="number" id="num-doc2" class="form__input form-control" placeholder=" " value="${cli.getNroDocumento()}" name="num_doc" required>
			                <label for="name" class="form__label">Número de Documento:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="number" id="tel-2" class="form__input form-control" placeholder=" " value="${cli.getTelefono()}" name="num_telef" required>
			                <label for="name" class="form__label">Teléfono:</label>
			                <span class="form__line"></span>
			            </div>
						<select class="form__seleccion" name="cbx_distritos">
						<c:forEach items="${lstDistritos}" var="d">
			                <option class="form__opcion" value="${d.getIdDistrito()}"  ${cli.getIdDistrito()==d.getIdDistrito() ? 'selected' : ''}>${d.getNombreDistrito()}</option>
						</c:forEach>
						</select>
			            <div class="form__grupo">
			                <input type="text" class="form__input form-control" placeholder=" " value="${cli.getDireccion()}" name="txt_direcc" required>
			                <label for="" class="form__label">Direccion:</label>
			                <span class="form__line"></span>
			            </div>

			            <select class="form__seleccion" name="estado">
			                <option class="form__opcion" value=true  ${cli.isEstadoActivo() ? 'selected' : ''}>Activo</option>
			                <option class="form__opcion" value=false  ${!cli.isEstadoActivo() ? 'selected' : ''}>Inactivo</option>
			            </select>
			            
			            <div class="form__grupo" align="center">
			                <input type="email" class="form__input form-control" placeholder=" " value="${cli.getEmail()}" name="txt_correo" required>
			                <label for="" class="form__label">Correo Electronico:</label>
			                <span class="form__line"></span>
			            </div>
			        </div>
			        <div class="row align-items-center pt-4">
			            <div class="form__grupo col-12">
			                <input name="accion" value="actualizar"  class="btn__modificar" type="submit" >MODIFICAR
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