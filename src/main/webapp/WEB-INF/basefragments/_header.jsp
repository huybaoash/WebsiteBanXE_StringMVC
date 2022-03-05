<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container-fluid">
        <!-- <h1>Hello World!</h1>
        <p>Resize the browser window to see the effect.</p>
        <p>The columns will automatically stack on top of each other when the screen is less than 768px wide.</p> -->
        <div class="row" style="background-color:#f8eae2">
            
            <div class="col-sm-4" style="margin-top:0px">
                <a href="">
                    <img src="~/images/logo6060.png" alt="" style="height:20px; width:120px;" />
                </a>
            </div>
            
       		<div class="col-sm-4">
                <form action="" class="search-form">
                    <div class="form-group has-feedback">
                        <label for="search" class="sr-only">Search</label>
                        <input type="text" class="form-control" name="search" id="search" placeholder="search">
                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                    </div>
                </form>
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


    <div class="menu">
        <ul>

            <li style="font-weight:bold"><a class="fas fa-hotel" href="${pageContext.request.contextPath}/">TRANG CHỦ</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/carconmpany-list">Hãng sản xuất</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/contract-list">Năm sản xuất</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/contract-register">Đăng ký bán xe</a></li>
       		
       		
        </ul>
        <ul>
            <li><a class = "fas fa-user-circle" href = "${pageContext.request.contextPath}/login">Đăng nhập</a></li>
        	
        	<li><a class = "fas fa-user-plus" href = "${pageContext.request.contextPath}/register">Đăng ký</a></li>
            
        </ul>
        
    </div>
    