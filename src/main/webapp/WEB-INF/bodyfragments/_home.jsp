<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
</div>