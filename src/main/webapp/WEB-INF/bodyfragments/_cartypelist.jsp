<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<<style>
#carcompany_item:hover {
  background-color: #F0F0F0;
}
</style>

<div class="container tt" style ="padding-right: 0px;padding-left: 200px;">
	<div class="col-md-10">
	            <fieldset>
					<c:forEach var = "i" begin = "0" end = "${lstLoaiXE.size()-1}">
	                <a href ="${pageContext.request.contextPath}///contract-list-searchbycartype?&MALOAIXE= ${lstLoaiXE.get(i).getMALOAIXE()}">
	                        <div id = "carcompany_item" class=" col-lg-4 col-md-4 col-sm-6 col-xs-12 " style = "border: 0.5pt solid black;height:180px">
	                            <div style = "text-align: center; ">
	                            	<img src="${lstLoaiXE.get(i).getHINHANH()}" alt="${lstLoaiXE.get(i).getTENLOAIXE()}" style="width:140px;height:140px">
		                		</div>
	                            
	                            <div style = "text-align: center; ">
	                            	<label>${lstLoaiXE.get(i).getTENLOAIXE()}</label>
	                            </div>
	                        </div>
	                </a>
	               </c:forEach>
	            </fieldset>
	</div>
</div>