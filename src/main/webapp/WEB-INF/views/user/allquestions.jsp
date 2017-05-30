<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>

<a href="account">Back</a>


<section  class="row posts">

		<div class="col-md-1">
		</div>
		<div class="col-md-10 ">
		
		<h3><a href="askquestion"><span class="glyphicon glyphicon-search"></span>&nbsp; Ask a Question</a></h3>
		
		<header><h3>All questions </h3></header>
		<c:forEach items="${questions}" var="question">
		
		<a href="question/${question.qid}" style="text-decoration:none;color:black;">
		<article class="question" data-postid="${question.qid}">
		<div class="panel panel-default">
  <div class="panel-heading">${question.title}</div>
		
		<div class="panel-body"><p>${question.body}</p>
		<div class="info">
			Asked by ${question.username} on ${question.createdon}
		</div>
		</div>
		</div>
		</article>
		</a>
		</c:forEach>
		</div>
		<div class="col-md-1">
		</div>
		
		


</section>

</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>