<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<body bgcolor='#<c:out value="${colorcode}" />'>
 
<h1>Spring Greetings</h1>
<c:if test="${not empty greetinglist}" >
	<c:forEach items="${greetinglist}" var="greeting">		
			<br/><b>@<c:out value="${greeting.username}" /></b> says<br/>	
			on <c:out value="${greeting.greetingDate}" /><br/>	
			<c:out value="${greeting.greetingText}" /><br/>			
	</c:forEach>	
</c:if>
<c:if test="${empty greetinglist}" >
	There are no greetings yet. 
</c:if>
 
<p><a href="/simpleblog/addgreeting">Add greeting</a><br/>
<a href="/simpleblog/">Home</a><br/>
<a href="<c:url value="j_spring_security_logout" />">logout</a>
 
</body>
