<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>
<h1>Account</h1>

<a href="createpost">Create new post</a>




<section  class="row posts">

		<div class="col-md-6 col-md-offset-3">

		<header><h3>What's going on</h3></header>

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
		


	</section>

</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>