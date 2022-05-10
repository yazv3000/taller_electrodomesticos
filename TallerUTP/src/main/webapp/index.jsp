<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/menu.css">
    <script src="https://kit.fontawesome.com/c2a0f18374.js" crossorigin="anonymous"></script>
    
    <title>Document</title>
</head>

<body>

<%@ page import="utp.taller.dao.*"%>
<%@ page import="utp.taller.entidades.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>

<%
        DaoCliente dao = new DaoCliente();
    	//dao.insertar(new Cliente(300, "Nuevo tec", "Ni", "co", "72458424", "Su casita", 90, "tecnico@tec.com", "****"));
    	//dao.modificar(new Cliente(11, "old tec", "Ni", "co", "90458555", "Neuva casita", 100, "tec@tecnico.com", "stop"));
    	//dao.eliminar(11);
    	List<Cliente> lista = dao.listar();
    	Set<String> telefonos_cliente1 = dao.telefonos_cliente(1);
    	
%>

    <div class="contenedor">
        <!-- ====== MENU====== -->
        <div class="menu">
            <nav class="navi">
                <div>
                     <!-- ===== LOGO ===== -->
                     <div class="logo">
                        <i class="fa-solid fa-bars  logo__icono"></i>
                        <img src="../img/Logo.png" alt="">
                        <h2>U <span>T</span> P</h2>
                    </div>
                    <!-- ===== LINK ===== -->
                    <div class="nav__lista">
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-user nav__icono"></i>
                            <span class="nav__nombre">Clientes</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-screwdriver-wrench nav__icono"></i>
                            <span class="nav__nombre">Tecnicos</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fas fa-calendar-check nav__icono"></i>
                            <span class="nav__nombre">Citas</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-calendar-days nav__icono"></i>
                            <span class="nav__nombre">Horarios</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-bag-shopping nav__icono"></i>
                            <span class="nav__nombre">Accesorios</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-arrow-trend-up nav__icono"></i>
                            <span class="nav__nombre">Reportes</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-gear nav__icono"></i>
                            <span class="nav__nombre">Configuraciones</span>
                        </a>
                        <a href="#" class="nav__link">
                            <i class="fa-solid fa-arrow-right-from-bracket nav__icono"></i>
                            <span class="nav__nombre">Salir</span>
                        </a>
                        
                    </div>
                </div>
            </nav>
        </div>

        <!-- ===== CONTENIDO ===== -->
        <div class="asunto">
            <div class="barra">
                <input class="buscar" type="text" placeholder="Buscar">
                <span class="usuario__img"></span>
            </div>

            <div class="tabla">
                <div class="tabla__tools">
                    <ul>
                        <li><i class="fa-solid fa-pen icono"></i></li>
                        <li><i class="fa-solid fa-trash icono"></i></li>
                    </ul>
                    <input class="tabla_buscar" type="text" placeholder="Filtrar">
                </div>
                <table class="tabla__contenido">
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
                    <tbody class="tabla__info" style="color:white;">
                    <%
			        	for(Cliente t: lista)  {
			        %>
                        <tr>
                            <td><%=t.getIdCliente()%></td>
				            <td><%=t.getNombre()%></td>
							<td><%=t.getApePrin()%></td>
							<td><%=t.getApeSec()%></td>
							<td><%=t.getNro_doc()%></td>
							<td><%=t.getDireccion()%></td>
							<td><%=t.getEmail()%></td>
                        </tr>
                                <%
          				  }
     			   %>
                    </tbody>
                </table>
                <div class="tabla__especificacion">
                    <!-- FALTA COMPLETAR -->
                </div>
            </div>
        </div>

    </div>
    <!-- ===== JAVASCRIPT ===== -->

    <script src="./js/menu.js"></script>

</body>

</html>