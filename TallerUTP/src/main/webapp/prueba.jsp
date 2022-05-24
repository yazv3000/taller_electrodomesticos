<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROBANDO DAOS</title>
</head>
<body>
<%@ page import="utp.taller.dao.*"%>
<%@ page import="utp.taller.entidades.*"%>
<%@ page import="utp.taller.dto.*"%>
<%@ page import="java.util.List"%>

    <%
        DaoCliente dao = new DaoCliente();
    	Cliente micliente = new Cliente();
    	micliente.setIdPersonaCliente(23);
    	micliente.setIdUsuarioCliente("CLI-000012");
    	micliente.setNombrePrin("Papu");
    	micliente.setApePrin("Puas");
    	micliente.setTipoDocumento(2);
    	micliente.setNroDocumento("00001");
    	micliente.setTelefono("997");
    	micliente.setIdDistrito(1);
    	micliente.setDireccion("su caseta");
    	micliente.setEmail("jajaja@jejej");
    	micliente.setContrasena("Supersecreta");
    	micliente.setEstadoActivo(true);
   		//dao.insertar(micliente);
    	//dao.modificar(micliente);
    	//dao.desactivar(23);
    	List<DtoClienteConsulta> lista = dao.listarDtoClientes();

    	
    %>
    
    <h1><%=lista.size()%></h1>
    <br />
    <table border='1'>
        <%
        for(DtoClienteConsulta t: lista)  {
        %>
        <tr>
            <td><%=t.getIdPersonaCliente()%></td>
            <td><%=t.getIdUsuarioCliente()%></td>
            <td><%=t.getNombreCompleto()%></td>
            <td><%=t.getDistrito()%></td>
			<td><%=t.getDireccion()%></td>
			<td><%=t.getEmail()%></td>
			<td><%=t.isEstadoActivo()%></td>
        </tr>
        <%
            }
        %>
    </table> 

</body>
</html>