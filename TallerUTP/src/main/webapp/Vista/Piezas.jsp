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
<title>PIEZAS - TALLER UTP</title>
</head> 
<body id="body">
<!-- IMPORTANDO LAS CLASES -->
<%@ page import="utp.taller.dao.*" %>
<%@ page import="utp.taller.entidades.*" %>
<%@ page import="java.util.List" %>
	<div class="d-flex justify-content-center margen">
		<div class="card col-sm-4" id="formServPrest">
			<div class="card-body">
				<form class="justify-content-center needs-validation" align="center" action="Validar" novalidate>
					<div class="form-group pt-2">
						<label class="formuTecTit">PIEZA</label>
						<input type="text" name="fech_serv" class="form-control estinputs" placeholder="Pieza" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">STOCK</label>
						<input id="campo-numerico" type="number" class="form-control estinputs" name="ape_princ_tec" placeholder="Ingrese una cantidad" required>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">MARCA</label>
						<select name="example" class="form-control estinputs" required>
						  <option value="A">A</option>
						  <option value="B">B</option>
						  <option value="-">Other</option>
						</select>
						<div class="valid-feedback">Campos Completos</div>
						<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">COSTO (S/.)</label>
						<input id="campo-numerico" type="number" min="1" pattern="^[0-9]+" onpaste="return false;" onDrop="return false;" autocomplete=off
						class="form-control estinputs" placeholder="Ingreso Monto" required>
						<div class="valid-feedback">Campos Completos</div>
                 		<div class="invalid-feedback">Campos Incompletos</div>
					</div>
					<div class="form-group text-center pt-2">
						<button class="btn btn-dark" type="submit"><b>Agregar</b></button>
					</div>
				</form>
			</div>
		</div>
		<%
			DaoPieza daopi = new DaoPieza();
			List<Pieza> lst = daopi.listar();
		%>
		<div class="col-sm-8 paddingsty" id="formServPrest">
			<table id="miTabla" class="table table-dark table-hover text-center">
				<thead> 
					<tr>
						<th>ID</th>
						<th>PIEZA</th>
						<th>STOCK</th>
						<th>CATEGORIA</th>
						<th>PRECIO (S/.)</th>
					</tr>
				</thead>
				<%
					for (Pieza pi : lst){
				%>
				<tbody class="table-dark">
				<tr>
					<th><%= pi.getIdPieza()%></th>
					<th><%= pi.getNomPieza()%></th>
					<th><%= pi.getStock() %></th>
					<th><%= pi.getCategoria() %></th>
					<th><%= pi.getPrecio() %></th>
				</tr>
				<%
					}
				%>			
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