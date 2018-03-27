<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<%
	// recoger atributo del controlador, si es que existe
	Mesa mesa = (Mesa)request.getAttribute("mesa"); //hay que castear porque devuelve un objeto indefinido
	ArrayList<Material> materiales = (ArrayList<Material>)request.getAttribute("materiales");
%>

<p>Precio: <%=mesa.getPrecio() %> &euro;</p>

<form action="generar-mesa" method="post">
	<div>
		<label for="patas">N&uacute;mero de patas</label>
		<input type="text" name="patas" value="<%=mesa.getNumeroPatas()%>" required>
	</div>
	<div>
		<label for="dimension">Dimensi&oacute;n</label>
		<input type="text" name="dimension" value="<%=mesa.getDimension()%>">
	</div>
	<div>
		<label for="color">Color personalizado</label>
		<input type="checkbox" id = "custom" name="custom" onclick=showColor() <%=(mesa.isCustom())?"checked":"" %>>
		<input type="color" id = "color" name="color"> 
<!-- 		<input type="text" name="color" class="jscolor"> -->
	</div>
	<div>
		<!-- forma tradicional -->
		<!-- <label for="material">Tipo de material</label>
		<select name="material">    
			<option value="1" selected="selected">Madera</option>
			<option value="2">Acero</option>
			<option value="3">Aluminio</option>
			<option value="4">Pl&aacute;stico</option> 
   		</select> -->
   		
   		<label for="material">Selecciona Material:</label>
		<select name="material">
		
		<% 	
			Material m = null;
			for ( int i=0; i < materiales.size(); i++ ) { //  el lenght en array es size en arraylist
				m = materiales.get(i);
		%> 
			<option value="<%= materiales.get(i).getId()%>" 
			        <%=(mesa.getMaterial().getId() == m.getId())?"selected":""%>>
				<%= materiales.get(i).getNombre()%> - <%=m.getPrecio()%>&euro;
			</option>
		<% } %>
		</select>
	</div>
	
	<input class="btn btn-default" type="submit" value="CALCULAR PRECIO">
</form>



<jsp:include page="templates/footer.jsp"></jsp:include>