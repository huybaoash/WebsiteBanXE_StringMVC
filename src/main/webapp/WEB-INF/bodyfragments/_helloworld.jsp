<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<h2> ${ helloworld.message }</h2>
<h4> Server datetime is :  ${ helloworld.dateTime}</h4>
<p><b>Account List:</b>${helloworld.dsTaiKhoan}<p>

	<ol>
		<c:forEach var="acc" items="${helloworld.dsTaiKhoan}">
		
			<li>${acc.getTENTK()}</li>
			
		</c:forEach>
	</ol>
<form action = "helloworld.htm" method="post">
  <label for="fname">Search Account by Id:</label><br>
  <input type="text" id="search_account" name="search_account"><br>
  <input type="submit" value = "Submit">
</form>