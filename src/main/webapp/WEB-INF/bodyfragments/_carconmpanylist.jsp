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
					<c:forEach var = "i" begin = "0" end = "${lstHangXE.size()-1}">
	                	<a href ="${pageContext.request.contextPath}//contract-list-searchbycarcompany?&MAHSX= ${lstHangXE.get(i).getMAHSX()}">
	                		<div id = "carcompany_item" class=" col-lg-4 col-md-4 col-sm-6 col-xs-12 " style = "border: 0.5pt solid black;height:180px">
	                            <div style = "text-align: center;">
	                            	<img src="${lstHangXE.get(i).getHINHANH()}" alt="${lstHangXE.get(i).getTENHSX()}" style="width:140px;height:140px">
		                		</div>
	                            
	                            <div style = "text-align: center;margin-top:10px  ">
	                            	<label>${lstHangXE.get(i).getTENHSX()}</label>
	                            </div>
	                        </div>
	                	</a>
	                        
	               </c:forEach>
	            </fieldset>
	</div>
</div>