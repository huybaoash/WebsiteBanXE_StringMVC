<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
    table {
         border-collapse: inherit; 
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
    #menu{
        margin-left:0;
        margin-right:0;
    }
    th{
        background-color:#a0d1f6;
    }
    tr:hover {
        background-color: #eeeeee;
    }
 </style>
	
<%-- 	<c:choose>
		<c:when>
		</c:when>
		<c:otherwise>
		</c:otherwise>
</c:choose> --%>


<c:choose>
	    
	<c:when test="${Account_present.getCHUCVU() eq 'Người Quản Trị'}">
	<div class="container tt">	
		 <div id="menu">
		    <ul class="menu-list" style = "display:flex;  list-style:none;">
		        <li class="menu-item">
		            <a href="${pageContext.request.contextPath}/contract-list-admin">Hợp đồng</a>
		        </li>
		
		        <li class="menu-item">
		            <a href="${pageContext.request.contextPath}/cartype-list-admin">Loại xe</a>
		        </li>
		
		        <li class="menu-item">
		            <a href="${pageContext.request.contextPath}/carconmpany-list-admin">Hãng sản xuất</a>
		        </li>
		
		        <li class="menu-item">
		            <a href="${pageContext.request.contextPath}/account-list">Người dùng</a>
		        </li>
		
		        
			    
			    
		    </ul>
		    <p style="margin-top:10px;display:inline-flex">
     
			        <input type="text" name="searchString" value="" class="form-control" style="width:500px;margin-right:5px"  placeholder="Tìm kiếm theo tiêu đề"/>
			        <button type="submit" class="btn btn-primary" style="padding:0px 30px"> <i class="fas fa-search"></i> </button>
			    </p>
		</div>
		
		<table class="table">
		    <tr style ="border:0.5px solid grey">
		        <th style="width:10%; text-align:left;border:0.5px solid grey"> <label>Mã hợp đồng</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Tên người bán</label></th>
		        <th style="width:5%; text-align:left;border:0.5px solid grey"><label>Mã xe</label></th>
		        <th style="width:20%; text-align:left;border:0.5px solid grey"><label>Tên xe</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Ngày lập</label></th>
		        <th style="width:10%; text-align:left;border:0.5px solid grey"><label>Giá</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Địa điểm</label></th>
		        <th style="width:15%; text-align:left;border:0.5px solid grey"><label>Trạng thái</label></th>
		        <th style="text-align:left;border:0.5px solid grey"><label>Tác vụ</label></th>
		    </tr>
			<c:forEach var = "hopdong"  items = "${lstHD}">
		    
		        <tr style ="border:0.5px solid grey">
		            <td style ="border:0.5px solid grey">${hopdong.getMAHD()}</td>
		            <td style ="border:0.5px solid grey"><a href="${pageContext.request.contextPath}/otheruserinfo?&MATK= ${hopdong.getMATK()}">${hopdong.getTENTK()}</a></td>
		            <td style ="border:0.5px solid grey">${hopdong.getMAXE()}</td>
		            <td style ="border:0.5px solid grey"><a href="">${hopdong.getTENXE()}</a></td>
		            <td style ="border:0.5px solid grey">${hopdong.getNGAYLAP()}</td>
		            <td style ="border:0.5px solid grey">${String.format("%,.0f",hopdong.getGIA())}</td>
		            <td style ="border:0.5px solid grey">${hopdong.getDIADIEM()}</td>
		            <td style ="border:0.5px solid grey">${hopdong.getTRANGTHAI()}</td>
		            <td style ="border:0.5px solid grey">
		            	<c:choose>
								<c:when test="${hopdong.getTRANGTHAI() eq 'Công khai'}">
									<a href="${pageContext.request.contextPath}/contrac-list-hide?&MAHD=${hopdong.getMAHD()}" class="btn btn-success btn-sm" onclick="lockTT()"><i class="fas fa-unlock-alt"></i> Khóa hợp đồng ?</a>
								</c:when>
								<c:otherwise>
									<c:choose>
											<c:when test="${hopdong.getTRANGTHAI() eq 'Đã khóa'}">
												<a href="${pageContext.request.contextPath}/contrac-list-show?&MAHD=${hopdong.getMAHD()}" class="btn btn-success btn-sm" onclick="unblockTT()"><i class="fas fa-unlock-alt"></i> Mở khóa</a>
											</c:when>
											<c:otherwise>
												<a class="btn btn-success btn-sm" > Đã hoàn tất giao dịch</a>
											</c:otherwise>
									</c:choose>
		            
								</c:otherwise>
						</c:choose>
		            	
		            </td>
		        </tr>
		    </c:forEach>
		</table>
		</div>
	</c:when> 
	<c:otherwise>   
		Hông có
	</c:otherwise>
</c:choose>

<script>
function unblockTT() {
  alert("Đã mở khóa !");
    }
    
</script>

<script>
function lockTT() {
        alert("Đã khóa !");
    }
</script>
  			
        	