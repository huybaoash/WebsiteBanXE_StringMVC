<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

   <c:choose>
    <c:when test="${lstHD.size() != 0}">
    <div class="container tt">
		<title>Danh sách tài khoản</title>
		<h1>DS giao dịch hợp đồng</h1>
		
		<h3>Tất cả</h3>
	        <c:forEach var = "i" begin = "0" end = "${lstHD.size()-1}">
  			<div class="row">
				
                <div class="panel panel-default" style="width: 900px" >
                    <div class="panel panel-heading">
                        ${lstHD.get(i).getTENXE()}
                    </div>
                    <div class="panel-body">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    	<p>
                            <img src="${lstHD.get(i).getHINHANH()}" style="width: 120;height:120" />
                        </p> 
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-12">
                    	<p>
                            <strong>Hãng sản xuất: </strong>${lstHD.get(i).getTENHSX()}
                        </p>
                        <p>
                            <strong>Loại xe: </strong>${lstHD.get(i).getTENLOAIXE()}
                        </p>
                        <p>
                            <strong>Giá hợp đồng: </strong>${String.format("%,.0f",lstHD.get(i).getGIA())}
                        </p>
                    </div>    
                        
                    </div>
                    
                </div>
            
            </div>
			</c:forEach>
  		</div>	
	    </c:when>    
	    <c:otherwise>
	        Hông có
	    </c:otherwise>
	</c:choose>
  			
  			
        	