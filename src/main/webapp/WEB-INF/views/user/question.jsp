<%@ page import ="java.util.*" %>
<%@ page import ="org.greysalmon.model.*" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>

<a href="${pageContext.request.contextPath}/account">Back</a>
<a href="${pageContext.request.contextPath}/askquestion">Ask New Question</a>


<div class="row">

<div class="col-md-1 ">
</div>

<div class="col-md-10 ">
<a href="question/${question.qid}" style="text-decoration:none;color:black;">
		<article class="question" data-postid="${question.qid}">
		<h2>${question.title}</h2>	
		<p>${question.body}</p>
		<div class="info">
			Asked by ${question.username} on ${question.createdon}
		</div>
		</article>
	   </a>
<br>
<h2>Answers</h2>
<%
	
	Questions q=(Questions)request.getAttribute("question");
	List<Answers> a=q.getAnswers();
	
	for(Answers ans:a)
	{
		out.println("<div class='panel panel-default'><div class='panel-body'><p>"+ans.getBody()+"</p></div>");
		
		User u=(User)ans.getUser();
		out.println("<div class='panel-footer'>Answer by "+u.getName()+"</div></div>");
		
	}


%>

<h2>Give answer</h2>
<c:url var="action" value="/createanswer" ></c:url>
		<form:form action="${action}" method="post" modelAttribute="answer">
			
			
			<div class="form-group">
			<form:textarea class="form-control"  path="body" rows="10" placeholder="Write your Answer here.."></form:textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit Answer</button>

		</form:form>
</div>
<div class="col-md-1 ">
</div>




</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>