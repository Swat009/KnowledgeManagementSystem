<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>
<div class="container">
<br/><br/><br/>
<a href="account">Back</a>
<section class="row new-post">
		<div class="col-md-6 col-md-offset-3">

		<header><h3>What do you have to say?</h3></header>
		<c:url var="action" value="/createquestion" ></c:url>
		<form:form action="${action}" method="post" modelAttribute="post">
			
			<div class="form-group">
			<form:input class="form-control" path="title"   placeholder="Give a title" />
			</div>
			<div class="form-group">
			<form:textarea class="form-control" path="body" rows="10" placeholder="Write your content here.."></form:textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit Question</button>

		</form:form>
		</div>
	</section>




</div>



<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>