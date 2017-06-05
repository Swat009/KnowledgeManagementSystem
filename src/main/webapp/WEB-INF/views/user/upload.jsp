<%@ include file="/WEB-INF/views/header.jsp" %>
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

<h2>File Upload</h2>
<form action="upload" method="post" enctype="multipart/form-data">
 <div class="form-group">
    <label for="details">Details</label>
    <input type="text" placeholder="Enter one line description of the file" class="form-control" id="details">
  </div>
<label>File</label>
<input type="file" name="myfile" size="50" />
<br/>
<input type="submit" class="btn btn-primary" value="upload" />
</form>
</div>
<div class="col-md-1">
		</div>
</body>
</html>