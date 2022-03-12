<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>




<div class="container-fluid">
        <!-- <h1>Hello World!</h1>
        <p>Resize the browser window to see the effect.</p>
        <p>The columns will automatically stack on top of each other when the screen is less than 768px wide.</p> -->
        <div class="row" style="background-color:#f8eae2">
            
            
            
       		
                
            </div>
         
			
            <!-- <div class="col-sm-4">
                
                <div style="margin-top:20px;text-align:center;padding-left:30%">
                    <a style="color:white;text-decoration:none" href="">
                        <button class="btn-DT btn--warn"><i class="far fa-plus-square"></i> ĐĂNG TIN NGAY</button>
                    </a>

                  
                </div>

            </div> -->

        </div>

    </div>


    
    
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand fas fa-hotel" style="font-weight:bold" href="${pageContext.request.contextPath}/">Trang chủ</a>
    </div>
    <ul class="nav navbar-nav">
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/carconmpany-list">Hãng sản xuất</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/cartype-list">Dòng xe hơi</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/contract-register">Đăng ký bán xe</a></li>
       		
       		
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <c:choose>
    <c:when test="${Account_present == null}">
	    
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
        
        
        
	    </c:when>    
	    <c:otherwise>
	        
        	
        	<ul class="nav navbar-nav navbar-right">
		      <li><a href="${pageContext.request.contextPath}/userinfo"><span class="glyphicon glyphicon-user"></span> Xin chào ${Account_present.getTENTK()}</a></li>
		       
		      <c:choose>
		    
		      	<c:when test="${Account_present.getCHUCVU() eq 'Người Quản Trị'}">
		      	<li><a href="${pageContext.request.contextPath}/contract-list-admin"><span class="fas fa-user-tie"></span>${Account_present.getCHUCVU()} </a></li>
		      	</c:when> 
		      	<c:otherwise>   
		      	</c:otherwise>
		      </c:choose>
		      
		      <li><a href="http://localhost:8080/WebBanXE/sign-out"><span class="glyphicon glyphicon-log-in"></span> Thoát</a></li>
		    </ul>
	    </c:otherwise>
	</c:choose>
       
    
  </div>
</nav>

