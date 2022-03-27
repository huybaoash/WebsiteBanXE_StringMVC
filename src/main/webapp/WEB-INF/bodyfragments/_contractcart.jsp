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
	    
	<c:when test="${Account_present != null}">
	<div class="container tt">	 
	
	
		
		<table class="table">
		    <tr style ="border:0.5px solid grey">
		        <th style="width:10%; text-align:left;border:0.5px solid grey"> <label>Mã hợp đồng</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Tài khoản bán</label></th>
		        <th style="width:5%; text-align:left;border:0.5px solid grey"><label>Mã xe</label></th>
		        <th style="width:20%; text-align:left;border:0.5px solid grey"><label>Tên xe</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label></label>Hình ảnh</th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Ngày lập</label></th>
		        <th style="width:10%; text-align:left;border:0.5px solid grey"><label>Địa điểm</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Giá</label></th>
		        <th style="text-align:left;border:0.5px solid grey"><label>Tác vụ</label></th>
		    </tr>
			<c:forEach var = "hopdong"  items = "${lstHD}">
		    
		        <tr style ="border:0.5px solid grey">
		            <td style ="border:0.5px solid grey">${hopdong.getMAHD()}</td>
		            <td style ="border:0.5px solid grey"><a href="${pageContext.request.contextPath}/otheruserinfo?&MATK= ${hopdong.getMATK()}">${hopdong.getTENTK()}</a></td>
		            <td style ="border:0.5px solid grey">${hopdong.getMAXE()}</td>
		            <td style ="border:0.5px solid grey"><a href="${pageContext.request.contextPath}/contract-details?&MAHD=${hopdong.getMAHD()}">${hopdong.getTENXE()}</a></td>
		            <td style ="border:0.5px solid grey"><image src = "${hopdong.getHINHANH()}" style = "width:120px;height:120px" /></td>
		            <td style ="border:0.5px solid grey">${hopdong.getNGAYLAP()}</td>
		            <td style ="border:0.5px solid grey">${hopdong.getDIADIEM()}</td>
		            <td style ="border:0.5px solid grey">${String.format("%,.0f",hopdong.getGIA())}</td>
		            <td style ="border:0.5px solid grey"><a href = "${pageContext.request.contextPath}/contract-cart-cancel?&MAHD=${hopdong.getMAHD()}">Hủy</a></td>
		            
		        </tr>
		        
		    </c:forEach>
		    
		    <tr style ="border:0.5px solid grey">
		            <td style ="border:0.5px solid grey"></td>
		            <td style ="border:0.5px solid grey"></td>
		            <td style ="border:0.5px solid grey"></td>
		            <td style ="border:0.5px solid grey"></td>
		            <td style ="border:0.5px solid grey"></td>
		            <td style ="border:0.5px solid grey"></td>
		            <td style ="border:0.5px solid grey"></td>
					<td style ="border:0.5px solid grey"><strong>Tổng tiền: ${String.format("%,.0f",sum)}</strong></td>
		            
		            
		            
		   </tr>
		  
		        
		</table>
		<button class ="btn btn-success" style = "margin-left:86%;">Thanh Toán</button>
		</div>
		
	</c:when> 
	<c:otherwise>   
		Hông có
	</c:otherwise>
</c:choose>