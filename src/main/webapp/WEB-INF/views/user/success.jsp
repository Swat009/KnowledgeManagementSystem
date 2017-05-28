<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>

<section  class="row posts">

		<div class="col-md-1">
		</div>
		<div class="col-md-10 ">
		<%
		
			String mess=(String)request.getAttribute("message");
		
			out.println("<h2>"+mess+"</h2>");
			
		
		
		%>
		</div>
		
		<a href="${pageContext.request.contextPath}/account">Back</a>
		<div class="col-md-1">
		</div>
		


</section>

</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>