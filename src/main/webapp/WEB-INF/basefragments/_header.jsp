<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container-fluid">
        <!-- <h1>Hello World!</h1>
        <p>Resize the browser window to see the effect.</p>
        <p>The columns will automatically stack on top of each other when the screen is less than 768px wide.</p> -->
        <div class="row" style="background-color:#f8eae2">
            <div class="col-sm-1"></div>
            <div class="col-sm-4" style="margin-top:12px;padding-left:200px">
                <a href="">
                    <img src="~/images/logo6060.png" alt="" style="height:50px; width:120px;" />
                </a>
            </div>

            <div class="col-sm-7">
                
                <div style="margin-top:20px;text-align:center;padding-left:30%">
                    <a style="color:white;text-decoration:none" href="">
                        <button class="btn-DT btn--warn"><i class="far fa-plus-square"></i> ĐĂNG TIN NGAY</button>
                    </a>

                  
                </div>

            </div>

        </div>

    </div>


    <div class="menu">
        <ul>

            <li style="font-weight:bold"><a class="fas fa-hotel">TRANG CHỦ</a></li>
            <li style="font-weight:bold"><a class="fas fa-hammer"> Sản phẩm</a></li>
            <li style="font-weight:bold"><a class="fab fa-servicestack"> Dịch vụ"</a></li>
            <li style="font-weight:bold"><a><i class="fas fa-dice-d20"></i>Việc làm</a></li>

			<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/">Home</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/index">Index</a></li>
       		<li style="font-weight:bold"><a href="${pageContext.request.contextPath}/helloworld">Hello World !</a></li>
       		
        </ul>
        <ul>
            <li><a>Giới thiệu</a></li>
            <li><a>Góp ý</a></li>
            
        </ul>
    </div>
    