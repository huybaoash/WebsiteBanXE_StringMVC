<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
    span {
    
        padding:0;
        float:none;
    }
    .formCreate {
        width: 70%;
        padding: 20px;
        border-radius: 5px;
    }
    #displayImg1 img {
        height: 50px;
        width: 50px;
        margin-right: 10px;
        display: inline-block;
        margin-top: 2px;
        margin-bottom: 2px;
    }
    .formall {
        display: flex;
        padding: 5px;
        font-family: Arial, Helvetica, sans-serif;
    }
    .Noidungmau {
        padding: 10px 10px;
    }
    .khungMau h4 {
        background-color: rgb(204, 204, 204);
        margin-top: 0;
        padding: 10px;
        font-weight: bold;
    }
    .NewsEX {
        height: 50%;
        width: 30%;
        margin-left: 2px;
        border: 1px solid lightgrey;
    }
    .Noidungmau a {
        text-decoration: none;
    }
</style>
<form action = "contract-edit.htm" method="post" enctype='multipart/form-data'>

<div class="container tt" style ="padding-right: 0px;padding-left: 100px;">
	<h2>LẬP HỢP ĐỒNG</h2>
            <hr>
            <input id = "MAHD" name ="MAHD"  Type = "text" style ="display:none;" value = "${hopdong.getMAHD()}" />
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
	
            <div class="formall">
                <div class="formCreate">

                    <div class="form-group">
                        <label for="TENXE">Tên Xe</label>
                        <input id = "TENXE" name ="TENXE" class = "form-control" placeholder = "Tên xe" value ="${Car_selling.getTENXE()}" required/> 
                        
                    </div>
                    
                    <div class="form-group">
                        <label for="MALOAIXE">Trạng thái hợp đồng:</label>
                                <select class="form-control" id="TRANGTHAI" name="TRANGTHAI" aria-invalid="false">
                                    
                                    	<c:choose>
		    
									      	<c:when test="${hopdong.getTRANGTHAI() eq 'Công khai'}">
									      		<option value="Công khai" selected> Công khai</option>
									      		<option value="Ẩn"> Ẩn</option>
									      		
									      	</c:when> 
									      	<c:otherwise>
									      		<option value="Công khai" > Công khai</option>
									      		<option value="Ẩn" selected> Ẩn</option>
									      	</c:otherwise>
									      </c:choose>
										
									
                                        
                                        
                                   
                                </select>
                                <span class="field-validation-valid text-danger" data-valmsg-for="MALOAIXE" data-valmsg-replace="true"></span>
                    </div>
                    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="MALOAIXE">Chọn loại xe:</label>
                                <select class="form-control" id="MALOAIXE" name="MALOAIXE" aria-invalid="false">
                                    <c:forEach var = "loaixe" begin = "0" items = "${lstCarType}">
                                    	<c:choose>
		    
									      	<c:when test="${loaixe.getMALOAIXE() == hopdong.getMALOAIXE()}">
									      		<option value="${loaixe.getMALOAIXE()}" selected> ${loaixe.getTENLOAIXE()}</option>
									      	</c:when> 
									      	<c:otherwise>
									      		<option value="${loaixe.getMALOAIXE()}"> ${loaixe.getTENLOAIXE()}</option>   
									      	</c:otherwise>
									      </c:choose>
										
									</c:forEach>
                                        
                                        
                                   
                                </select>
                                <span class="field-validation-valid text-danger" data-valmsg-for="MALOAIXE" data-valmsg-replace="true"></span>
                            </div>

                            

                        </div>

                    </div>

					<div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="MAHSX">Chọn hãng xe:</label>
                                <select class="form-control" id="MAHSX" name="MAHSX" aria-invalid="false">
                                    
                                        <c:forEach var = "hangxe" items = "${lstCarConmpany}">
											<c:choose>
		    
									      	<c:when test="${loaixe.getMAHSX() == hopdong.getMAHSX()}">
									      		<option value="${hangxe.getMAHSX()}" selected> ${hangxe.getTENHSX()}</option>
									      	</c:when> 
									      	<c:otherwise>
									      		<option value="${hangxe.getMAHSX()}"> ${hangxe.getTENHSX()}</option>   
									      	</c:otherwise>
									      </c:choose>
										</c:forEach>
                                        
                                   
                                </select>
                                <span class="field-validation-valid text-danger" data-valmsg-for="MAHSX" data-valmsg-replace="true"></span>
                            </div>

                            

                        </div>

                    </div>
					
                    

                    <div class="form-group">
                        <label for="NOIDUNGXE">Thông tin xe</label>
                        <textarea class = "form-control" cols="20" id="NOIDUNGXE" name="NOIDUNGXE" rows="10" placeholder = "Yêu cầu điền nội dung thông tin chính xác!" required>${Car_selling.getNOIDUNGXE()}</textarea>
                    </div>
					
					<div class="form-group">
                        <label for="NOIDUNGHD">Nôi dung hợp đồng</label>
                        <textarea class = "form-control" cols="20" id="NOIDUNGHD" name="NOIDUNGHD" rows="20" disabled>${hopdongtable.getNOIDUNGHD()} </textarea>
                    </div>
					
					<div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="BAOHANH">Bảo hành</label>
                                <input type = "number" max = "1200" min ="0" id = "BAOHANH" name ="BAOHANH" class = "form-control" placeholder = "Nhập số tháng bảo hành. Tối đa là 100 năm." required value ="${hopdong.getBAOHANH()}"/>                                
                            </div>

                            <div class="col-md-6">
                                <label for="NAMSANXUAT">Năm sản xuất</label>
                                <input type = "number" min = "1900" max = "9999" id = "NAMSANXUAT" name ="NAMSANXUAT" class = "form-control" placeholder = "Nhập năm sản xuất." required value = "${hopdong.getNAMSANXUAT()}"/>                                
                            </div>
                            
                        </div>
                    </div> 

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="GIAXE">Giá</label>
                                <input type = "number" id = "GIAXE" name ="GIAXE" class = "form-control" placeholder = "Nhập giá." min = "0" required value ="${String.format("%.0f",hopdong.getGIA())}"/>
                            </div>

                            <div class="col-md-9">
                                <label for=""DIADIEM"">Nơi bán</label>
								<input type = "text" id = "DIADIEM" name ="DIADIEM" class = "form-control" placeholder = "Vd: Tp.HCM, Hà Nôi" required value = "${hopdong.getDIADIEM()}"/>
                               
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="image1">Chọn hình <i style="color: rgb(122, 120, 120);font-weight: normal;"></i></label>
                                <input type="file" value="image1" name="image1" id="image1" title="Chọn đường dẫn hình ảnh" accept=".jpg" onchange="Images1FileAsURL()" />
                                <div id="displayImg1">
                                	<img src ="${Car_selling.getHINHANH()}" style="height: 240px;width:240px">
                                </div>
                            </div>

                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <div style="text-align: right">
                            <button type="submit" value="Thêm" id="CreateSP" class="btn btn-success">Thêm</button>
                        </div>
                    </div>
                </div>

                <div class="NewsEX">
                    <div class="khungMau">
                        <h4>Thông tin người bán</h4>
                        <div class="Noidungmau">
                        	<p>Tài khoản: <a> ${Account_present.getTENTK()} </a></p>
                            <p>Họ tên: <a> ${Customer_present.getTENKH()}</a></p>
                            <p>Số điện thoại: <a> ${Customer_present.getSDT()} </a></p>
                            <p>Email: <a> ${Customer_present.getEMAIL()} </a></p>
                        </div>
                        <hr>
                        
                    </div>
                </div>
            </div>
        </div>
  </form>      
        
        
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