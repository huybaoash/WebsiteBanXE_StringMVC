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
		</div>
		<form action = "cartype-edit.htm" method="post" enctype='multipart/form-data'>
		
		<div class="form-horizontal">
		    <h2>Chỉnh sửa</h2>
		    <h4>Loại xe</h4>
		    <hr />
		    
		    <div class="form-group">
		        <input style="display:none;" id = "MALOAIXE" name ="MALOAIXE" value ="${loaixe.getMALOAIXE()}"/>
		        <div class="col-md-10">
		            <label for="TENLOAIXE">Tên loại xe</label>
            		<input required  id = "TENLOAIXE" name ="TENLOAIXE" class = "form-control" Type = "text" placeholder = "Vd: Dòng xe SUV" value = "${loaixe.getTENLOAIXE()}"/>
		        </div>
		        
		        <div class="col-md-10">
		            <label for="image1">Chọn hình <i style="color: rgb(122, 120, 120);font-weight: normal;"></i></label>
                    <input type="file" name="image1" id="image1" title="Chọn đường dẫn hình ảnh" accept=".jpg" onchange="Images1FileAsURL()" />
                    <div id="displayImg1">
                    	<img src ="${loaixe.getHINHANH()}" style="height: 240px;width:240px">
                    </div>
		        </div>
		    </div>
		
		    <div>
		        <div>
		            <button type="submit" class="btn btn-primary">Sửa</button>
		            <a href="/WebBanXE/cartype-list-admin" class="btn btn-primary"> Trở lại danh sách </a>
		        </div>
		    </div>
		</div>
		</form>
		</div>
		
	</c:when> 
	<c:otherwise>   
		Hông có
	</c:otherwise>
</c:choose>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
<script>
	 function Images1FileAsURL() {
	     var fileSelected = document.getElementById('image1').files;
	     if (fileSelected.length > 0) {
	         for (var i = 0; i < fileSelected.length; i++) {
	             var fileToLoad = fileSelected[i];
	             var fileReader = new FileReader();
	             fileReader.onload = function (fileLoaderEvent) {
	                 var srcData = fileLoaderEvent.target.result;
	                 var newImage = document.createElement('img');
	                 newImage.src = srcData;
	                 document.getElementById('displayImg1').innerHTML += newImage.outerHTML;
	             }
	             fileReader.readAsDataURL(fileToLoad);
	         }
	     }
	 }
</script> 