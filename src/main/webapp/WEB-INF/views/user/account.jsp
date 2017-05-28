<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>
<div class="row">

<div class="col-md-12 ">
<ul class="nav nav-tabs  nav-justified">
  <li ><a href="createpost">Create New Post</a></li>
  <li ><a href="allquestions">Questions</a></li>
  
  <li><a href="details/${user.userId}">My Account</a></li>
  <li><a href="following">Following</a></li>
  <li><a href="list">Follow Users</a></li>
</ul>

</div>

</div>

<section  class="row posts">

		<div class="col-md-1">
		</div>
		<div class="col-md-10 ">
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
		<div class="col-md-1">
		</div>
		


</section>
<script type="text/javascript" src="assets/js/jquery.gritter.js"></script>
<script>



	 $.gritter.add({
	      title: "Welcome ! ${user.name}",
	      position: 'top-left',
	      time:2500
	      
	    });
	




</script>
</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>