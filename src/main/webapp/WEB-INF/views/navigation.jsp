<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">ConnectHBTU</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="${pageContext.request.contextPath}" id="navigate">HOME</a></li>
          <% if(session.getAttribute("user")!= null){
          
          out.println("<li><a href=${pageContext.request.contextPath}/account >ACCOUNT</a></li>");
          out.println("<li><a href=logout >LOG OUT</a></li>");
         
          }
          else{
          
        	  out.println("<li><a href=login >LOG IN</a></li>");
              out.println("<li><a href=register >REGISTER</a></li>");
          }
          
          %>
        </ul>
      </div>
    </div>
</nav>