<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<form action="login" method="post">
	<div>
		<label for="usuario">Usuario</label>
		<input type="text" name="usuario" value="<%=mesa.getUsuario()%>" required>
	</div>
	<div>
		<label for="password">Contraseña</label>
		<input type="text" name="password" value="<%=mesa.getPassword()%>">
	</div>
	
	<input class="btn btn-default" type="submit" value="CALCULAR PRECIO">
</form>