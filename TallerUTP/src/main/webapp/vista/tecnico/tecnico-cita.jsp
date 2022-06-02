<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${context}/css/tecnico-citas.css">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <title>Document</title>
</head>

<body>
    <h2 class="titulo-1">Citas <span>Actuales</span></h2>
    <div class="tabla__contenido">
        <h3>Tabla de Citas</h3>
        <div class="tabla__overflow">
            <table id="tabla-citas">
                <thead class="tabla__titulo">
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Direccion</th>
                        <th>Telefono</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Servicio</th>
                        <th>Electrodomestico</th>
                        <th>Estado Atencion</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody class="tabla__info">
                    <tr id="tabla__fila">
                        <td class="tabla__columna">10</td>
                        <td class="tabla__columna">Juan Perez</td>
                        <td class="tabla__columna">Cerro colorado</td>
                        <td class="tabla__columna">990540845</td>
                        <td class="tabla__columna">12-10-2022</td>
                        <td class="tabla__columna">16:00</td>
                        <td class="tabla__columna">Reparacion</td>
                        <td class="tabla__columna">Refrigeradora</td>
                        <td class="tabla__columna">Pendiente</td>
                        <td class="tabla__columna"><a class="informacion" href=""><i class="fa-solid fa-file-pen icon"
                                    target="marco-atencion"></i></a></td>
                    </tr>
                    <tr id="tabla__fila">
                        <td class="tabla__columna">11</td>
                        <td class="tabla__columna">Juan Perez</td>
                        <td class="tabla__columna">Cerro colorado</td>
                        <td class="tabla__columna">990540845</td>
                        <td class="tabla__columna">12-10-2022</td>
                        <td class="tabla__columna">16:00</td>
                        <td class="tabla__columna">Reparacion</td>
                        <td class="tabla__columna">Refrigeradora</td>
                        <td class="tabla__columna">Concluido</td>
                        <td class="tabla__columna"><a class="informacion" href=""><i class="fa-solid fa-file-pen icon"
                                    target="marco-atencion"></i></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <h2 class="titulo-1">Detalles de la <span>Cita Seleccionada</span></h2>
    <div class="contenedor-iframe">
        <iframe src="" class="marco-atencion" name="marco-atencion" src="" frameborder="0"></iframe>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#tabla-citas').DataTable({
                "language": {
                    "sSearch": "Buscar",
                    "oPaginate": {
                        "sPrevious": "Anterior",
                        "sNext": "Siguiente"
                    }
                }
            });
        });
    </script>
</body>

</html>