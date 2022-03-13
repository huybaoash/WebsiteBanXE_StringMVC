<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
    .menu-list {
        font-size: 18px;
    }
    
    .menu-item{
        font-size:18px;
        padding-left:10px;
        margin-right:3px;
        background-color: none;
            border: 1px solid rgba(0, 0, 0, 0.2);
            padding: 5px 5px 0px 5px;
            color: black;
            margin-bottom: 5px;
            text-align: left;
            border-radius: 4px;
           
            box-shadow: 0px 2px 0px 2px #f3f3f3;
        
    }
    
    #menu {
        margin-left: 0;
        margin-right: 0;
    }
    th {
        background-color: #a0d1f6;
    }
    tr:hover {
        background-color: #eeeeee;
    }
</style>

<c:choose>
	    
	<c:when test="${Account_present.getCHUCVU() eq 'Người Quản Trị'}">
	<div class="container tt">
		 <h2>Chi Tiết</h2>

		<div>
		    <h4>Hãng sản xuất</h4>
		    <hr />
		    <dl class="dl-horizontal">
		        <dt>
		        	<label>Tên hãng</label>
		            
		        </dt>
		
		        <dd>
		            ${hsx.getTENHSX()}
		        </dd>
		        <hr />
		        <dt>
		            <label>Hình ảnh</label>
		        </dt>
		
		        <dd>
		            ${hsx.getHINHANH()}
		        </dd>
		        <hr />
		        <dt>
		            <label>Trạng thái</label>
		        </dt>
		
		        <dd>
		            ${hsx.getTRANGTHAI()}
		        </dd>
		        <hr />
		    </dl>
		</div>
		<p>
			<a href=""> Sửa </a>
		  	<a href="${pageContext.request.contextPath}/carconmpany-list-admin" class="btn btn-primary btn-xs"> Trở lại danh sách </a>   
		</p>
		
	</div>
		
	</c:when> 
	<c:otherwise>   
		Hông có
	</c:otherwise>
</c:choose>