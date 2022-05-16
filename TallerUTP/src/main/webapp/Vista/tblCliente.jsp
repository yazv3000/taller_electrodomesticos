<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/tabla.css">
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
	  Launch static backdrop modal
	</button></li>
	            </ul>
	            <input class="tabla_buscar" type="text" placeholder="Filtrar">
	        </div>
	        <div class="tabla__contenido">
	            <table id="tabla__Cliente" >
	                <thead class="tabla__titulo">
	                    <tr>
	                        <th>Id</th>
	                        <th>Nombre</th>
	                        <th>Ape. Paterno</th>
	                        <th>Ape. Materno</th>
	                        <th>DNI</th>
	                        <th>Direccion</th>
	                        <th>Correo</th>
	                    </tr>
	                </thead>
	                <tbody class="tabla__info">
	                    <tr>
	                        <td>CLI-00001</td>
	                        <td>Angela</td>
	                        <td>Zeballos</td>
	                        <td>Arce</td>
	                        <td>78458805</td>
	                        <td>Buenos Aires de Cayma</td>
	                        <td>1666629@utp.edu.pe</td>
	                    </tr>
	                </tbody>
	            </table>
	        </div>
	        <div class="tabla__especificacion">
	
	        </div>
	    </div>
	</div>
	
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
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Understood</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- ===== FINAL MODAL ===== -->
	
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	
	 <!-- ===== JS BOOSTRAP ===== -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	
    <script>
        $(document).ready(function () {
            $('#tabla__Cliente').DataTable({
                // responsive: true
            });
        });
    </script>

</body>

</html>