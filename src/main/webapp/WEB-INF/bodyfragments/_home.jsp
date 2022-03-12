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
   
        <a href="">
            <div class="col-lg-3 col-md-6 col-sm-6" style = "padding-right: 0px;padding-left: 0px;">
                <div class="boxDiv">
                    <div class="warp-layout_item">
                        <p>HYUNDAI TUCSON NEW 2022 KM KHỦNG</p>

                        <div class="card" style="">

            
                            <img src="zzz" alt="" style="position:relative" />
                            <img src="~/images/unnamed.gif" style="position:absolute; top:1px; right:1px; height:40px; width:40px">
                          
                            <div class="card-body">
                                <label class="card-text">2022 - Mới - Bảo hành 36 tháng</label>
                            </div>

                            <div class="form-group" style="display:inline-flex;    margin-bottom: 5px;">
                             
                                    <p class="Coins-index" style="margin-right:20px; margin-left:10px"><i class="fas fa-coins"></i> 100.000.000đ</p>
                                
								
                                
                                
                            </div>
                            <div class="form-group" style="display:inline-flex;    margin-bottom: 0px;;    margin-top: 20px;">
                             
                                 <p class="" style="margin-right:10px; margin-left:0px"><i class="far fa-clock"></i> Honda - Thành phố Hồ Chí Minh</p>
								
                                
                                
                            </div>
                            
                        </div>



                    </div>
                </div>
            </div>
        </a>


	</div>
	<div class="btn_more"></div>
	    
    <h3>Tất cả</h3>
   
    
  			
  			<c:forEach var = "i" begin = "0" end = "${lstHD.size()-1}">
  			<div class="row">
				
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
                            <strong>Giá hợp đồng: </strong>${lstHD.get(i).getGIA()}
                        </p>
                    </div>    
                        
                    </div>
                    
                </div>
            
            </div>
			</c:forEach>
  			
        	
        
	
</div>



