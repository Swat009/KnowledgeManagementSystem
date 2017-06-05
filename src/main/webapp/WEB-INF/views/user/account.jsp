<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page import ="java.util.*" %>
<%@ page import ="org.greysalmon.model.*" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>
<div class="row">

<div class="col-md-12 ">
<ul class="nav nav-tabs  nav-justified">
  <li ><a href="account">Home</a></li>
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
		<header><h3>What's going on</h3></header><a class="btn btn-sucess" href="createpost">Create Post</a> <a class="btn btn-sucess" href="upload">Upload File</a><a class="btn btn-sucess" href="files">Download Files</a>
		<div class="panel panel-default">
  <div class="panel-heading">Quote of the day</div>
  <div class="panel-body">
 <p> Tell me and I forget. Teach me and I remember. Involve me and I learn.<br>
-Benjamin Franklin
Politician, Writer, Scientist</p>
<small><i><a href="https://www.brainyquote.com/quotes_of_the_day.html" target="_blank" rel="nofollow">more Quotes</a></i></small>
  
  
  </div>
</div>
		<%
		
		User u=(User)session.getAttribute("user");
		List<Followers> following = (List<Followers>) request.getAttribute("followingList");
		List<Post> p=(List<Post>)request.getAttribute("posts");
		List<Long> l=new ArrayList<Long>();
		
		for(Followers follow : following)
		{
			if(follow.getFollowerId()==u.getUserId());
			l.add(follow.getFollowedId());
			
			//out.println("Follow="+follow.getFollowedId());
			
		}
		//out.print("<h1>l="+l.size()+"</h1>");
		
		if(l.size()==0)
		{
			out.print("<h1>Please follow some users to see their posts.</h1>");
		}
		else
		{
			String v="";
			
			for(Post pc:p)
			{
				if(l.contains(pc.getUser().getUserId())|| pc.getUser().getUserId()==u.getUserId() )
				{
					v+="<article class='post' data-postid='"+pc.getId()+"'>";
					v+="<div class='panel panel-default'>";
					v+="<div class='panel-heading'>"+pc.getTitle()+"</div>";
					v+="<div class='panel-body'>";
					v+="<p>"+pc.getBody()+"</p><div class='info'>";
					v+="<div class='info'>";
					v+="Posted by "+pc.getUsername()+" on"+pc.getCreatedon()+"</div></div></div></article>";
				}
			}
			
			out.println(v);
		}
		
		
		%>
		
		<%-- <c:forEach items="${posts}" var="post">
		<article class="post" data-postid="${post.id}">
		
		<div class="panel panel-default">
		<div class="panel-heading">${post.title}</div>
		  <div class="panel-body">
		<p>${post.body}</p>
		<div class="info">
			Posted by ${post.username} on ${post.createdon}
		</div>
		</div>
		</div>
		</article>
		</c:forEach> --%>
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