<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

<%
	String resultado = (String)request.getAttribute("resultado");
%>

<h1>RESULTADO = 
	<%=resultado %>
</h1>


<jsp:include page="/templates/footer.jsp"></jsp:include>