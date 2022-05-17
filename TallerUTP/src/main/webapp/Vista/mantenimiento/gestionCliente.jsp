<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<!-- ESTILOS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css"  type="text/css" >
	<link rel="stylesheet" href="./css/style.css"  type="text/css" >

	<!-- LIBRERIA DE TELEFONOS -->
	<link  rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />

</head> 
<body>
	<div class="d-flex justify-content-center">
		<!-- DATOS DEL CLIENTE SELECCIONADO -->
		<div class="card col-sm-4">
			<div class="card-body">
				<form class="justify-content-center needs-validation"  align="center" action="Validar" novalidate>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">NOMBRES</label>
						<input type="text" value="${cli.getNombre()}"  name="txt_nomCli" class="form-control" placeholder="Nombres" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">APELLIDOS</label>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<input type="text" value="${cli.getApePrin()}" name="txt_ape1Cli" class="form-control" placeholder="Principal" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="float:right; width: 190px;">
						<input type="text" value="${cli.getApeSec()}" name="txt_ape2Cli" class="form-control" placeholder="Secundario" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="clear:both"></div>
					</div>

					<div class="form-group pt-2">
						<label class="formuTecTit">DOCUMENTO DE IDENTIDAD</label>
						<select name="tipo_docid">
							<option value=1  ${cli.getTipo_doc() == 1 ? 'selected' : ''}>DNI</option>
							<option value=2  ${cli.getTipo_doc() == 2 ? 'selected' : ''}>Carne de Extranjería</option>
							<option value=3  ${cli.getTipo_doc() == 3 ? 'selected' : ''}>Otros</option>
						</select>
						<input type="text" value="${cli.getNro_doc()}"  name="txt_docCli" class="form-control" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">TELEFONO</label>
					</div>
					<div class="form-group pt-1">
						<input id="phone"  value="${cli.getTelefono()}" name="txt_telefCli" class="form-control" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">DIRECCION</label>
						<input type="text" value="${cli.getDireccion()}"  name="txt_direcCli" class="form-control" placeholder="Direccion" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">CORREO ELECTRONICO</label>
						<input type="email" value="${cli.getEmail()}" name="txt_emailCli" class="form-control" placeholder="Correo Electronico" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
										
					<!--  BOTONES -->
					<div class="form-group text-center pt-2">
						<button type="submit" class="btn btn-warning"><b>Agregar</b></button>
						<button type="submit" class="btn btn-info"><b>Modificar</b></button>
					</div>
					
				</form>
			</div><!--  /.card-body -->
		</div><!-- /.card col-sm-4 -->
		
		
		<div class="col-sm-8" style="background-color: white;">
			<table id="miTabla" class="table table-dark table-hover text-center">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRES Y APELLIDOS</th>
						<th>TELEFONO</th>
						<th>DIRECCION</th>
						<th>EMAIL</th>
						<th>ACCION</th>
					</tr>
				</thead>
				<tbody class="table-light">
				<c:forEach items="${lstConsultaClientes}" var="c">
				<tr>
					<td> <c:out value="${c.getIdCliente()}"></c:out> </td>
					<td> <c:out value="${c.getNombreCompleto()}"></c:out> </td>
					<td> <c:out value="${c.getTelefono()}"></c:out> </td>
					<td> <c:out value="${c.getDireccion()}"></c:out> </td>
					<td> <c:out value="${c.getEmail()}"></c:out> </td>
<<<<<<< Updated upstream
					<td>
						  <a class="btn btn-info" href="ServletGestionarCliente?accion=editar&id=${c.getIdCliente()}">Editar</a>
                          <a class="btn btn-danger" href="ServletGestionarCliente?accion=eliminar&id=${c.getIdCliente()}">Eliminar</a>
=======
					<td class="td__acciones">
						  <a class="tabla__tools" href="ServletGestionarCliente?accion=editar&id=${c.getIdCliente()}"><button class="fa-solid fa-pen icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></a>
                          <a class="tabla__tools" href="ServletGestionarCliente?accion=eliminar&id=${c.getIdCliente()}"><button class="fa-solid fa-trash icono"></button></a>
							<!-- ===== MODAL INSERTAR ===== -->
	
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
							  Launch static backdrop modal
							</button>
							
							<!-- Modal -->
							<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							        <div class="card col-sm-4"  id="formServPrest">
									<div class="card-body">
										<form class="justify-content-center needs-validation"  align="center" action="Validar" novalidate>
											
											<div class="form-group pt-2">
												<label class="formuTecTit">NOMBRES</label>
												<input type="text" value="${cli.getNombre()}"  name="txt_nomCli" class="form-control" placeholder="Nombres" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
											</div>
											
											<div class="form-group pt-2">
												<label class="formuTecTit">APELLIDOS</label>
											</div>
											<div class="form-group pt-1">
												<div style="float:left; width: 190px;">
												<input type="text" value="${cli.getApePrin()}" name="txt_ape1Cli" class="form-control" placeholder="Principal" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
												</div>
												<div style="float:right; width: 190px;">
												<input type="text" value="${cli.getApeSec()}" name="txt_ape2Cli" class="form-control" placeholder="Secundario" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
												</div>
												<div style="clear:both"></div>
											</div>
						
											<div class="form-group pt-2">
												<label class="formuTecTit">DOCUMENTO DE IDENTIDAD</label>
												<select name="tipo_docid" style="color:black;">
													<option value=1  ${cli.getTipo_doc() == 1 ? 'selected' : ''}>DNI</option>
													<option value=2  ${cli.getTipo_doc() == 2 ? 'selected' : ''}>Carne de Extranjería</option>
													<option value=3  ${cli.getTipo_doc() == 3 ? 'selected' : ''}>Otros</option>
												</select>
												<input type="text" value="${cli.getNro_doc()}"  name="txt_docCli" class="form-control" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
											</div>
											
											<div class="form-group pt-2">
												<label class="formuTecTit">TELEFONO</label>
											</div>
											<div class="form-group pt-1">
												<input id="phone"  value="${cli.getTelefono()}" name="txt_telefCli" class="form-control" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
											</div>
											
											<div class="form-group pt-2">
												<label class="formuTecTit">DIRECCION</label>
												<input type="text" value="${cli.getDireccion()}"  name="txt_direcCli" class="form-control" placeholder="Direccion" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
											</div>
											
											<div class="form-group pt-2">
												<label class="formuTecTit">CORREO ELECTRONICO</label>
												<input type="email" value="${cli.getEmail()}" name="txt_emailCli" class="form-control" placeholder="Correo Electronico" required>
												<div class="valid-feedback">Campos Completos</div>
												<div class="invalid-feedback">Campos Incompletos</div>
											</div>
																
											<!--  BOTONES -->
											<div class="form-group text-center pt-2">
												<button type="submit" class="btn btn-warning"><b>Agregar</b></button>
												<button type="submit" class="btn btn-info"><b>Modificar</b></button>
											</div>
											
										</form>
									</div><!--  /.card-body -->
								</div><!-- /.card col-sm-4 -->
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							        <button type="button" class="btn btn-primary">Understood</button>
							      </div>
							    </div>
							  </div>
							</div>
							
						<!-- ===== FINAL MODAL ===== -->
							
>>>>>>> Stashed changes
					</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
<!--  SCRIPTS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

<!-- VALIDAR CAMPOS -->
<script src="./js/validForm.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>
<script src="./js/libreriaTel.js"></script>

<script>
	$(document).ready(function () {
		$('#miTabla').DataTable();
	});
</script>

</body>
</html>