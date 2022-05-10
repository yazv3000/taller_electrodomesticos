<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/mant.css">
<link rel="icon" type="image/png" href="../img/ico.png">
<title>SERVICIOS - TALLER UTP</title>
</head> 
<body >
	<div class="d-flex justify-content-center margen">
		<div class="card col-sm-4" id="formServPrest">
			<div class="card-body">
				<form class="justify-content-center needs-validation" align="center" action="Validar" novalidate>
					<div class="form-group pt-2">
						<label class="formuTecTit">FECHA</label>
						<input type="date" name="fech_serv" class="form-control estinputs" placeholder="Fecha" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">HORA</label>
						<input type="time" class="form-control estinputs" name="ape_princ_tec" placeholder="Hora" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">DESCRIPCION</label>
						<textarea name="calificacion" class="form-control estinputs" placeholder="Descripción" required></textarea>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="row"> 
						<div class="form-group pt-2 col-6">
							<label class="formuTecTit">PIEZA USADA</label>
						</div>
						<div class="form-group pt-2 col-6">
							<label class="formuTecTit">CANTIDAD</label>
						</div>
					</div>
					<div class="form-group pt-1">
						<div style="float:left; width: 190px;">
						<select name="example" class="form-control estinputs" required>
						  <option value="A">A</option>
						  <option value="B">B</option>
						  <option value="-">Other</option>
						</select>
						<div class="valid-feedback">Campos Completos</div>
                 		<div class="invalid-feedback">Campos Incompletos</div>
						</div>
						<div style="float:right; width: 190px;">
						<input id="cant" type="number" min="1" pattern="^[0-9]+" onpaste="return false;" onDrop="return false;" autocomplete=off
						class="form-control estinputs" required>	
						<div class="valid-feedback">Campos Completos</div>
                 		  <div class="invalid-feedback">Campos Incompletos</div>					
						</div>
						<div style="clear:both"></div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">MONTO (S/.)</label>
						<input id="campo-numerico" type="number" min="1" pattern="^[0-9]+" onpaste="return false;" onDrop="return false;" autocomplete=off
						class="form-control estinputs" required>
						<div class="valid-feedback">Campos Completos</div>
                 		<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group text-center pt-2">
						<button class="btn btn-warning" type="submit"><b>Agregar</b></button>
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-8" id="formServPrest">
			<table id="miTabla" class="table table-dark table-hover text-center estinputs">
				<thead> 
					<tr>
						<th>ID</th>
						<th>FECHA</th>
						<th>HORA</th>
						<th>PIEZA</th>
						<th>CANTIDAD</th>
						<th>MONTO (S/.)</th>
					</tr>
				</thead>
				<tbody class="table-dark">
				<tr>
					<th>1</th>
					<th>16/05/2022</th>
					<th>12:23</th>
					<th>Placa</th>
					<th>2</th>
					<th>23</th>
				</tr>
				<tr>
					<th>1</th>
					<th>16/05/2022</th>
					<th>12:23</th>
					<th>Placa</th>
					<th>2</th>
					<th>23</th>
				</tr>
				<tr>
					<th>1</th>
					<th>16/05/2022</th>
					<th>12:23</th>
					<th>Placa</th>
					<th>2</th>
					<th>11</th>
				</tr>					
				</tbody>
			</table>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<!-- VALIDACION NUMERO -->
<script src="../js/ValidacionMonto.js"></script>
<!-- LIBRERIA TABLA -->
<script>
	$(document).ready(function () {
		$('#miTabla').DataTable();
	});
</script>
<!-- VALIDAR CAMPOS -->
	<script src="../js/validForm.js"></script>
</body>
</html>