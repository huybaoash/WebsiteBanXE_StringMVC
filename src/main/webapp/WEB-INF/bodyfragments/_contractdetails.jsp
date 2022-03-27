<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
	.small-container1{
    max-width: 100%;
    border: 1px solid rgb(240, 239, 239);
    
	}
	.row_Detail{
	    align-items: center;   
	}
	.single-product{
	    margin: 0px 0px 0px 0px;
	 
	}
	 .small-img-row{
	    display: flex;
	}
	
	.small-img-col {
	    margin-right: 5px;
	    margin-top: 5px;
	    cursor: pointer;
	}
	
	    .small-img-col img {
	        width: 150px;
	        height: 80px;
	    }
	
	
	.single-product .col-2_{
	    padding: 20px;
	  
	}
	.Content_Details{
	    min-width:300px;
	}
	.col-2_ h1{
	    font-size: 25px;
	    margin: 25px 0;
	}
	.CMT {
	    margin-top: 15px;
	    padding: 6px;
	}
	
	/*.Update {
	    margin-left: 75%;
	}*/
	
	.TheLoai{
	    text-align: left;
	    color: rgb(41, 41, 41);
	    background-color: rgb(212, 208, 208);
	    font-size:18px;
	  
	}
	.col-addr{
	    float: left;
	    width: 50%;
	    padding-left: 10px;
	   
	}
	.row-inf:after {
	    content: "";
	    display: table;
	    clear: both;
	    }
	
	.col-addr .infor p{
	    font-size: 14px;
	}
	
	.small-img-rowDV {
	    display: flex;
	} 
	
	.small-img-colDV {
	    margin-right: 5px;
	    margin-top: 5px;
	    cursor: pointer;
	}
	
	    .small-img-colDV img {
	        width: 150px;
	        height: 80px;
	    }
	
	/* 
	    .col-addr .infor p i {
	    color: orangered;
	    font-size: 18px;
	}
	*/
	
	.col-addr .infor p .fa-user-circle {
	    font-size: 18px;
	    color:black;
	}
	
	.fa-phone-square-alt {
	    font-size: 18px;
	    color:blue;
	}
	
	.fa-envelope-square {
	    font-size: 18px;
	    color:#e36523;
	}
	.fa-map-marker-alt {
	    font-size: 18px;
	    color:red;
	}
	
	
</style>

<div class="container tt" style ="padding-right: 15px;padding-left: 15px;">

	<div class="small-container1 single-product">
        <div class="row_Detail">
            <div class="TheLoai">
                Hãng xe

                <a href="">${hopdong.getTENHSX()}</a> >
                <a href="">${hopdong.getTENLOAIXE()}</a>

            </div>

            <div class="Khung-img" style="width: 55%;background-color:  #f5ebeb; margin: 5px auto;">




                <div class="img">
                    <img src="${hopdong.getHINHANH()}" width="100%" height="500px" id="ProductImg">

                </div>
            </div>


            <hr style=" margin: 0px 10px; background-color: black;">

            <div class="col-2_">
                <div class="row-inf">
                    <div class="col-addr">
                        <p><strong>Mã Hợp Đồng: ${hopdong.getMAHD()} </strong></p>
                    </div>

                    <div class="col-addr" style="text-align:right">
                        <p class="Update">Ngày đăng: ${hopdong.getNGAYLAP()}</p>
							<c:choose>
         
						         <c:when test = "${Account_present.getMATK() == hopdong.getMATK()}">
						            <a href="">Tin của bạn:</strong>[<i>Chỉnh sửa ngay</i>]</a>
						         </c:when>
						         
						         
						         
						         <c:otherwise>
						            
					         	</c:otherwise>
					      </c:choose>
                                

                    </div>
                </div>

                <h1>${hopdong.getTENXE()}</h1>
                <div class="row-inf">
                    <div class="col-addr">
                        <div class="infor" style="display:flex;">
                            <p style="padding-right: 30px"><i class="fas fa-user-circle"></i> ${hopdong.getTENTK()} </p>
                            <a href="">Xem trang >></a>
                        </div>

                        <div class="infor"><p><i class="fas fa-phone-square-alt"></i> ${Customer_selling.getSDT()}</p></div>
                    </div>

                    <div class="col-addr">
                        <div class="infor"> <p><i class="fas fa-envelope-square"></i> ${Customer_selling.getEMAIL()} </p> </div>
                        <div class="infor"><p> <i class="fas fa-map-marker-alt"></i> ${hopdong.getDIADIEM()}</p></div>
                    </div>
                </div>


                <h4 style="font-weight:bold">Nội dung</h4>
                <div style="border: 1px solid rgba(220, 220, 221, 0.918); padding: 20px;background-color:rgba(220, 220, 221, 0.918);border-radius:4px;">
                    <p style="font-size:16px">
                        ${Car_selling.getNOIDUNGXE()}
                    </p>
                </div>
                </br>
				
				<div style="height: 240px;">
                	<div class="inf-more" style="margin-top: 10px; ">
                	<p style= "display:inline;">
	                    <h4 style="font-weight:bold; width:200px; display:inline;padding-right:400px"> Thông tin sản phẩm </h4>
	                    	<c:choose>
	                    		<c:when test="${hopdong.getTRANGTHAI() eq 'Hoàn tất giao dịch'}">
	                    			<a class ="btn btn-warning" style = "padding-top:10px">
		                  				 Hoàn tất giao dịch
		                  			</a> 
	                    		</c:when>
	                    		<c:otherwise>
	                    			<a href="${pageContext.request.contextPath}/contract-cart-add?&MAHD=${hopdong.getMAHD()}" class ="btn btn-warning" style = "padding-top:10px">
		                  				<i class="	fa fa-cart-plus"></i> THÊM VÀO GIỎ HỢP ĐỒNG
		                  			</a> 
	                    		</c:otherwise>
	                    	</c:choose>
                  			     
	                
                    </p>
                    
                    <div class="col-addr">
                        <div style="padding-left: 10px; line-height: 0.8rem;padding-top:10px;">
                        	<p style="font-size:16px">Giá: <strong style="color:orangered"> ${String.format("%,.0f",hopdong.getGIA())} đ </strong> </p>
                        </div>
                        
                        <div style="padding-left: 10px; line-height: 0.8rem;padding-top:10px;">
	                        <p style="font-size:16px">Năm sản xuất: ${hopdong.getNAMSANXUAT()}</p>
	
	                    </div> 
	                                           
                        <div style="padding-left: 10px; line-height: 0.8rem;padding-top:10px;">
	                        <p style="font-size:16px">Bảo hành: ${hopdong.getBAOHANH()} tháng </p>
	
	                    </div>
	                    
	                    <div style="padding-left: 10px; line-height: 0.8rem;padding-top:10px;">
	                        <p style="font-size:16px">Loại xe: ${hopdong.getTENLOAIXE()}</p>
	
	                    </div>
	                    
	                    <div style="padding-left: 10px; line-height: 0.8rem;padding-top:10px;">
	                        <p style="font-size:16px">Hãng: ${hopdong.getTENHSX()}</p>
	
	                    </div>
                    </div>
	            </div>
						
	  						
	                    
	                    
         	</div>
                    
                    
                    
                    
                    <hr />
    	</div>
	</div>
</div>


        
                <div style="padding:10px">
                    <div style="height:50px;border:1px solid #dfdfdf;padding-left:10px;padding-top:5px;background-color:#8785ea">
                        <h4 style="font-weight:bold;color:#e3e2e2">Bình luận</h4>
                    </div>

                    <ul style="border:1px solid lightgray;padding-left:10px">

                            <br />

                            <p style= "display: inline; "><b>huybaoash@gmail.com</b>
                            23/01/2022
                            <a href="">Xóa</a>
                           
                            </p>
                            

                                
                            <br />

                            <p style= "padding-top:10px;">Nội dung 1,2,3,4,5,6,7,8,9</p>

                 
                    </ul>
                    <hr />
                    
                    <c:choose>
                    	<c:when test= "${Account_present == null || Account_present.getTENTK().isEmpty() }">
                    		<i style="color:#fd9f26;font-size:16px;padding-left:10px">
                        		[Bạn phải đăng nhập mới có thế bình luận.]
                    		</i>
                    	</c:when>
                    	
                    	<c:otherwise>
                    		 
                    		<div class="CMT">
		                        <form class="form-inline" action="">
		                            <label for="cmt" style="margin-right: 5px;">${Account_present.getTENTK()}</label>
		                            <input type="text" class="form-control" id="TinTucId" name="TinTucId" style="margin-right: 5px;display:none;" value="@Model.IdTinTucs"/>
		                            </br>
		                            <textarea class="form-control text-box single-line" placeholder="Bình luận ..." id="Description" name="Description" style ="width: 100%;height:120px;" ></textarea>
		
		                            <button class="btn btn-primary" style="margin-top:5px;margin-left:95.5%">Gửi</button>
		                        </form>
	                    	</div>
                    	</c:otherwise>
                    </c:choose>
                    
                    


                </div>
         
   