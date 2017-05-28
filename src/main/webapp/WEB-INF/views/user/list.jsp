<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page import ="java.util.*" %>
<%@ page import ="org.greysalmon.model.*" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>

<br/><br/>

<div class="row">

<%

User u=(User)session.getAttribute("user");
List<Followers> following = (List<Followers>) request.getAttribute("followingList");

List<User> users=(List<User>) request.getAttribute("userList");
List<Long> l=new ArrayList<Long>();



for(Followers follow : following)
{
	if(follow.getFollowerId()==u.getUserId());
	l.add(follow.getFollowedId());
	
}



String res="";

	
for(User user:users){
	
	if(!l.contains(user.getUserId()) && user.getUserId()!=u.getUserId()){
res+="<div id="+user.getUserId()+" class='media'>";
 res+="<div class='media-left media-top'>";
  res+="<img src='https://www.w3schools.com/bootstrap/img_avatar1.png' class='img-circle' width=100></div>";
  
  res+="<div class='media-body'>";
  res+="<h4 class='media-heading'>"+user.getName()+"</h4>";
   res+="<p>Roll no.="+user.getRollno()+"</p><p><button class='follow btn btn-primary' data-id='"+user.getUserId()+"' >Follow</button></p></div></div>";
   
	}
   
   
}
 




%>

<a href="${pageContext.request.contextPath}/account">Back</a>
<div class="col-md-6 col-md-offset-3">
<h2>Active users present on the platform</h2>
<%

out.println(res);


%>

</div>
	
	
</div>

<script type="text/javascript">
  $(document).ready(function(){
    
  $('.follow').click(function(){

      id=$(this).data('id');
      console.log("value="+id);
       $.ajax({
         type: 'POST',
         url: "follow",
         data: {id:id},   
         success: function(data){
            
          $('#'+id).hide();
          
         }
      });

      
        
    
  });



  });
  </script>

</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>