<%@ include file="/WEB-INF/views/header.jsp" %>
<body>
<jsp:include page="/WEB-INF/views/navigation.jsp"></jsp:include>

<br/>
<br/><br/>
<div class="row">

	<c:if test="${!empty posts}" >
	<table>
	
	<tr>
	<th>Title</th>
	<th>Author</th>
	<th>Body</th>
	</tr>
	
	<c:forEach items="${posts}" var="post"> 
	<tr>
	<td><c:out value="${post.title}" /></td>
	<td><c:out value="${post.user.name}" /></td>
	<td><c:out value="${post.body}" /></td>
	</tr>
	</c:forEach>
	</table>
    </c:if>
</div>

</body>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</html>