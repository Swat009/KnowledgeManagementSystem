<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page import ="java.util.*" %>
<%@ page import ="org.greysalmon.model.*" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>


<a href="${pageContext.request.contextPath}/account">Back</a>
<div class="container">

<div class="row">

<div class="col-lg-4">

<img src='https://www.w3schools.com/bootstrap/img_avatar1.png' class='img-circle' width="304">

</div>

<div class="col-lg-4">

<%


User main_user=(User)session.getAttribute("user");
User user=(User)request.getAttribute("details");
String s="";

	 s+="<form>";
	
	 s+="<div class='form-group'>";
	 s+="<label for='first_name'>Roll No.</label>";
	 s+="<input type='text' name='rollno' class='form-control' value='"+user.getRollno()+"' id='first_name'>";
	 s+="</div>";
     s+="<label for='first_name'>Name</label>";
     s+="<input type='text' name='name' class='form-control' value='"+user.getName()+"' id='first_name'>";
 	 s+="</div>";
	 s+="</form>";


	out.print(s);


%>
</div>
<div class="col-lg-4">

</div>

</div>
</div>


<div class="row">

<div class="col-lg-1">
</div>
<div class="col-lg-5">


<h1>Posts</h1>
<%

List<Post> posts=user.getPosts();

String s2="";
for(Post p:posts)
{
	s2+="<h2>"+p.getTitle()+"</h2>";
	s2+="<p>"+p.getBody()+"</p>";
}

out.println(s2);


%>

<c:forEach items="${posts}" var="post">
		<article class="post" data-postid="${post.id}">
		<h2>${post.title}</h2>	
		<p>${post.body}</p>
		<div class="info">
			Posted by ${post.username} on ${post.createdon}
		</div>
		<div class="interaction">
		<a href="#" class="like" >Like</a>|
		<a href="#" class="like" >Dislike</a>|
		</div>
		</article>
</c:forEach>

</div>
<div class="col-lg-5">

<h1>Questions</h1>
<%



List<Questions> questions=user.getQuestions();

String s3="";
for(Questions q:questions)
{
	s3+="<h2>"+q.getTitle()+"</h2>";
	s3+="<p>"+q.getBody()+"</p>";
}

out.println(s3);



%>
</div>
<div class="col-lg-1">
</div>



</div>
</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>