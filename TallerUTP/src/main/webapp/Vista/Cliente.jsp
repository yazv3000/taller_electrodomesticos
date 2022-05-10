<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="icon" type="image/png" href="../img/ico.png">
<!-- LIBRERIA DE TELEFONOS -->
<link  rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>

<title>TECNICOS - TALLER UTP</title>
</head> 
<body>
	<div class="d-flex justify-content-center">
		<div class="card col-sm-4">
			<div class="card-body">
				<form class="justify-content-center needs-validation" align="center" action="Validar" novalidate>
					<div class="form-group pt-2">
						<label class="formuTecTit">NOMBRES</label>
						<input type="text" name="nom_tec" class="form-control" placeholder="Nombre" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">APELLIDOS</label>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<input type="text" class="form-control" name="ape_princ_tec" placeholder="Principal" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="float:right; width: 190px;">
						<input type="text" class="form-control" name="ape_sec_tec" placeholder="Secundario" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">DIRECCION</label>
						<input type="text" name="calificacion" class="form-control" placeholder="Direccion" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">TELEFONO</label>
					</div>
					<div class="form-group pt-1">
						<input id="phone" type="number" name="phone" class="form-control" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group text-center pt-2">
						<button type="submit" class="btn btn-warning"><b>Agregar</b></button>
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-8" style="background-color: white;">
			<table id="miTabla" class="table table-dark table-hover text-center">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRES</th>
						<th>APELLIDOS</th>
						<th>DIRECCION</th>
						<th>TELEFONO</th>
					</tr>
				</thead>
				<tbody class="table-light">
				<tr>
					<th>1</th>
					<th>LUIS</th>
					<th>PUMRA/HERENCIA</th>
					<th>AV. ZARUMILLA</th>
					<th>931383044</th>
				</tr>
				<tr>
					<th>2</th>
					<th>puis</th>
					<th>PUMRA/HERENCIA</th>
					<th>AV. ZARUMILLA</th>
					<th>931383044</th>
				</tr>
				<tr>
					<th>1</th>
					<th>mani</th>
					<th>PUMRA/HERENCIA</th>
					<th>AV. ZARUMILLA</th>
					<th>931383044</th>
				</tr>					
				</tbody>
			</table>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<!-- VALIDAR CAMPOS -->
<script src="../js/validForm.js"></script>
<script>
	$(document).ready(function () {
		$('#miTabla').DataTable();
	});
</script>
<script src="../js/libreriaTel.js"></script>
</body>
</html>