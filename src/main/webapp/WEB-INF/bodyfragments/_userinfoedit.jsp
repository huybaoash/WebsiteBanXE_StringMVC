<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="version" value="1.0.0" scope="session" />
<c:set var="Account_present" value="${Account_present}" scope="session" />
<c:set var="Customer_present" value="${Customer_present}" scope="session" />


<style>
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
</style>

<form action = "userinfo-edit".htm" method="post" class = "form-horizontal" role = "form">

            <div class="form-horizontal">
                <h2>Chỉnh sửa thông tin cá nhân</h2>
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
                        <label for="FullName">Họ Tên</label>
                        <input type = "text" class = "form-control" id ="FullName" name = "FullName" value ="${Customer_present.getTENKH()}" /> 
                        
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-10">
                        <label for="HomeAdress">Địa chỉ</label>
                        <input type = "text" class = "form-control" id ="HomeAdress" name = "HomeAdress" value ="${Customer_present.getDIACHI()}"/> 
                    </div>
                </div>

               	<div class="check-Gender">
                    <label style="font-weight:bold">Giới Tính:</label>
                    
                    <c:choose>
				    <c:when test="${Customer_present.getGIOITINH() == 'Nam'}">
					       
					            <input checked="checked" id="Gender" name="Gender" type="radio" value="Nam" />
	                    		<label>Nam</label>
	                    		<input id="Gender" name="Gender" type="radio" value="Nữ" />
                    			<label>Nữ</label>
	                    		
				        
					    </c:when>    
					    <c:otherwise>
					       
				            	<input id="Gender" name="Gender" type="radio" value="Nam" />
	                    		<label>Nam</label>
	                    		<input checked="checked"  id="Gender" name="Gender" type="radio" value="Nữ" />
                    			<label>Nữ</label>
					    </c:otherwise>
					</c:choose>
                    
                    

                    
              	</div>
                
                
                 <hr/>
                
                <div class="form-group">
                    <div class="col-md-10">
                        <label for="CMND">CMND(*)</label>
                        <input class = "form-control" id ="CMND" name = "CMND" Type = "number" placeholder = "CMND mới có 12 số..." max = "999999999" value ="${Customer_present.getCMND()}" > 
                    </div>
                </div>

                <div class="form-group">
                   
                    <div class="col-md-10">
                        <label for="Email">Email</label>
                        <input id = "Email" name ="Email" class = "form-control" value ="${Customer_present.getEMAIL()}" />
                       
                    </div>
                </div>



                <div class="form-group">
                    <div class="col-md-10">
                        <label for="PhoneNumber">Số điện thoại (*)</label>
            			<input id = "PhoneNumber" name ="PhoneNumber" class = "form-control" Type = "number" placeholder = "SDT có 10 số..." max = "999999999" value ="${Customer_present.getSDT()}" /> 
            
                    </div>
                </div>
                     
                        
                 <div class="form-group">
                    <div class="col-md-10">
                        <button type="submit" class="btn btn-success" id="edit" name="edit">Lưu</button>
                    </div>
                </div>     
         	</div>


                

                
        
</form>