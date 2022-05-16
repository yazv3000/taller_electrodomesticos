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
	<link rel="stylesheet" type="text/css" href="./css/mant.css">
	
	<!-- LIBRERIA DE TELEFONOS -->
	<link  rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />

</head> 
<body id="body">
	<div class="d-flex justify-content-center margen">
		<!-- DATOS DEL TECNICO SELECCIONADO -->
		<div class="card col-sm-4" id="formServPrest">
			<div class="card-body">
				<form class="justify-content-center needs-validation"  align="center" action="Validar" novalidate>
					<div class="form-group pt-2">
						<label class="formuTecTit">NOMBRES</label>
						<input type="text" name="nom_tec" class="form-control estinputs" placeholder="Nombre" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">APELLIDOS</label>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 160px;">
						<input type="text" class="form-control estinputs" name="ape_princ_tec" placeholder="Principal" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="float:right; width: 160px;">
						<input type="text" class="form-control estinputs" name="ape_sec_tec" placeholder="Secundario" required>
						<div class="valid-feedback estinputs">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">DIRECCION</label>
						<input type="text" name="calificacion" class="form-control estinputs" placeholder="Direccion" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">CORREO ELECTRONICO</label>
						<input type="email" name="calificacion" class="form-control estinputs" placeholder="Correo Electronico" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">TELEFONO</label>
					</div>
					<div class="form-group pt-1">
						<input id="phone" type="number" name="phone" class="form-control estinputs" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group text-center pt-2">
						<button type="submit" class="btn btn-warning"><b>Agregar</b></button>
					</div>
				</form>
			</div><!--  /.card-body -->
		</div><!-- /.card col-sm-4 -->
		
		
		<div class="col-sm-8 paddingsty" id="formServPrest">
			<table id="miTabla" class="table table-dark table-hover text-center">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRES Y APELLIDOS</th>
						<th>TELEFONO</th>
						<th>DIRECCION</th>
						<th>EMAIL</th>
						
					</tr>
				</thead>
				<tbody class="table-dark">
				<c:forEach items="${lstConsultaClientes}" var="c">
				<tr>
					<td> <c:out value="${c.getIdCliente()}"></c:out> </td>
					<td> <c:out value="${c.getNombreCompleto()}"></c:out> </td>
					<td> <c:out value="${c.getTelefono()}"></c:out> </td>
					<td> <c:out value="${c.getDireccion()}"></c:out> </td>
					<td> <c:out value="${c.getEmail()}"></c:out> </td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

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