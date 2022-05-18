<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./css/tabla.css">
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
	            <table id="tabla__Cliente" >
	                <thead class="tabla__titulo">
	                    <tr>
	                        <th>ID</th>
							<th>PIEZA</th>
							<th>CATEGORIA</th>
							<th>PRECIO</th>
							<th>STOCK</th>
	                    </tr>
	                </thead>
	                <tbody class="tabla__info">
	                	<c:forEach items="${lstConsultaPiezas}" var="p">
	                    <tr id="tabla__filas" onclick="location.href='ServletGestionarPieza?accion=editar&id=${p.getIdPieza()}'">
		                    <td><c:out value="${p.getIdPieza()}"></c:out></td>
							<td><c:out value="${p.getNomPieza()}"></c:out></td>
							<td><c:out value="${p.getCategoria()}"></c:out></td>
							<td>S/. <c:out value="${p.getPrecio()}"></c:out></td>
							<td><c:out value="${p.getStock()}"></c:out></td>		
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
		<div class="card col-sm-4"  id="formServPrest" style="width: 100%">
			<div class="card-body">
				<form class="justify-content-center needs-validation"  align="center" action="Validar" novalidate>
					
					<div class="form-group pt-2">
						<label class="formuTecTit">PIEZA</label>
						<input type="text" value="${pi.getNomPieza()}"  name="txt_nomCli" class="form-control" placeholder="Nombres" required>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">CATEGORIA</label>
						<input type="text" value="${pi.getCategoria()}"  name="txt_nomCli" class="form-control" placeholder="Nombres" required>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">COSTO (S/.)</label>
						<input id="campo-numerico" type="number"  value="${pi.getPrecio()}" min="1" pattern="^[0-9]+" onpaste="return false;" onDrop="return false;" autocomplete=off
						class="form-control estinputs" placeholder="Ingreso Monto" required>
					</div>
					<div class="form-group pt-2">
						<label class="formuTecTit">STOCK</label>
						<input id="campo-numerico" type="number" value="${pi.getStock()}" class="form-control estinputs" name="ape_princ_tec" placeholder="Ingrese una cantidad" required>
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