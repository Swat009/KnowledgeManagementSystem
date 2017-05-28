<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>
<div class="row">

<div class="col-md-12 ">
<ul class="nav nav-tabs  nav-justified">
  <li ><a href="createpost">Create Post</a></li>
  <li ><a href="allquestions">All Questions</a></li>
  <li><a href="userposts">My Posts</a></li>
  <li><a href="details/${user.userId}">My Account</a></li>
  <li><a href="following">Following</a></li>
  <li><a href="list">Follow Users</a></li>
</ul>

</div>



</div>
<br/>
<div class="row">


<div class="col-md-1">
  </div>
  
  <div class="col-md-4">
  <div class="panel panel-default">
  <div class="panel-heading">USERS</div>
  <div class="panel-body">Panel Content</div>
</div>
  
  </div>
  
  <div class="col-md-1">
  </div>
  
  <div class="col-md-4">
  
  <div class="panel panel-default">
  <div class="panel-heading">GIVE POINTS</div>
  <div class="panel-body">Panel Content</div>
  
  </div>
  
</div>

<script type="text/javascript" src="assets/js/jquery.gritter.js"></script>
<script>



	


</script>
</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>