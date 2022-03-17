<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
    h2 {
        font-family: Arial;
    }
    .check-Gender {
        display: flex;
        padding-left: 20px;
    }
        .check-Gender label {
            margin-right: 20px;
            font-weight: normal;
        }
    .form-horizontal {
        width: 50%;
        margin: auto;
        border: 1px solid #dcdcdc;
        border-radius: 5px;
        padding-left: 30px;
        padding-right: 30px;    
        background-color:#f6f6f6;
    }
    /* Chrome, Safari, Edge, Opera */
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    /* Firefox */
    input[type=number] {
        -moz-appearance: textfield;
    }
    span {
        
        padding: 0;
        float: none;
    }
</style>
<form action = "register.htm" method="post" class = "form-horizontal" role = "form">

    <h2>Tạo tài khoản.</h2>
    <hr />
    <c:choose>
    	<c:when test="${message_validation != null}">
	        <c:forEach var = "i" begin = "0" end = "${message_validation.size()-1}">
	     		<label for="Validation" class="text-danger" style="margin-left:0px">${message_validation.get(i)}</label>
                 <br />     
			</c:forEach>
	    </c:when>    
	    <c:otherwise>
	        
	    </c:otherwise>
	</c:choose>
    
	<hr />
    
    <div class="form-group">
        <div class="col-md-10">
            <label for="UserName">Tên tài khoản(*)</label>
            <input for="UserName" id = "UserName" name ="UserName" class = "form-control" maxlength = "20" value ="${account.getTENTK()}" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-md-10">
            <label for="FullName">Họ tên(*)</label>
            <input for="FullName"  id = "FullName" name ="FullName" class = "form-control" value ="${customer.getTENKH()}" />
        </div>

    </div>

    <div class="form-group">
        <div class="check-Gender">
            <label style="font-weight:bold">Giới Tính:</label>
            <input id="Gender"
                   name="Gender"
                   type="radio"
                   value="Nam" />
            <label>Nam</label>
            <input id="Gender"
                   name="Gender"
                   type="radio"
                   value="Nữ" />
            <label>Nữ</label>
        </div>
    </div>


    <div class="form-group">
         <div class="col-md-10">
            <label for="HomeAdress">Địa chỉ(*)</label>
            <input for="HomeAdress"  id = "HomeAdress" name ="HomeAdress" class = "form-control" value ="${customer.getDIACHI()}" /> 
        </div>
    </div>


    <div class="form-group">
        <div class="col-md-10">
            <label for="CMND">CMND(*)</label>
            <input for="CMND"  id = "CMND" name ="CMND" class = "form-control" Type = "number" placeholder = "CMND mới có 12 số...", max = "999999999999" value ="${customer.getCMND()}" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-md-10">
            <label for="PhoneNumber">Số điện thoại (*)</label>
            <input for="PhoneNumber"  id = "PhoneNumber" name ="PhoneNumber" class = "form-control" Type = "number" placeholder = "SDT có 10 số..." max = "999999999" value ="${customer.getCMND()}" /> 
            
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-10">
            <label for="Email">Email (*)</label>
            <input for="Email"  id = "Email" name ="Email" class = "form-control" value ="${customer.getEMAIL()}" /> 
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-10">
            <label for="Password">Mật khẩu (*)</label>
            <input type ="password" class = "form-control" id = "Password" name = "Password" >
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-10">
            <label for="ConfirmPassword">Xác nhận mật khẩu (*)</label>
            <input type ="password" class = "form-control" id = "ConfirmPassword" name = "ConfirmPassword" >
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-10">
            <button type="submit" class="btn btn-success" id="register" name="register">Đăng ký</button>
        </div>
    </div>
</form>



