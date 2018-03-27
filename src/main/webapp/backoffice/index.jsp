<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<%
	// recoger atributo del controlador, si es que existe
	Mesa mesa = (Mesa)request.getAttribute("mesa"); //hay que castear porque devuelve un objeto indefinido
	ArrayList<Material> materiales = (ArrayList<Material>)request.getAttribute("materiales");
%>

<h1>BACKOFFICE</h1>
		
 
	

		
<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
        </tfoot>
        <tbody>
            <% 	
				for (int i=0; i < materiales.size(); i++ ) {
			%>
			<tr>
				<th><%= materiales.get(i).getId() %></th>
				<th><%= materiales.get(i).getNombre() %></th>
            	<th><%= materiales.get(i).getPrecio() %> &euro;</th>
            </tr>
			<% ;} %>
			
        </tbody>
        
    </table>
