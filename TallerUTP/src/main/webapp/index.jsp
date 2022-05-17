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
<a href="<%=request.getContextPath()%>/ServletGestionarTecnico?accion=listar">
	Listar tecnicos
</a><br/>
<a href="<%=request.getContextPath()%>/ServletGestionarCliente?accion=listar">
	Listar cliente
</a><br/>
<a href="<%=request.getContextPath()%>/ServletGestionarPieza?accion=listar">
	Listar pieza
</a><br/>

<div class="panel" style="color:blue;">
  <a href="http://www.google.com" data-parent="#panel" data-toggle="collapse" data-target="#aa">Collapse</a>
  <div id="aa" class="collapse in">aaaaaaaaaaaaaaaaaaaggggggggg hhhhhhhhhh iii ii jjjjjjj kkkkkkk lllllllllll lllllllll mmmmmm mmmm ooooop</div>
</div>

    <!-- ===== JAVASCRIPT ===== -->

    <script src="./js/menu.js"></script>

</body>

</html>