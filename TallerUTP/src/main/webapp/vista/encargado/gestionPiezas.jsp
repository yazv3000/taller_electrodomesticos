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
					<li><button class="fa-solid fa-plus-square icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"></button></li>
	                <li><button class="fa-solid fa-pen icono" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button></li>
	                <li><button class="fa-solid fa-trash icono"></button></li>
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
							<th>ESTADO</th>
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
		<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="padding-right: 350px;">
		  <div class="modal-dialog" >
		    <div class="modal-content text-center" style="width: 800px; height: 550px">
		    <button type="button" class="btn-close btn-danger" data-bs-dismiss="modal"> cerrar</button>
		      <div class="modal-body">
		        	<!-- ===== DATOS DE LA NUEVA PIEZA ===== -->
					<form  class="formulario" action="<%=request.getContextPath()%>/ServletGestionarPieza" method="post" novalidate>
						<div class="row align-items-center pt-1">
					      	<div class="form__grupo col-11">
					      		<div class="form__titulo">
					                <p>INFORMACION DE LA PIEZA</p>
					            </div>
				            </div>
				            <div class="form__grupo col-1">
				            	<input class="btn__cerrar" type="button" data-bs-dismiss="modal" value="X">
				            </div>
				        </div>
				        <div class="form__contenedor pt-4">
				            <div class="form__grupo">
				                <input type="text" class="form__input" placeholder=" " name="txt_nombrePieza">
				                <label for="name" class="form__label">Nombre Pieza:</label>
				                <span class="form__line"></span>
				            </div>
				            <select class="form__seleccion" name="cbx_categoriaPieza">
				            	<c:forEach items="${lstCategorias}" var="cat">
					                <option class="form__opcion" value="${cat.getIdCategoria()}">${cat.getNomCategoria()}</option>
								</c:forEach>
				            </select>
				            <div class="form__grupo">
				                <input type="number" class="form__input"  placeholder=" " name="precio">
				                <label for="name" class="form__label">Precio:</label>
				                <span class="form__line"></span>
				            </div>
				            <div class="form__grupo">
				                <input type="number" class="form__input" placeholder=" " name="stock">
				                <label for="name" class="form__label">Stock:</label>
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
	    <div class="modal-content text-center" style="width: 800px; height: 550px">
	    <button type="button" class="btn-close btn-danger" data-bs-dismiss="modal"> cerrar</button>
	      <div class="modal-body">
	        	<!-- ===== DATOS DE LA PIEZA A MODIFICAR ===== -->
				<form  class="formulario" action="">
					<div class="row align-items-center pt-1">
				      	<div class="form__grupo col-11">
				      		<div class="form__titulo">
				                <p>INFORMACION DE LA PIEZA</p>
				            </div>
			            </div>
			            <div class="form__grupo col-1">
			            	<input class="btn__cerrar" type="button" data-bs-dismiss="modal" value="X">
			            </div>
			        </div>
			        <div class="form__contenedor pt-4">
			            <div class="form__grupo">
			                <input type="text" class="form__input" placeholder=" " value="${pi.getNomPieza()}" name="txt_nombrePieza">
			                <label for="name" class="form__label">Nombre Pieza:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="cbx_categoriaPieza">
				            <c:forEach items="${lstCategorias}" var="cat">
				                <option class="form__opcion" value="${cat.getIdCategoria()}"  ${pi.getIdCategoria()==cat.getIdCategoria() ? 'selected' : ''}>${cat.getNomCategoria()}</option>
							</c:forEach>
			            </select>
			            <div class="form__grupo">
			                <input type="number" class="form__input"  placeholder=" " value="${pi.getPrecio()}" name="precio">
			                <label for="name" class="form__label">Precio:</label>
			                <span class="form__line"></span>
			            </div>
			            <div class="form__grupo">
			                <input type="number" class="form__input" placeholder=" " value="${pi.getStock()}" name="stock">
			                <label for="name" class="form__label">Stock:</label>
			                <span class="form__line"></span>
			            </div>
			            <select class="form__seleccion" name="estado">
			                <option class="form__opcion" value=true  ${pi.isEstadoActivo() ? 'selected' : ''}>Activo</option>
			                <option class="form__opcion" value=false  ${!pi.isEstadoActivo() ? 'selected' : ''}>Inactivo</option>
			            </select>
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
	
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	
	 <!-- ===== JS BOOSTRAP ===== -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="js/piezas.js"></script>
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