<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<style>
    .card-text{
        font-weight:inherit;
 
    }
    .card-text:hover{
        cursor:pointer;
    }
</style>

<div class="container tt">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->

		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<c:forEach var = "i" begin = "1" end = "${lstLoaiXE.size()-1}">
				<li data-target="#myCarousel" data-slide-to="${i}"></li>
			</c:forEach>
		</ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
			<div class="item active">
	                <img src="${lstLoaiXE.get(0).getHINHANH()}" alt="${lstLoaiXE.get(0).getTENLOAIXE()}" style="width:1600px;height:720px">
	                
	                <div class="carousel-caption">
	                    <h3>${lstLoaiXE.get(0).getTENLOAIXE()}</h3>
	                </div>
            </div>
            
            <c:forEach var = "i" begin = "1" end = "${lstLoaiXE.size()-1}">
				<div class="item">
		                <img src="${lstLoaiXE.get(i).getHINHANH()}" alt="${lstLoaiXE.get(i).getTENLOAIXE()}" style="width:1600px;height:720px">
		                <div class="carousel-caption">
		                    <h3>${lstLoaiXE.get(i).getTENLOAIXE()}</h3>
		                </div>
            	</div>
			</c:forEach>
				
			
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    
    <div class="row" id="RowTT">
    <h3>DÒNG XE MỚI NHẤT</h3>
   		<c:forEach var = "hopdong"  items = "${lstHD_top4_news}">
	        <a href="${pageContext.request.contextPath}/contract-details?&MAHD=${hopdong.getMAHD()}">
	            <div class="col-lg-3 col-md-6 col-sm-6" style = "padding-right: 0px;padding-left: 0px;">
	                <div class="boxDiv" style = "height: auto;">
	                    <div class="warp-layout_item">
	                        <p style="height: 30px;">${hopdong.getTENXE()}</p>
	
	                        <div class="card" style="">
	
	            
	                            <img src="${hopdong.getHINHANH()}" alt="" style="position:relative" />
	                            
	                            <div class="card-body">
	                                <label class="card-text">${hopdong.getNAMSANXUAT()} - Bảo hành ${hopdong.getBAOHANH()} tháng</label>
	                            </div>
	
	                            <div class="form-group" style="display:inline-flex;    margin-bottom: 5px;">
	                             
	                                    <p class="Coins-index" style="margin-right:20px; margin-left:10px"><i class="fas fa-coins"></i> ${String.format("%,.0f",hopdong.getGIA())}đ</p>
	                                
									
	                                
	                                
	                            </div>
	                            <div class="form-group" style="display:inline-flex;    margin-bottom: 0px;;    margin-top: 20px; ">
	                             
	                                 <p class="" style="margin-right:10px; margin-left:0px;height: 50px;">${hopdong.getTENHSX()} - ${hopdong.getTENLOAIXE()} - ${hopdong.getDIADIEM()}</p>
									
	                                
	                                
	                            </div>
	                            
	                        </div>
	
	
	
	                    </div>
	                </div>
	            </div>
	        </a>
		</c:forEach>

	</div>
	<div class="btn_more"></div>
	    
    <h3>Tất cả</h3>
   
    
  			
  			<c:forEach var = "i" begin = "0" end = "${lstHD.size()-1}">
  			<div class="row">
				<a href = "${pageContext.request.contextPath}/contract-details?&MAHD=${lstHD.get(i).getMAHD()}">
                <div class="panel panel-default" style="width: 900px" >
                    <div class="panel panel-heading">
                        ${lstHD.get(i).getTENXE()}
                    </div>
                    <div class="panel-body">
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    	<p>
                            <img src="${lstHD.get(i).getHINHANH()}" style="width: 120;height:120" />
                        </p> 
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-8 col-xs-12">
                    	<p>
                            <strong>Hãng sản xuất: </strong>${lstHD.get(i).getTENHSX()}
                        </p>
                        <p>
                            <strong>Loại xe: </strong>${lstHD.get(i).getTENLOAIXE()}
                        </p>
                        <p>
                            <strong>Giá hợp đồng: </strong>${String.format("%,.0f",lstHD.get(i).getGIA())}
                        </p>
                    </div> 
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <br/>
                            
                                
                                <a href="${pageContext.request.contextPath}/contract-cart-add?&MAHD=${lstHD.get(i).getMAHD()}" class="btn btn-warning" name = "btn_addtocart" type="submit"><i class="fa fa-shopping-cart" style="font-size:24px;"></i> Thêm vào giỏ hợp đồng</a>

                           
                            <br/>
                        </div>    
                        
                    </div>
                    
                </div>
            	</a>
            </div>
			</c:forEach>
  			
        	
        
	
</div>



