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
	                
	                        <div id = "carcompany_item" class=" col-lg-4 col-md-4 col-sm-6 col-xs-12 " style = "border: 1pt solid black;">
	                            <div style = "text-align: center; ">
	                            	<img src="${lstHangXE.get(i).getHINHANH()}" alt="${lstHangXE.get(i).getTENHSX()}" style="width:120px;height:120px">
		                		</div>
	                            
	                            <div style = "text-align: center; ">
	                            	<label>${lstHangXE.get(i).getTENHSX()}</label>
	                            </div>
	                        </div>
	               </c:forEach>
	            </fieldset>
	</div>
</div>