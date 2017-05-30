<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>
<%@ page import ="java.util.*" %>
<%@ page import ="org.greysalmon.model.*" %>

<br/>
<br/><br/>
<div class="row">



</div>
<br/>
<a href="account">Back</a>
<div class="row">


<div class="col-md-1">
  </div>
  
  <div class="col-md-10">
  <div class="panel panel-default">
  <div class="panel-heading">USERS</div>
  <div class="panel-body">
  
<% 

User admin=(User)session.getAttribute("user");
String res="";
List<User> users=(List<User>) request.getAttribute("userList");
  for(User user:users){
	
	if(user.getUserId()!=admin.getUserId()){
res+="<div id="+user.getUserId()+" class='media'>";
 res+="<div class='media-left media-top'>";
  res+="<img src='https://www.w3schools.com/bootstrap/img_avatar1.png' class='img-circle' width=100></div>";
  
  res+="<div class='media-body'>";
  res+="<h4 class='media-heading'>"+user.getName()+"</h4>";
   res+="<p>Roll no.="+user.getRollno()+"</p><p><button class='follow btn btn-primary' data-status='"+user.getVerified()+"' data-id='"+user.getUserId()+"' >"+(user.getVerified()==0?"Approve":"Block")+"</button></p></div></div>";
	}
    
}

  
  out.println(res);
%>
  
  
  
  </div>
</div>
  
  </div>
  
  <div class="col-md-1">
  </div>
  
 


<script>


$(document).ready(function(){
    
	  $('.follow').click(function(){

	      id=$(this).data('id');      
	      status=$(this).data('status');
	      console.log("value="+id);
	       $.ajax({
	         type: 'POST',
	         url: "allow",
	         data: {id:id},   
	         
	         
	         success: function(data){
	            
	        	 location.reload();
	        // console.log(data);
	          
	         }
	      });

	      
	        
	    
	  });



	  });
	


</script>
</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>