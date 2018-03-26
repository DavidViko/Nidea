<%@page import="com.ipartek.formacion.nidea.controller.CalculadoraController"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<form action="calculadora" method="post"> <!--  en el action como se llame el controlador (servlet)--> 
	<div class="form-group">
	<label for="num1">1º N&uacute;mero</label>
		<input type="text" name="num1">
	</div>
	<div class="form-group">
		<label for="num2">2º N&uacute;mero</label>
		<input type="text" name="num2">
	</div>
	<select name="opcion">
  		<option value=<%= CalculadoraController.OP_SUMAR %>>Suma</option>
  		<option value=<%= CalculadoraController.OP_RESTAR %>>Resta</option>
  		<option value=<%= CalculadoraController.OP_MULTIPLICAR %>>Multiplicaci&oacute;n</option>
  		<option value=<%= CalculadoraController.OP_DIVIDIR %>>Divisi&oacute;n</option>
	</select>
	
	<input type="submit" value="Calcular">
</form>

<jsp:include page="/templates/footer.jsp"></jsp:include>