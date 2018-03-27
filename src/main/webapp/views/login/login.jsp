<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<div class="form_main">
	<form class="form" action="login" method="post">
		<div class = "form-label-group">
			<label for="usuario" class="sr-only">Usuario</label>
			<input type="text" name="usuario" class="form-control" placeholder="Usuario" required autofocus>
		</div>
		<div class = "form-label-group">
			<label for="password" class="sr-only">Contraseña</label>
			<input type="password" name="password" class="form-control" placeholder="Contraseña" required>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Registrar</button>
	</form>
</div>